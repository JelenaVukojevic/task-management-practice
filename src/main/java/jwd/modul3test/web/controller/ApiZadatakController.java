package jwd.modul3test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.modul3test.model.Zadatak;
import jwd.modul3test.service.ZadatakService;
import jwd.modul3test.support.ZadatakDTOToZadatak;
import jwd.modul3test.support.ZadatakToZadatakDTO;
import jwd.modul3test.web.dto.ZadatakDTO;

@RestController
@RequestMapping(value="/api/zadaci")
public class ApiZadatakController {
	
	@Autowired
	private ZadatakService zadatakService;
	
	@Autowired
	private ZadatakToZadatakDTO toDTO;
	
	@Autowired
	private ZadatakDTOToZadatak toZadatak;
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<ZadatakDTO>> getZadaci(@RequestParam(value="pageNum", defaultValue="0") int pageNum){
		
		Page<Zadatak> zadaciPage = null;
		
		zadaciPage = zadatakService.findAll(pageNum);

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(zadaciPage.getTotalPages()) );
		
		return new ResponseEntity<>(toDTO.convert(zadaciPage.getContent()), headers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<ZadatakDTO> getZadatak(@PathVariable Long id){
		Zadatak zadatak = zadatakService.findOne(id);
		if(zadatak==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(toDTO.convert(zadatak), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ZadatakDTO> add(@Validated @RequestBody ZadatakDTO newZadatakDTO){
	
		if(newZadatakDTO.getIme() != "" 
				&& newZadatakDTO.getIme() != null 
				&& newZadatakDTO.getIme().length() > 40
				&& newZadatakDTO.getBodovi() > 0
				&& newZadatakDTO.getBodovi() < 20) {
			Zadatak savedZadatak = zadatakService.save(toZadatak.convert(newZadatakDTO));
			
			savedZadatak.getSprint().setUkupnoBodova(savedZadatak.getBodovi() + newZadatakDTO.getBodovi());
			
			return new ResponseEntity<>(toDTO.convert(savedZadatak), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes="application/json")
	public ResponseEntity<ZadatakDTO> edit(@Validated @RequestBody ZadatakDTO zadatakDTO, @PathVariable Long id){
		
		if(!id.equals(zadatakDTO.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		int oldZadatakBodovi = zadatakService.findOne(id).getBodovi();
		int newZadatakBodovi = zadatakDTO.getBodovi();
		int razlikaBodova = oldZadatakBodovi - newZadatakBodovi;
		
		Zadatak persisted = zadatakService.save(toZadatak.convert(zadatakDTO));
		
//		persisted.getSprint().setUkupnoBodova(persisted.getSprint().getUkupnoBodova() + razlikaBodova);
		
		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<ZadatakDTO> delete(@PathVariable Long id){
		Zadatak deleted = zadatakService.delete(id);
		
		if(deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
//		deleted.getSprint().setUkupnoBodova(deleted.getSprint().getUkupnoBodova() - deleted.getBodovi());
		
		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
	}
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
