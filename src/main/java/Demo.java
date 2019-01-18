import java.sql.SQLException;

import dao.UserDao;
import dao.impl.DefaultUserDao;
import dto.UserData;
import utils.ReadPropertiesFile;

public class Demo {

	public static void main(String[] args) throws SQLException {
		final String PATH_SQL_QUERIES = "src/main/webapp/WEB-INF/queries.properties";
		final String PATH_DB_CONFIGS = "src/main/webapp/WEB-INF/dbConfig.properties";
		
			
		System.out.println(ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "getUserByIdSQL"));
		System.out.println(ReadPropertiesFile.readFile(PATH_SQL_QUERIES, "getUserByLoginSQL"));
		System.out.println(ReadPropertiesFile.readFile(PATH_DB_CONFIGS, "db.host"));
		System.out.println(ReadPropertiesFile.readFile(PATH_DB_CONFIGS, "db.login"));
		System.out.println(ReadPropertiesFile.readFile(PATH_DB_CONFIGS, "db.password"));
	}
}