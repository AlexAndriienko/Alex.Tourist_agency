package dbUtils;

import java.sql.DriverManager;
import java.sql.SQLException;

import utils.ReadPropertiesFile;

import java.sql.Connection;

public class DbConnectionUtils {
	
	private static final String HOST = "jws-app-mysql";
	private static final String DB_NAME = "tourist_agency";
	private static final int PORT  = 3306;
	private static final String PATH_DB_CONFIGS = "properties/dbConfig.properties";
	private static final String USERNAME = ReadPropertiesFile.readFile(PATH_DB_CONFIGS, "db.login");
	private static final String PASSWORD = ReadPropertiesFile.readFile(PATH_DB_CONFIGS, "db.password");
	private static final String CONNECTIONURL = "jdbc:mysql://" + HOST + ":" + PORT + "/"+ DB_NAME;
	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";

	public static Connection getConnection() {
						
		try {
			Class.forName(MYSQL_JDBC_DRIVER_NAME);
			return DriverManager.getConnection(CONNECTIONURL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnectionPool() {
		
		try {
			Class.forName(MYSQL_JDBC_DRIVER_NAME);
			return DriverManager.getConnection(CONNECTIONURL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
