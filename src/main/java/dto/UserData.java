package dto;

import java.util.List;

public class UserData {

	private int userID;
	private String userLogin;
	private String userPass;
	private String userEmail;
	private int user_Access;
	private List<TourData> userTours;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUser_Access() {
		return user_Access;
	}
	public void setUser_Access(int user_Access) {
		this.user_Access = user_Access;
	}
		public List<TourData> getUserTours() {
		return userTours;
	}
	public void setUserTours(List<TourData> userTours) {
		this.userTours = userTours;
	}
	@Override
	public String toString() {
		return "UserData [userID=" + userID + ", userLogin=" + userLogin + ", userPass=" + userPass + ", userEmail="
				+ userEmail + ", user_Access=" + user_Access + ", userTours=" + userTours + "]";
	}
	

}