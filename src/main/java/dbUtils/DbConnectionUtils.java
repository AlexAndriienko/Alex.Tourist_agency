package dbUtils;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import utils.ReadPropertiesFile;

import java.sql.Connection;

public class DbConnectionUtils {
	
	private static final String PATH_DB_CONFIGS = "properties/dbConfig.properties";
	private static final String USERNAME = ReadPropertiesFile.readFile(PATH_DB_CONFIGS, "db.login");
	private static final String PASSWORD = ReadPropertiesFile.readFile(PATH_DB_CONFIGS, "db.password");
	private static final String CONNECTIONURL = ReadPropertiesFile.readFile(PATH_DB_CONFIGS, "db.host");
	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

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
			InitialContext initContext = new InitialContext();
			DataSource dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/tourist_agency");
			return dataSource.getConnection();
		} catch (NamingException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
