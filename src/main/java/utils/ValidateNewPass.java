package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class ValidateNewPass {

	public List<String> getLog(String password, String password_repeat) {
		List<String> resultlog = new LinkedList<String>();
		resultlog.add(checkPassRepeat(password, password_repeat));
		resultlog.add(checkCharPass(password));
		resultlog.removeIf(Objects::isNull);
		return resultlog;
	}

	public String checkPassRepeat(String password, String password_repeat) {
		String result = null;
		if (password.equals(password_repeat)) {
			result = null;
		} else result = "Password and Repeat Password do not match.";

		return result;
	}
	
	public String checkCharPass(String password) {
		String result = null;

		if (!Pattern.matches("((?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,})", password)) {
			result = "The password must contain at least one digit, one lowercase and uppercase letters, one special character(!@#$%^&*) and at least 6 characters.";
		}

		return result;
	}	

}
