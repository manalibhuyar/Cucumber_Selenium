package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
	}
	
	
	public static void initialization()
	{
		
		String browserName= prop.getProperty("browser");
		System.out.println(browserName);
		
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
		
		
			
//		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
		public void tearDown()
		{
			driver.quit();
		}

}
