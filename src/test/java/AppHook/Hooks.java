package AppHook;

import org.openqa.selenium.WebDriver;

import DriverFactory.DriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	static WebDriver driver;
	
	@Before
	public static void setupDriver()
	{
	driver = DriverConfig.getdriver();	
	}
	
	@After
	public static void QuitSession()
	{
		driver = DriverConfig.quitdriver();
	}
	
	
	
}
