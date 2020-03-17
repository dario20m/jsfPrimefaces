package beans;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public abstract class AbstractService {

	/**
	 * Datasource.
	 */
	@Autowired
	@Qualifier("DataSource")
	private transient DataSource dataSource;

	/**
	 * Costruttore.
	 */
	protected AbstractService() {}

	/**
	 * Getter.
	 * 
	 * @return	datasource database applicativo
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 
	 * Setup della connessione.
	 * 
	 * @param connection			connessione da gestire
	 * @param inTransactionActive	flag transazione attiva
	 * @return						connessione creata
	 * @throws SQLException			eccezione generabile in fase di setup
	 */
	protected final Connection setupConnection(final Connection connection, final Boolean inTransactionActive) throws SQLException {
		if (inTransactionActive) {
		    // Le operazioni sul DB sono impostate in maniera sequenziale
		    // (No accessi simultanei)
		    connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		    // Auto-commit disabilitato
		    connection.setAutoCommit(false);
		}
		return connection;
	}
	
	/**
	 * 
	 * Chiude la connessione al DB, in maniera safe.
	 *
	 * @param connection
	 *            - Connessione al DB
	 */
	public final void closeConnection(final Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Chiude la transazione al DB.
	 *
	 * @param connection
	 *            - Connessione al DB
	 */
	public final void closeTransaction(final Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				// salvataggio dati
				connection.commit();
				// Auto-commit attivato
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Commit e chiusura della connessione al DB.
	 *
	 * @param connection
	 *            - Connessione al DB
	 * @throws SQLException
	 *             the SQL exception
	 */
	public final void commitConnection(final Connection connection) throws SQLException {
		try {
			if (connection != null && !connection.isClosed()) {
				// Salvataggio dei dati su DB
				connection.commit();
			}
		} finally {
			closeConnection(connection);
		}
	}
	
	/** 
	 * Rollback e chiusura della connessione al DB. 
	 * @param connection - Connessione al DB
	 */
	public final void rollbackConnection(final Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
