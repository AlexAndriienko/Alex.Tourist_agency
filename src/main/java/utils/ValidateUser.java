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
			if (user == null)
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

}
