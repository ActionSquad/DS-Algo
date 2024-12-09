package DriverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Commons.ConfigReader;

public class DriverConfig {

    static WebDriver driver;
	
    static String browser = ConfigReader.getProperty("Browser");
	static String URL = ConfigReader.getProperty("URL");
	
	
	public static WebDriver getdriver()
	{
		if(driver==null)
			
		{
			if (browser.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if (browser.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else if (browser.equalsIgnoreCase("edge"))
			{
				driver = new EdgeDriver();
			}
			else
			{
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(URL);
		}
		return driver;
		
	}
	
	public static WebDriver quitdriver()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
		return null;
	}
}
