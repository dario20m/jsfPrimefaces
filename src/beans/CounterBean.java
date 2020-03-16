package beans;

import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;


@ManagedBean
public class CounterBean {

	@Autowired

	public boolean findMarios() {
		//TODO: complete the method
		return false;
	}

	public int count() {
		return 0;
		// TODO: Remove this method, is being used as a test method
		// return countList.size();
	}

	public String changePage() {
		return "count";
	}
}
