package jwd.modul3test.service;

import java.util.List;

import org.springframework.data.domain.Page;

import jwd.modul3test.model.Zadatak;

public interface ZadatakService {

	Zadatak findOne(Long id);
	
	Page<Zadatak> findAll(int pageNum);
	
	Zadatak save(Zadatak zadatak);
	
	List<Zadatak> save(List<Zadatak> zadaci);
	
	Zadatak delete(Long id);
	
	void delete(List<Long> ids);

}
