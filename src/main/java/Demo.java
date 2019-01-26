import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import javax.naming.NamingException;

import dbUtils.DbConnectionUtils;
import utils.ValidateNewUser;

//import java.sql.SQLException;
//import java.util.Iterator;
//import java.util.List;
//
//import dao.impl.DefaultTourDao;
//import dao.impl.DefaultUserDao;
//import dto.TourData;

public class Demo {

	public static void main(String[] args) throws NamingException {
		
		
		System.out.println(Pattern.matches("(^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$)", "Dfcz"));
//		
//		List<String> allLogins = new LinkedList<String>();
//		allLogins.add("Alex");
//		allLogins.add("Vasja");
//		
//		String login = "aalex";
//		
//		boolean loginMatch = allLogins.stream()
//				.filter(userLogin -> userLogin.equalsIgnoreCase(login))
//				.findFirst()
//				.isPresent();
//		System.out.println(loginMatch);
//		Connection con = DbConnectionUtils.getConnection();
		
		
//		final String PATH_SQL_QUERIES = "src/main/webapp/WEB-INF/queries.properties";
//		final String PATH_DB_CONFIGS = "src/main/webapp/WEB-INF/dbConfig.properties";
//		
//			
//		
//		System.out.println(ValidateUser.checkLoginMatch("Alex"));
//		System.out.println(new InitialContext().lookup("java:comp/env"));
		
		
//		List<TourData> allToursList = DefaultTourDao.getDefaultTourDao().getAllTours();
//		Iterator<TourData> it = allToursList.iterator();
//		System.out.println();
//		 while(it.hasNext()){
//		       System.out.println(it.next().toString());
//		    }
		
//		System.out.println(DefaultUserDao.getDefaultUserDao().getUserByUQData("Alex", "getUserByLoginSQL"));
	}
}
