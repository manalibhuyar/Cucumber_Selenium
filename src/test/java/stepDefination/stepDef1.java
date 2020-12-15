package stepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.When;

public class stepDef1 {
	@When ("^I launch Chrome browser$")
	public void I_enter_Username_as_and_Password_as() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwjR_OHEtcrtAhUMyzgGHa0gA8kQPAgI");
	  System.out.println("getting ff");
	} 
	@When ("^I open Google Homepage$")
	public void _enter_Username(){
	  System.out.println("hfhfj");
	} 
}
