package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CounterBean {

	private List<Persona> countList;
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
