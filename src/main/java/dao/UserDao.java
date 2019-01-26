package dao;

import java.util.List;

import dto.UserData;

public interface UserDao {

	public List<UserData> getAllUsers();

	public UserData getUserByUQData(String data, String SQLkey);

	public void setNewUser(UserData userData);
	
	public void removeUser(int userID);
	
	public void getUserTours(UserData user);
	
	public void setUserTours(int userID,  List<Integer> tourID);
	
	public void removeUserTour(int userID,  int tourID);

}