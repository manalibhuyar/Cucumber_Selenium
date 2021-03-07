package stepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.Peperfry_Page;
import Pages.page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps extends page {

	static HomePage homepage= new HomePage();
	
	@When ("^user launch Chrome browser$")
	public void user_opens_browser() {
		page.initialization();
	} 
	
	@Given("^user access cleartrip page$")
	public void user_access_cleartrip_page() throws Throwable {
		homepage.verifyUserLand();
		}
	
	@When("^user seraches for flights$")
	public void user_seraches_for_flights() throws Throwable {
		homepage.userSearchesFlights();
	}

	@Then("^user enters journey details$")
	public void user_enters_journey_details() throws Throwable {
		homepage.userEntersDetails();
	}
	@Then("^user continues with flight search$")
	public void user_continues_with_flight_search() throws Throwable {
		homepage.searchFlights();
	}


}
