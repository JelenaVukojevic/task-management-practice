package jwd.modul3test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

import jwd.modul3test.model.Sprint;
import jwd.modul3test.repository.SprintRepository;
import jwd.modul3test.service.SprintService;

@Service
@Transactional
public class JpaSprintService implements SprintService {
	
	@Autowired
	private SprintRepository sprintRepository;

	@Override
	public Sprint findOne(Long id) {
		return sprintRepository.findOne(id);
	}

	@Override
	public List<Sprint> findAll() {
		return sprintRepository.findAll();
	}

	@Override
	public Sprint save(Sprint sprint) {
		return sprintRepository.save(sprint);
	}

	@Override
	public List<Sprint> save(List<Sprint> sprintovi) {
		return sprintRepository.save(sprintovi);
	}

	@Override
	public Sprint delete(Long id) {
		Sprint sprint = sprintRepository.findOne(id);
		if(sprint == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant activity");
		}
		sprintRepository.delete(sprint);
		return sprint;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}
}
