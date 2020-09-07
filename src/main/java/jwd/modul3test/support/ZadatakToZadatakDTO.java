package jwd.modul3test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.modul3test.model.Zadatak;
import jwd.modul3test.web.dto.ZadatakDTO;

@Component
public class ZadatakToZadatakDTO implements Converter<Zadatak, ZadatakDTO> {

	@Override
	public ZadatakDTO convert(Zadatak zadatak) {
		if(zadatak==null){
			return null;
		}
		
		ZadatakDTO dto = new ZadatakDTO();
		
		dto.setId(zadatak.getId());
		dto.setIme(zadatak.getIme());
		dto.setBodovi(zadatak.getBodovi());
		dto.setZaduzeni(zadatak.getZaduzeni());
		
		return dto;
	}
	
	public List<ZadatakDTO> convert(List<Zadatak> zadaci){
		List<ZadatakDTO> ret = new ArrayList<>();
		
		for(Zadatak z: zadaci){
			ret.add(convert(z));
		}
		
		return ret;
	}

}
