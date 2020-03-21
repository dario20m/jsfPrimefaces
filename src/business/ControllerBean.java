package business;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class ControllerBean {

	//FIXME: This service should be injected instead
	private UserSRV userService = new UserSRV();

	private List<User> resultList = new ArrayList<>();

	public ControllerBean() {
	}

	public UserSRV getUserService() {
		return userService;
	}

	public void setUserService(UserSRV userService) {
		this.userService = userService;
	}

	public List<User> getResultList() {
		return resultList;
	}

	public void setResultList() {
		resultList = null;
		try {
			resultList = userService.getByUsername("Mario");

		} catch (NullPointerException e) {
			System.out.println("Errore nell'utilizzo del Service");
			e.printStackTrace();
		}
	}

	public String changePage() {
		return "count";
	}
}
