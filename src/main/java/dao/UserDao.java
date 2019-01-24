package dao;

import java.util.List;
import dto.UserData;

public interface UserDao {

	public List<UserData> getAllUsers();

	public UserData getUserByUQData(String data, String SQLkey);

	public void setNewUser(String userLogin, String userEmail, String pass);
	
	public void removeUser(int userID);

}