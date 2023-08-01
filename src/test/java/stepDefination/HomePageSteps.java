package stepDefination;

import io.cucumber.java.en.And;

import Pages.HomePage;
import Pages.page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

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


	@And("user lands on blockstream page")
	public void userLandsOnBlockstreamPage() {
		homepage.validateBlockStreamPage();
	}

	@Then("user validates section has heading {string}")
		public void userValidatesSectionHasHeading(String msg) {
		homepage.validateHeading(msg);
	}

	@Then("user prints transaction for one input and two output")
	public void userPrintsTransactionForOneInputAndTwoOutput() {
		homepage.printHashcodeOfTransaction();
	}
}
