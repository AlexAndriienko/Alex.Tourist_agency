package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import dao.impl.DefaultUserDao;
import dto.UserData;

public class DefaultUserValidator implements UserValidator {
	private static DefaultUserValidator instance;
	
	private DefaultUserValidator() {
	}

	public static synchronized DefaultUserValidator getDefaultUserValidator() {
		if (instance == null) {
			instance = new DefaultUserValidator();
		}
		return instance;
	}
	
	public boolean checkUser(String login, String password) {
		boolean result = false;
		UserData user = DefaultUserDao.getDefaultUserDao().getUserByUQData(login, "getUserByLoginSQL");		
		if (user.getUserLogin() == null)
			result = false;
		else if (!password.equals(user.getUserPass()))
			result = false;
		else if (password.equals(user.getUserPass()))
			result = true;

		return result;
	} 

	@Override
	public List<String> getLog(UserData user) {
		List<String> resultValidationList = new LinkedList<String>();
		resultValidationList.addAll(checkLogin(user.getUserLogin()));
		resultValidationList.addAll(checkEmail(user.getUserEmail()));
		resultValidationList.addAll(checkPass(user.getUserPass(), user.getUserPassRpt()));
		return resultValidationList;
	}

	@Override
	public List<String> checkLogin(String login) {
		List<String> resultlog = new LinkedList<String>();
		resultlog.add(checkLoginMatch(login));
		resultlog.add(checkLoginLength(login));
		resultlog.add(checkLoginChar(login));
		resultlog.removeIf(Objects::isNull);
		return resultlog;
	}

	private String checkLoginMatch(String login) {
		String result = null;
		UserData user = DefaultUserDao.getDefaultUserDao().getUserByUQData(login, "getUserByLoginSQL");

		if (user.getUserLogin() != null) {
			result = "User with this login already exists";
		}

		return result;
	}

	private String checkLoginLength(String login) {
		String result = null;

		if (login.length() < 3 || login.length() > 10) {
			result = "Your Login shorter than three characters or longer than 10 characters";

		}

		return result;
	}

	private String checkLoginChar(String login) {
		String result = null;

		if (!Pattern.matches("(^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$)", login)) {
			result = "Your login contains unsupported characters.";
		}

		return result;
	}

	@Override
	public List<String> checkEmail(String email) {
		List<String> resultlog = new LinkedList<String>();
		resultlog.add(checkEmailMatch(email));
		resultlog.add(checkEmailLength(email));
		resultlog.add(checkEmailChar(email));
		resultlog.removeIf(Objects::isNull);
		return resultlog;
	}

	private String checkEmailMatch(String email) {
		String result = null;
		UserData user = DefaultUserDao.getDefaultUserDao().getUserByUQData(email, "getUserByEmailSQL");

		if (user.getUserEmail() != null) {
			result = "User with this email already exists";
		}

		return result;
	}

	private String checkEmailLength(String email) {
		String result = null;

		if (email.length() < 3 || email.length() > 15) {
			result = "Your email shorter than three characters or longer than 15 characters";

		}

		return result;
	}

	private String checkEmailChar(String email) {
		String result = null;

		if (!Pattern.matches(
				"(^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$)",
				email)) {
			result = "Email is incorrect";
		}

		return result;
	}

	@Override
	public List<String> checkPass(String pass, String passRpt) {
		List<String> resultlog = new LinkedList<String>();
		resultlog.add(checkPassRepeat(pass, passRpt));
		resultlog.add(checkCharPass(pass));
		resultlog.removeIf(Objects::isNull);
		return resultlog;
	}

	private String checkPassRepeat(String password, String password_repeat) {
		String result = null;
		if (password.equals(password_repeat)) {
			result = null;
		} else
			result = "Password and Repeat Password do not match!";

		return result;
	}

	private String checkCharPass(String password) {
		String result = null;

		if (!Pattern.matches("((?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,})", password)) {
			result = "The password must contain at least one digit, one lowercase and uppercase letters, one special character(!@#$%^&*) and at least 6 characters.";
		}

		return result;
	}
	
	public List<String> checkPass(String pass) {
		List<String> resultlog = new LinkedList<String>();
		resultlog.add(checkCharPass(pass));
		resultlog.removeIf(Objects::isNull);
		return resultlog;
	}

}
