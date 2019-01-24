package utils;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;


public class ReadPropertiesFile {
	public static String pathFile;
	public static String key;

	public static String readFile(String pathFile, String key) {

		Properties properties = null;
		String value = null;

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream(pathFile);

		properties = new Properties();
		try {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		value = properties.getProperty(key);

		if (value == null) {
			System.err.println("Sorry, unable to find key" + key);
		}

		return value;

	}
}
