package Pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends page {
	
	@FindBy(id="RoundTrip")
	private WebElement roundTrip;
	
	@FindBy(id="FromTag")
	private WebElement fromCity;
	
	@FindBy(id="DepartDate")
	private WebElement DepartDate;
	
	@FindBy(id="ToTag")
	private WebElement toCity;
	
	@FindBy(xpath="//*[@class='.ui-datepicker-days-cell-over.selected']/a")
	private WebElement todayDate;
	
	@FindBy(id="i-datepicker-div")
	private WebElement returnDate;
	

	@FindBy(id="SearchBtn")
	private WebElement continueSearch;
	
	//WebDriverWait wait= new WebDriverWait(driver, 60);
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public void verifyUserLand() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertTrue("user not landed on clear trip page", driver.getTitle().contains("Booking"));
		
	}

	public void userSearchesFlights() {
		System.out.println("Clicking on round Trip");
		roundTrip.click();
		
		System.out.println("entering from city");
		this.fromCity.sendKeys(prop.getProperty("fromCity"));
		
		System.out.println("entering To city");
		this.toCity.sendKeys(prop.getProperty("toCity"));
	}

	public void userEntersDetails() {
		System.out.println("enetering depart date");
		DepartDate.click();
		
		System.out.println("selecting todays date");
		todayDate.click();
		
		SimpleDateFormat sf= new SimpleDateFormat("dd/MM/yyyy");
		Calendar c= Calendar.getInstance();
		
		c.setTime(new Date());
		c.add(Calendar.DATE, 10);
		String obtainDate = c.getTime().toString();
		
		System.out.println("sending return dae after 10 days");
		returnDate.sendKeys(obtainDate);
	}

	public void searchFlights() {
		System.out.println("clicking on serach button");
		this.continueSearch.click();
		
	}
	
	
	
	
	
}
