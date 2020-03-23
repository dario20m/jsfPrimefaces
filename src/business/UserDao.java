package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

public class UserDao implements IUserDao{
	@Override
	public List<User> getByUsername(String username, Connection conn) {
		List<User> usersList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		try {

			String query = "select * from persona where nome = '" + username + "';";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				u = new User(rs.getInt("id"), rs.getString("nome"), rs.getString("cognome"), rs.getDate("datanascita"));
				usersList.add(u);
			}
		} catch (SQLException e) {
		} finally {
			closeStatement(ps, rs);
		}
		return usersList;
	}

	private void closeStatement(final PreparedStatement ps, final ResultSet rs) {
		if (rs != null) {
			try {
				if (!rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				if (!ps.isClosed())
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
