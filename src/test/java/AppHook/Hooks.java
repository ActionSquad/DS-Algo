package appHook;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;

import commons.ConfigReader;
import commons.ExcelReader;
import driverFactory.DriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	public WebDriver driver;
    
    public static List<Map<String, String>> Login;
    public static List<Map<String, String>> Register;
    public static List<Map<String, String>> Code;
    @Before(order = 1)
    public static void setUpDriver() {
    	{
            DriverConfig.getdriver(ConfigReader.getProperty("Browser"));
        }
    }
    	
   // @Before(order = 2) 
 /*   public void setUp() {
        try {
        	String path = "/DS-Algo/src/test/resources/TestData/ExcelData.xlsx";
            ExcelReader excelreader = new ExcelReader();
            Login = excelreader.getData(path, "login");
            Register = excelreader.getData(path, "register");
            Code = excelreader.getData(path, "code");
          } catch (Exception e) {
           e.printStackTrace();
           throw new RuntimeException("Error initializing Excel data: " + e.getMessage());
       }
    } */
    
    
    @Before(order = 2) 
    public void setUp(Scenario scenario) {
        try {
            ExcelReader excelreader = new ExcelReader();
            Login = excelreader.getData("src/test/resources/TestData/ExcelData.xlsx", "login");
            Register = excelreader.getData("src/test/resources/TestData/ExcelData.xlsx", "register");
            Code =excelreader.getData("src/test/resources/TestData/ExcelData.xlsx", "code");
            System.out.println("Scenario Name: " + scenario.getName());
          } catch (Exception e) {
           e.printStackTrace();
           throw new RuntimeException("Error initializing Excel data: " + e.getMessage());
       }
    }
  
    
    @After
  public static void tearDown() {

        DriverConfig.quitdriver();
        


}
}
