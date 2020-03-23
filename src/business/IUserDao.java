package business;

import java.sql.Connection;
import java.util.List;


public interface IUserDao {
	public List<User> getByUsername(String username, Connection conn);
}
