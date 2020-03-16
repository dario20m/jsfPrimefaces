package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CounterBean {

	private List<Object> countList;

	public boolean findMarios() {
		try {
			//countList = repo.findbyName("Mario");
		} catch (NullPointerException e) {
			return false;
		}
		return countList != null;
	}

	public int count() {
		//return countList.size();
		return 0;
	}
}
