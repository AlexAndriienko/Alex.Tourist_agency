package utils;

import dao.impl.DefaultUserDao;
import dto.UserData;

public class ValidateUser {
	static boolean result = false;

	public static boolean checkUser(String login, String password) {

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

	public static boolean checkLoginMatch(String login) {

		boolean result = false;
		UserData user = null;

		user = DefaultUserDao.getDefaultUserDao().getUserByUQData(login, "getUserByLoginSQL");
		if (user.getUserLogin() == null)
			result = false;
		else
			result = true;

		return result;
	}

	public static boolean checkEmailMatch(String email) {

		boolean result = false;

		UserData user = DefaultUserDao.getDefaultUserDao().getUserByUQData(email, "getUserByEmailSQL");
		if (user.getUserLogin() == null)
			result = false;
		else
			result = true;
		
		return result;
	}

}
