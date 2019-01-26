package utils;

import java.util.LinkedList;
import java.util.List;

import dto.UserData;

public class ValidateNewUser {

public List<String> getValidationLog (UserData user) {
	List<String> resultValidationList = new LinkedList<String>();	
	resultValidationList.addAll(new ValidateNewUserLogin().getLog(user.getUserLogin()));
	resultValidationList.addAll(new ValidateNewUserEmail().getLog(user.getUserEmail()));
	return resultValidationList;	
}
	
}
