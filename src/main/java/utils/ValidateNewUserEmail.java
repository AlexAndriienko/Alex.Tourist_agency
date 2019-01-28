package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import dao.impl.DefaultUserDao;
import dto.UserData;

public class ValidateNewUserEmail {

	public List<String> getLog(String email) {
		List<String> resultlog = new LinkedList<String>();
		resultlog.add(checkEmailMatch(email));
		resultlog.add(checkEmailLength(email));
		resultlog.add(checkEmailChar(email));
		resultlog.removeIf(Objects::isNull);
		return resultlog;
	}

	public String checkEmailMatch(String email) {
		String result = null;
		UserData user = DefaultUserDao.getDefaultUserDao().getUserByUQData(email, "getUserByEmailSQL");

		if (user != null) {
			result = "User with this email already exists";
		}

		return result;
	}

	public String checkEmailLength(String email) {
		String result = null;

		if (email.length() < 3 || email.length() > 15) {
			result = "Your email shorter than three characters or longer than 15 characters";

		}

		return result;
	}

	public String checkEmailChar(String email) {
		String result = null;

		if (!Pattern.matches("(^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$)", email)) {
			result = "Email is incorrect";
		}

		return result;

	}

}
