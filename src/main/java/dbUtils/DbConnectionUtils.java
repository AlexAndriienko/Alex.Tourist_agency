package dbUtils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DbConnectionUtils {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "dsdsf565465kj";
	private static final String CONNECTIONURL = "jdbc:mysql://localhost:3306/tourist_agency?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	public static Connection getConnection() {
		try {
			Class.forName(MYSQL_JDBC_DRIVER_NAME);
			return DriverManager.getConnection(CONNECTIONURL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
