package dao;

import java.util.List;

import dto.UserData;

public interface UserDao {

	public List<UserData> getAllUsers();

	public UserData getUserByUQData(String data, String SQLkey);

	public void setNewUser(UserData user);
	
	public void removeUser(UserData user);
	
	public void getUserTours(UserData user);
	
	public void updateUserTours(UserData user);
	
	public void removeAllUserToursSQL(UserData user);

}