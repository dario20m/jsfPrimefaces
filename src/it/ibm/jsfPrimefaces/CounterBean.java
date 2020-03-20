package it.ibm.jsfPrimefaces;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ManagedBean
@Component
public class CounterBean {

	private List<Persona> countList;
	@Autowired
	private PersonaService service;
	
	public CounterBean() {}

	public boolean findMarios() {
		countList = service.getByName("Mario");
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

	public PersonaService getService() {
		return service;
	}

	public void setService(PersonaService s) {
		this.service = s;
	}
}
