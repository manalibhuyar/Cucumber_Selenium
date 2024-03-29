package Pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HomePage extends page {
	
	@FindBy(id="RoundTrip")
	private WebElement roundTrip;
	
	@FindBy(id="FromTag")
	private WebElement fromCity;
	
	@FindBy(css="#FromDate")
	private WebElement DepartDate;
	
	@FindBy(id="ToTag")
	private WebElement toCity;
	
	@FindBy(id="DepartDate")
	private WebElement todayDate;
	
	@FindBy(id="ReturnDate")
	private WebElement returnDate;
	

	@FindBy(id="SearchBtn")
	private WebElement continueSearch;

	@FindBy(xpath = "//div[@class='transactions']/h3")
	private WebElement headerMsg;

	String transactions = "//div[@class='transactions']/div[%s]";
	
	
	
	public void verifyUserLand() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("home page constructor called");
		PageFactory.initElements(driver, this);
		assertTrue( driver.getTitle().contains("Booking"),"user not landed on clear trip page");

	}

	public void userSearchesFlights() throws InterruptedException {
		System.out.println("Clicking on round Trip");
		Thread.sleep(4000);
		roundTrip.click();
		
		
		System.out.println("entering from city");
		this.fromCity.sendKeys(prop.getProperty("fromCity"));
		
		System.out.println("entering To city");
		this.toCity.sendKeys(prop.getProperty("toCity"));
		toCity.sendKeys(Keys.TAB,Keys.ENTER);
	}

	public void userEntersDetails() throws ParseException {
		System.out.println("enetering depart date");
		System.out.println("selecting todays date");
		System.out.println("antering date after 10 days");
		DateFormat sf= new SimpleDateFormat("dd/MM/yyyy");
		Calendar c= Calendar.getInstance();
		
		c.setTime(new Date());
		c.add(Calendar.DATE, 10);
		Date date= c.getTime();
		String rDate= sf.format(date);
		System.out.println("obtained date after 10 days is:"+ rDate);
		
		System.out.println("sending return date after 10 days");
		returnDate.clear();
		returnDate.sendKeys(rDate,Keys.TAB);
	}

	public void searchFlights() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("clicking on search");
		continueSearch.click();
		this.tearDown();
	}
	public void validateBlockStreamPage() {
		Assert.assertTrue(driver.getTitle().contains("blockstream.info"));
	}

	public void validateHeading(String msg) {
		Assert.assertTrue(headerMsg.getText().equalsIgnoreCase(msg));
	}

	public void printHashcodeOfTransaction() {
		int n= driver.findElements(By.xpath(transactions)).size();
		for(int i=0; i<n ; i++ ){
			if(driver.findElements(By.xpath(format (transactions,i)+"/div[@class='vins']/div[@class='vin']")).size() ==1 ){
					if(driver.findElements(By.xpath(format (transactions,i)+"/div[@class='vouts']/div)")).size() ==2){
						System.out.println(driver.findElement(By.xpath(format (transactions,i)+"//div[@class='txn']/a")).getText());
				}
			}
		}
	}
}
