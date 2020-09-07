package jwd.modul3test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.modul3test.model.Sprint;
import jwd.modul3test.web.dto.SprintDTO;

@Component
public class SprintToSprintDTO implements Converter<Sprint, SprintDTO> {

	@Override
	public SprintDTO convert(Sprint sprint) {
		if(sprint==null){
			return null;
		}
		
		SprintDTO dto = new SprintDTO();
		
		dto.setId(sprint.getId());
		dto.setIme(sprint.getIme());
		
		return dto;
	}
	
	public List<SprintDTO> convert(List<Sprint> sprintovi){
		List<SprintDTO> ret = new ArrayList<>();
		
		for(Sprint s: sprintovi){
			ret.add(convert(s));
		}
		
		return ret;
	}

}
