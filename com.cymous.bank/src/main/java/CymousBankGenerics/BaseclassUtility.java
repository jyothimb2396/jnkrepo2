package CymousBankGenerics;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseclassUtility 
{
	public WebDriver driver;
	FileUtility flib = new FileUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	DataBaseUtility dlib = new DataBaseUtility();
	@BeforeSuite
	public void connectToDatabase() throws SQLException
	{
		dlib.connect_To_Database();
	}
    @BeforeClass
    public void launchBrowser() throws IOException
    {
    	String value=flib.get_Property_Value("Browser");
    	if(value.contains("Chrome"))
    	{
    		driver=new ChromeDriver();
    	}
    	else
    	{
    		driver=new FirefoxDriver();
    	}
    		
    }
    @BeforeMethod
    public void launchApplication() throws IOException
    {
    	wlib.wait_Till_Page_Gets_Loaded(driver);
    	driver.get(flib.get_Property_Value("Url"));
    	wlib.maximize_Window(driver);
    }
    @AfterMethod
    public void closeApplication() throws IOException
    {
//    	driver.close();
    }
    @AfterClass
    public void closeBrowser() throws IOException
    {
    	driver.quit();	
    }
    @BeforeSuite
	public void disconnectFromDatabase() throws SQLException
	{
		dlib.disconnect_From_Database();
	}

}
