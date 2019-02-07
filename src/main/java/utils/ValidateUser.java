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

}
