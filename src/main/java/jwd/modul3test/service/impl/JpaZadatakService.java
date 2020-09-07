package jwd.modul3test.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.modul3test.model.Zadatak;
import jwd.modul3test.repository.ZadatakRepository;
import jwd.modul3test.service.ZadatakService;

@Service
@Transactional
public class JpaZadatakService implements ZadatakService {

	@Autowired
	private ZadatakRepository zadatakRepository;
	
	@Override
	public Zadatak findOne(Long id) {
		return zadatakRepository.findOne(id);
	}

	@Override
	public Page<Zadatak> findAll(int pageNum) {
		return zadatakRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Zadatak save(Zadatak zadatak) {
		return zadatakRepository.save(zadatak);
	}

	@Override
	public List<Zadatak> save(List<Zadatak> zadaci) {
		return zadatakRepository.save(zadaci);
	}

	@Override
	public Zadatak delete(Long id) {
		Zadatak zadatak = zadatakRepository.findOne(id);
		if(zadatak == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant activity");
		}
		zadatakRepository.delete(zadatak);
		return zadatak;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}

}
