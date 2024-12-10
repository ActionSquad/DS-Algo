package driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commons.ConfigReader;


public class DriverConfig {

<<<<<<< Updated upstream
    static WebDriver driver;
	
    static String browser = ConfigReader.getProperty("Browser");
	static String URL = ConfigReader.getProperty("URL");
	
	
	public static WebDriver getdriver()
=======
	static String URL = ConfigReader.getProperty("URL");
	protected static final  ThreadLocal<WebDriver> ThreadLocaldriver = new ThreadLocal<>();
	public  static void getdriver(String browser)
>>>>>>> Stashed changes
	{
		WebDriver driver=null;
		if(driver==null)
		{
			if (browser.equalsIgnoreCase("chrome"))
			{
				driver= new ChromeDriver();
			}
			else if (browser.equalsIgnoreCase("firefox"))
			{
				driver= new FirefoxDriver();
			}
			else if (browser.equalsIgnoreCase("edge"))
			{
				driver= new EdgeDriver();
			}
			else
			{
				driver= new ChromeDriver();
			}
		}
		ThreadLocaldriver.set(driver);
		getDriverInstance().manage().window().maximize();
		getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		getDriverInstance().get(URL);	
	}
	public static  WebDriver getDriverInstance() {
		return ThreadLocaldriver.get();	
	}
	public static void quitdriver()
	{
		getDriverInstance().manage().deleteAllCookies();
		getDriverInstance().quit();
		ThreadLocaldriver.remove();
   }
}
