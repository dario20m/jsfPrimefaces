package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean
public class CounterBean {

	@Autowired
	private PersonaRepository repo;
	private List<Persona> countList;

	public void findMarios() {
		countList = repo.findbyName("Mario");
	}

	public int count() {
		return 0;
		//return countList.size();
	}
}
