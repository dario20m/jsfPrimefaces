package beans;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaService extends AbstractService {
	
	@Autowired
	private PersonaDao personaDao;
	
	public final List<Persona> getByName(final String name) {
		List<Persona> output = null;
		Connection connection = null;
		
		try {
			connection = setupConnection(getDataSource().getConnection(), false);
			
			output = personaDao.getByName(name, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}

}
