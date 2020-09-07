package jwd.modul3test.service;

import java.util.List;

import jwd.modul3test.model.Stanje;


public interface StanjeService {

	Stanje findOne(Long id);
	
	List<Stanje> findAll();
	
	Stanje save(Stanje stanje);
	
	List<Stanje> save(List<Stanje> stanja);
	
	Stanje delete(Long id);
	
	void delete(List<Long> ids);

}
