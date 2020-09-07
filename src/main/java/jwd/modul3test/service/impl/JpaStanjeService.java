package jwd.modul3test.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.modul3test.model.Stanje;
import jwd.modul3test.repository.StanjeRepository;
import jwd.modul3test.service.StanjeService;

@Service
@Transactional
public class JpaStanjeService implements StanjeService {

	@Autowired
	private StanjeRepository stanjeRepository;
	
	@Override
	public Stanje findOne(Long id) {
		return stanjeRepository.findOne(id);
	}

	@Override
	public List<Stanje> findAll() {
		return stanjeRepository.findAll();
	}

	@Override
	public Stanje save(Stanje stanje) {
		return stanjeRepository.save(stanje);
	}

	@Override
	public List<Stanje> save(List<Stanje> stanja) {
		return stanjeRepository.save(stanja);
	}

	@Override
	public Stanje delete(Long id) {
		Stanje stanje = stanjeRepository.findOne(id);
		if(stanje == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant activity");
		}
		stanjeRepository.delete(stanje);
		return stanje;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}

}
