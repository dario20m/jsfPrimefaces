package it.ibm.jsfPrimefaces;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
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
	 * @return						connessione creata
	 * @throws SQLException			eccezione generabile in fase di setup
	 */
	protected final Connection setupConnection(final Connection connection) throws SQLException {
		//TODO ?
		return connection;
	}
}
