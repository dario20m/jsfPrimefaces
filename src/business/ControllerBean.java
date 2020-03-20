package business;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean
public class ControllerBean {

	// FIXME: This service should be injected instead
//	@Autowired
	private UserSRV userService = new UserSRV();
	private List<User> resultList = new ArrayList<>();

	public ControllerBean() {
	}

	public List<User> getResultList() {
		return resultList;
	}

	public void setResultList() {
		resultList = userService.getByUsername("Mario");
	}

	public String changePage() {
		return "count";
	}
}
