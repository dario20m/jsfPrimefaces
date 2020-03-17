package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	public List<User> getByUsername(String username, Connection conn) {
		List<User> usersList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u;

		try {
			String query = "Select * from persona where nome = " + username;
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			if (rs.next()) {
				u = new User(rs.getInt("id"), rs.getString("nome"), rs.getString("cognome"), rs.getDate("datanascita"));
				usersList.add(u);
			}
		} catch (SQLException e) {
		}

		return usersList;
	}
}
