package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import dao.impl.DefaultUserDao;
import dto.UserData;

public class ValidateNewUserLogin {

	public List<String> getLog(String login) {
		List<String> resultlog = new LinkedList<String>();
		resultlog.add(checkLoginMatch(login));
		resultlog.add(checkLoginLength(login));
		resultlog.add(checkLoginChar(login));
		resultlog.removeIf(Objects::isNull);
		return resultlog;
	}

	public String checkLoginMatch(String login) {
		String result = null;
		UserData user = DefaultUserDao.getDefaultUserDao().getUserByUQData(login, "getUserByLoginSQL");

		if (user.getUserLogin() != null) {
			result = "User with this login already exists";
		}

		return result;
	}

	public String checkLoginLength(String login) {
		String result = null;

		if (login.length() < 3 || login.length() > 10) {
			result = "Your Login shorter than three characters or longer than 10 characters";

		}

		return result;
	}

	public String checkLoginChar(String login) {
		String result = null;

		if (!Pattern.matches("(^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$)", login)) {
			result = "Your login contains unsupported characters.";
		}

		return result;

	}

}
