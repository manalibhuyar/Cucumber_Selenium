package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class page {
	public static WebDriver driver;
	public static Properties prop;
	public static Actions action;
	public static JavascriptExecutor jsx;
	public static WebDriverWait wait;
	public static Logger Log;
	
	public page()
	{
		try
		{
			prop= new Properties();
			FileInputStream ip = new FileInputStream("src/test/java/configData/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		Log= Logger.getLogger(Log.class.getName());
		
	}
	
	
	public static void initialization()
	{
		jsx= (JavascriptExecutor) driver;  
		
		String browserName= prop.getProperty("browser");
		Log.info(browserName);
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","src/test/java/web-drivers/chromedriver");
			driver= new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","web-drivers/FF");
			driver= new FirefoxDriver();
		}
		
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("peperfryLoginUrl"));
		
		wait = new WebDriverWait(driver, 10);
		action= new Actions(driver);
		PropertyConfigurator.configure("resources.log4j.properties");
	}
		public void tearDown()
		{
			driver.quit();
		}

}
