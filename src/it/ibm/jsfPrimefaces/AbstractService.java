package it.ibm.jsfPrimefaces;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractService {

	/**
	 * Datasource.
	 */
	@Autowired
	@Qualifier("DataSource")
	private DataSource dataSource;

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

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
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
		    //connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		    // Auto-commit disabilitato
		    connection.setAutoCommit(false);
		}
		return connection;
	}
}
