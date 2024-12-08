package Commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	static Properties properties = null;
	
	public ConfigReader()
	{
		File Path = new File("./src/test/resources/TestData/Config.properties");
		
		try {
			FileInputStream fis= new FileInputStream(Path);
			properties = new Properties();
			properties.load(fis);
			
			} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String getBrowser()
	{
		String Browser = properties.getProperty("Browser");
		return Browser;
	}
	
	public static String getAppUrl()
	{
		String URL = properties.getProperty("URL");
		return URL;
	}
	
	public static String getUsername()
	{
		String Username = properties.getProperty("Username");
		return Username;
	}
	
	public static String getPassword()
	{
		String Password = properties.getProperty("Password");
		return Password;
	}
	

	
}
