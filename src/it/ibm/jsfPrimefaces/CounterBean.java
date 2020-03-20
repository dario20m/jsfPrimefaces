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
	private PersonaService s;

	public boolean findMarios() {
		countList = s.getByName("Mario");
		System.out.println(countList.toString());
		return countList != null;
	}

	public int count() {
		return countList.size();
	}
}
