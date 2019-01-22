package utils;

import java.sql.SQLException;
import dao.impl.DefaultUserDao;
import dto.UserData;

public class ValidateUser {
	static boolean result = false;

	public static boolean checkUser(String login, String password) {

		boolean result = false;

		try {
			UserData user = DefaultUserDao.getDefaultUserDao().getUserByLogin(login);
			if (user.getUserLogin() == null)
				result = false;
			else if (!password.equals(user.getUserPass()))
				result = false;
			else if (password.equals(user.getUserPass()))
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean checkLoginMatch(String userLogin) {

		boolean result = false;
		UserData user = null;

		try {
			user = DefaultUserDao.getDefaultUserDao().getUserByLogin(userLogin);
			if (user.getUserLogin() == null)
				result = false;
			else result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static boolean checkEmailMatch(String userEmail) {

		boolean result = false;

		try {
			UserData user = DefaultUserDao.getDefaultUserDao().getUserByEmail(userEmail);
			if (user.getUserLogin() == null)
				result = false;
			else result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
