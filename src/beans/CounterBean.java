package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean
public class CounterBean {

	@Autowired
	private PersonaRepository repo;
	private List<Persona> countList;

	public boolean findMarios() {
		countList = repo.findbyName("Mario");
		return countList != null;
	}

	public int count() {
		return 0;
		// return countList.size();
	}

	public String changePage() {
		return "count";
	}
}
