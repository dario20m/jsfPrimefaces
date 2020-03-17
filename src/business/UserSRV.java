package business;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserSRV {

	@Autowired
	@Qualifier("DataSource")
	private DataSource dataSource;
	Connection conn;
	List<User> usersList;
	UserDao userD;

	public List<User> getByUsername(String username) {
		conn = null;
		try {
			conn = dataSource.getConnection();

			usersList = userD.getByUsername(username, conn);
		} catch (Exception e) {
		}
		return usersList;
	}

}