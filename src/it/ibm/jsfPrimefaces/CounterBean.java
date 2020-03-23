package it.ibm.jsfPrimefaces;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CounterBean {

	private List<Persona> countList;
	@Autowired
	private PersonaService personaService;
	
	public CounterBean() {}

	public boolean findMarios() {
		countList = personaService.getByName("Mario");
		System.out.println(countList.toString());
		return countList != null;
	}

	public int count() {
		return countList.size();
	}

	public List<Persona> getCountList() {
		return countList;
	}

	public void setCountList(List<Persona> countList) {
		this.countList = countList;
	}

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}
}
