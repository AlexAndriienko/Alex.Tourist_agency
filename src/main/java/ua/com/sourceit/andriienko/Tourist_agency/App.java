package ua.com.sourceit.andriienko.Tourist_agency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	public static void main(String[] args) throws ClassNotFoundException {
		String USERNAME = "root";
		String PASSWORD = "dsdsf565465kj";
		String CONNECTIONURL = "jdbc:mysql://localhost:3306/tourist_agency?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection(CONNECTIONURL, USERNAME, PASSWORD);
				Statement statement = connection.createStatement()) {
			System.out.println("Connection successful!");
			
// 			add new user
//			statement.executeUpdate("INSERT INTO `tourist_agency`.`users` (`user_ID`, `user_Login`, `user_Pass`, `user_Email`, `user_Access`) VALUES ('4', 'Kolja', '12345', '444@gmail.com', '1');");
			
// 			add new tour
//			statement.executeUpdate("INSERT INTO `tourist_agency`.`tours` (`tours_ID`, `tours_Type`, `tours_Location`, `tours_City`, `tours_Country`, `tours_Hotel`, `tours_Duration`, `tours_Price`) VALUES ('3', 'Koff', 'ff', 'ff', 'ff', 'ff', '6', '22');");
			
// 			user select tour
//			statement.executeUpdate("INSERT INTO `tourist_agency`.`selected_tours` (`user_ID`, `tour_ID`) VALUES ('4', '1');");
			
//			get user choice
//			statement.execute(
//					"SELECT tours_ID, tours_Type, tours_Location, tours_City, tours_Country, tours_Hotel, tours_Duration, tours_Price\r\n"
//							+ "FROM tours    \r\n" + "JOIN selected_tours st1 ON tours.tours_ID = st1.tour_ID\r\n"
//							+ "JOIN users ON st1.user_ID = users.user_ID AND users.user_ID = '3';");
			

		} catch (SQLException e) {
			System.err.println("Connection failed!");
			e.printStackTrace();
		}
	}
}
