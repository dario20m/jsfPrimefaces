package business.utility;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtils {

	// FIXME: This resource should be injected
	private static DataSource dataSource;

	public static Connection getConnection() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			dataSource = (DataSource) envCtx.lookup("jdbc/mariosdb");
			return dataSource.getConnection();
		} catch (NamingException e) {
			System.out.println("Errore durante lo stabilimento della connessione con il database!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Errore durante lo stabilimento della connessione con il database!");
			e.printStackTrace();
		}
		return null;
	}
	public static boolean closeConnection(Connection conn) {
		try {
			conn.close();
			System.out.println("Connessione chiusa correttamente.");
			return true;
		} catch (SQLException e) {
			System.out.println("Errore nella chiusura della connessione");
			e.printStackTrace();
			return false;
		}
	}
}
