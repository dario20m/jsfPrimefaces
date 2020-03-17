package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CounterBean {

	private List<Persona> countList;
	private PersonaService s;

	public boolean findMarios() {
		try {
			countList = s.getByName("Mario");
		} catch (NullPointerException e) {
			return false;
		}
		return countList != null;
	}

	public int count() {
		return countList.size();
	}
}
