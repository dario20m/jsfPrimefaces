package business;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ControllerBean {
	private UserSRV userService;

	public List<User> getMario() {
		return userService.getByUsername("Mario");
	}
	
	public String changePage() {
		return "count";
	}
}
