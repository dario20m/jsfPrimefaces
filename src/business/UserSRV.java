package business;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Service;

import business.utility.ConnectionUtils;

@Service
public class UserSRV {

	// FIXME: The Dao should be injected
	UserDao userD = new UserDao();

	Connection conn = null;
	List<User> usersList;

	public List<User> getByUsername(String username) {

		System.out.println("Connessione in corso...");
		Connection conn = ConnectionUtils.getConnection();
		if (conn != null) {
			System.out.println("Connessione al DB avvenuta con successo!");
			usersList = userD.getByUsername("Mario", conn);
			if (ConnectionUtils.closeConnection(conn)) {
				return usersList;
			} else {
				System.out.println("Errore nella chiusura della connession");
				return usersList;
			}
		} else {
			System.out.println("Connessione al DB non riuscita!");
			return null;
		}

	}
}