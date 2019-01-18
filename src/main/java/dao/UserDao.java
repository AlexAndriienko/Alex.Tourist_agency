package dao;

import java.sql.SQLException;
import java.util.List;
import dto.UserData;

public interface UserDao {
	
	public UserData getUserById(int userID) throws SQLException;
	public UserData getUserByLogin(String userLogin) throws SQLException;
	public List<UserData> getUsers();

}