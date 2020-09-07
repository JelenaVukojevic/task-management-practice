package jwd.modul3test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.modul3test.model.Stanje;
import jwd.modul3test.web.dto.StanjeDTO;

@Component
public class StanjeToStanjeDTO implements Converter<Stanje, StanjeDTO> {

	@Override
	public StanjeDTO convert(Stanje stanje) {
		if(stanje==null){
			return null;
		}
		
		StanjeDTO dto = new StanjeDTO();
		
		dto.setId(stanje.getId());
		dto.setIme(stanje.getIme());
		
		return dto;
	}
	
	public List<StanjeDTO> convert(List<Stanje> stanja){
		List<StanjeDTO> ret = new ArrayList<>();
		
		for(Stanje s: stanja){
			ret.add(convert(s));
		}
		
		return ret;
	}

}
