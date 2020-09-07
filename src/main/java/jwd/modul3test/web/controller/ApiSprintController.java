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

import jwd.modul3test.model.Sprint;
import jwd.modul3test.service.SprintService;
import jwd.modul3test.support.SprintToSprintDTO;
import jwd.modul3test.web.dto.SprintDTO;

@RestController
@RequestMapping(value="/api/sprintovi")
public class ApiSprintController {

	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private SprintToSprintDTO toDTO;
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<SprintDTO>> getSprintovi(){
		
		List<Sprint> sprintovi;
		
		sprintovi = sprintService.findAll();

		return new ResponseEntity<>(toDTO.convert(sprintovi), HttpStatus.OK);
	}
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
