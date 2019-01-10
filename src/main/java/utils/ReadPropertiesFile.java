package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
	public static String pathFile;
	public static String key;

	public static String readFile(String pathFile, String key) {
		
		FileInputStream fileInput = null;
		Properties properties  = null;
		String value = null;
		
		try {
			fileInput = new FileInputStream(pathFile);
			 
			properties = new Properties();
		    properties.load(fileInput);
		    value = properties.getProperty(key);
		    	
		   if (value == null) {
		    	System.err.println("Sorry, unable to find key" + key);
		   }
		    		    
		} catch (FileNotFoundException e) {
			System.err.println("Sorry, unable to find file" + pathFile);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileInput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return value;

 }
}
