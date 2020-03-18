package business;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ControllerBean {
	private UserSRV userService;
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
