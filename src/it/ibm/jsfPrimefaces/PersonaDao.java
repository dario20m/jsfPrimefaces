package it.ibm.jsfPrimefaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PersonaDao {

	List<Persona> result = new ArrayList<>();

	public List<Persona> getByName(String name, Connection connection) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Persona persona = null;
		String nameLow = name;

		try {
			if (name != null)
				nameLow = name.toLowerCase();

			StringBuilder sb = new StringBuilder();
			sb.append("select * from persona where persona.nome = ").append(nameLow);
			String query = sb.toString();

			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				persona = new Persona(rs.getInt("id"), rs.getString("nome"), rs.getString("cognome"), rs.getDate("datanascita"));
				result.add(persona);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(ps, rs);
		}
		return result;
	}//getByName

	private void closeStatement(final PreparedStatement ps, final ResultSet rs) {
		if (rs != null) {
			try {
				if (!rs.isClosed())
					rs.close();
			} catch (SQLException e) { e.printStackTrace(); }
		}
		if (ps != null) {
			try {
				if (!ps.isClosed())
					ps.close();
			} catch (SQLException e) { e.printStackTrace(); }
		}
	}//closeStatement
}
