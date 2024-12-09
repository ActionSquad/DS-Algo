package AppHook;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import Commons.ExcelReader;
import DriverFactory.DriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	static WebDriver driver;
	
	public static List<Map<String, String>> Login;
    public static List<Map<String, String>> Register;
	
	@Before
	public static void setupDriver(Scenario scenario)
	{
	driver = DriverConfig.getdriver();	
	  try {
          ExcelReader excelManager_hashmap = new ExcelReader();
          Login = excelManager_hashmap.getData("src/test/resources/TestData/ExcelData.xlsx", "login");
          Register = excelManager_hashmap.getData("src/test/resources/ExcelData.xlsx", "register");
          System.out.println("Scenario Name: " + scenario.getName());
        } catch (Exception e) {
         e.printStackTrace();
         throw new RuntimeException("Error initializing Excel data: " + e.getMessage());
     }
	}
	
	@After
	public static void QuitSession()
	{
		driver = DriverConfig.quitdriver();
	}
	
	
	
}
