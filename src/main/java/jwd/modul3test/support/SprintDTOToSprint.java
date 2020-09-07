package jwd.modul3test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.modul3test.model.Sprint;
import jwd.modul3test.service.SprintService;
import jwd.modul3test.web.dto.SprintDTO;

@Component
public class SprintDTOToSprint implements Converter<SprintDTO, Sprint> {

	@Autowired
	SprintService sprintService;

	@Override
	public Sprint convert(SprintDTO dto) {
		Sprint sprint = null;
		
		if(dto.getId()!=null){
			sprint = sprintService.findOne(dto.getId());
			
			if(sprint == null){
				throw new IllegalStateException("Tried to "
						+ "modify a non-existant activity");
			}
		}
		else {
			sprint = new Sprint();
		}
		
		sprint.setId(dto.getId());
		sprint.setIme(dto.getIme());
		
		return sprint;
	}
	
	public List<Sprint> convert (List<SprintDTO> dtoSprintovi){
		List<Sprint> sprintovi = new ArrayList<>();
		
		for(SprintDTO dto : dtoSprintovi){
			sprintovi.add(convert(dto));
		}
		
		return sprintovi;
	}
}
