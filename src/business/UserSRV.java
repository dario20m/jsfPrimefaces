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
	
	Connection conn = null;
	List<User> usersList;
	UserDao userD;

	public List<User> getByUsername(String username) {
		try {
			System.out.println("Connessione in corso...");
			System.out.println(dataSource);
			conn = dataSource.getConnection();
			System.out.println("Connessione al DB avvenuta con successo!");

			usersList = userD.getByUsername(username, conn);
		} catch (Exception e) {
		}
		return usersList;
	}

}