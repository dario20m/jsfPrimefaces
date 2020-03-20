package business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.stereotype.Service;

@Service
public class UserSRV {

	@Resource(name = "jdbc/mariosdb")
	private DataSource dataSource;

	// FIXME: The Dao should be injected
	UserDao userD;

	Connection conn = null;
	List<User> usersList;

	public List<User> getByUsername(String username) {

		try {
			System.out.println("Connessione in corso...");
			conn = dataSource.getConnection();
			System.out.println("Connessione al DB avvenuta con successo!");

			usersList = userD.getByUsername(username, conn);
		} catch (SQLException e) {
			System.out.println("Errore nella creazione della connessione");
			e.printStackTrace();
		} catch (NullPointerException n) {
			System.out.println("Errore nella configurazione del datasource");
			n.printStackTrace();
		}
		return usersList;
	}
}