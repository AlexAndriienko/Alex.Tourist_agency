package utils;

import java.util.List;

import dto.UserData;

public interface UserValidator {
	public List<String> getLog (UserData user);
	public List<String> checkLogin (String login);
	public List<String> checkEmail (String email);
	public List<String> checkPass (String pass, String passRpt);
}
