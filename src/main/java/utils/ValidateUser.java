package utils;

import java.sql.SQLException;

import dao.impl.DefaultUserDao;
import dto.UserData;

public class ValidateUser {
	static boolean result = false;

	@SuppressWarnings("finally")
	public static boolean checkUser(String login, String password) {

		try {
			UserData user = DefaultUserDao.getDefaultUserDao().getUserByLogin(login);
			if (user == null)
				return false;
			else if (password != user.getUserPass())
				return true;
			else if (password == user.getUserPass())
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return false;
		}
	}

}
