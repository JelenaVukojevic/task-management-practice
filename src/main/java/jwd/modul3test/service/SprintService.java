package jwd.modul3test.service;

import java.util.List;

import jwd.modul3test.model.Sprint;


public interface SprintService {

	Sprint findOne(Long id);
	
	List<Sprint> findAll();
	
	Sprint save(Sprint sprint);
	
	List<Sprint> save(List<Sprint> sprintovi);
	
	Sprint delete(Long id);
	
	void delete(List<Long> ids);

}
