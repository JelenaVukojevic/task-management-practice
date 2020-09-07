package jwd.modul3test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.modul3test.model.Stanje;
import jwd.modul3test.service.StanjeService;
import jwd.modul3test.support.StanjeToStanjeDTO;
import jwd.modul3test.web.dto.StanjeDTO;

@RestController
@RequestMapping(value="/api/stanja")
public class ApiStanjeController {

	@Autowired
	private StanjeService stanjeService;
	
	@Autowired
	private StanjeToStanjeDTO toDTO;
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<StanjeDTO>> getStanja(){
		
		List<Stanje> stanja;
		
		stanja = stanjeService.findAll();

		return new ResponseEntity<>(toDTO.convert(stanja), HttpStatus.OK);
	}
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
