package jwd.modul3test;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.modul3test.model.Sprint;
import jwd.modul3test.model.Stanje;
import jwd.modul3test.model.Zadatak;
import jwd.modul3test.service.SprintService;
import jwd.modul3test.service.StanjeService;
import jwd.modul3test.service.ZadatakService;

@Component
public class TestData {

	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private StanjeService stanjeService;
	
	@Autowired
	private ZadatakService zadatakService;
	
	@PostConstruct
	public void init() {
		Sprint sprint1 = sprintService.save(new Sprint("sprint 1", 150));
		Sprint sprint2 = sprintService.save(new Sprint("sprint 2", 180));
		
		Stanje nov = stanjeService.save(new Stanje("Nov"));
		Stanje uToku = stanjeService.save(new Stanje("U toku"));
		Stanje zavrsen = stanjeService.save(new Stanje("Zavrsen"));
		
		Zadatak zadatak1 = zadatakService.save(new Zadatak("zadatak 1", "Petar Petrovic", 10));
		zadatak1.setSprint(sprint1);
		zadatak1.setStanje(nov);
		
		Zadatak zadatak2 = zadatakService.save(new Zadatak("zadatak 2", "Petar Petrovic", 3));
		zadatak2.setSprint(sprint1);
		zadatak2.setStanje(uToku);
		
		Zadatak zadatak3 = zadatakService.save(new Zadatak("zadatak 3", "Marko Markovic", 5));
		zadatak3.setSprint(sprint1);
		zadatak3.setStanje(zavrsen);
		
		Zadatak zadatak4 = zadatakService.save(new Zadatak("zadatak 4", "Petar Petrovic", 10));
		zadatak4.setSprint(sprint2);
		zadatak4.setStanje(nov);
		
		Zadatak zadatak5 = zadatakService.save(new Zadatak("zadatak 5", "Janko Jankovic", 7));
		zadatak5.setSprint(sprint2);
		zadatak5.setStanje(zavrsen);
		
		Zadatak zadatak6 = zadatakService.save(new Zadatak("zadatak 6", "Petar Petrovic", 3));
		zadatak6.setSprint(sprint1);
		zadatak6.setStanje(uToku);
	}
}
