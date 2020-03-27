package it.ibm.jsfPrimefaces;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty; 

@ManagedBean
public class CounterBean {

	private List<Persona> countList;
	private String name;
	
	@ManagedProperty(value = "#{personaService}")
	private PersonaService personaService;
	
	
	
	public CounterBean() {}

	public boolean findOccurrences() {
		countList = personaService.getByName(name);
		//console output
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}
}
