package it.ibm.jsfPrimefaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService extends AbstractService {
	
	@Autowired
	private PersonaDao personaDao;
	
	public PersonaService() {
		super();
	}

	public final List<Persona> getByName(final String name) {
		List<Persona> output = null;
		Connection connection = null;
		
		try {
			connection = setupConnection(getDataSource().getConnection());
			output = personaDao.getByName(name, connection);
		} catch (SQLException e) { e.printStackTrace(); }
		return output;
	}

	public PersonaDao getPersonaDao() {
		return personaDao;
	}

	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}
}
