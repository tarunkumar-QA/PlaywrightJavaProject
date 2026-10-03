package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class configReader {
	
	private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			
			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
			
			properties.load(fis);
			fis.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String Key) {
		return properties.getProperty(Key);
		
	}
	

}
