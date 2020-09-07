package jwd.modul3test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.modul3test.model.Zadatak;
import jwd.modul3test.service.ZadatakService;
import jwd.modul3test.web.dto.ZadatakDTO;

@Component
public class ZadatakDTOToZadatak implements Converter<ZadatakDTO, Zadatak> {

	@Autowired
	ZadatakService zadatakService;

	@Override
	public Zadatak convert(ZadatakDTO dto) {
		Zadatak zadatak = null;
		
		if(dto.getId()!=null){
			zadatak = zadatakService.findOne(dto.getId());
			
			if(zadatak == null){
				throw new IllegalStateException("Tried to "
						+ "modify a non-existant activity");
			}
		}
		else {
			zadatak = new Zadatak();
		}
		
		zadatak.setId(dto.getId());
		zadatak.setIme(dto.getIme());
		zadatak.setBodovi(dto.getBodovi());
		zadatak.setZaduzeni(dto.getZaduzeni());
		
		return zadatak;
	}
	
	public List<Zadatak> convert (List<ZadatakDTO> dtoZadaci){
		List<Zadatak> zadaci = new ArrayList<>();
		
		for(ZadatakDTO dto : dtoZadaci){
			zadaci.add(convert(dto));
		}
		
		return zadaci;
	}
}
