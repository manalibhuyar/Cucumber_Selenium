package stepDefination;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import Pages.Peperfry_Page;
import Pages.page;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PeperfryPageSteps extends page {
	static Peperfry_Page peperfrypage= new Peperfry_Page();
	
	@When ("^user launch Chrome browser to search peperfry site$")
	public void user_opens_browser() {
		page.initialization();
	} 
	
	@Then("^user browse to pepperfry live website and click on profile$")
	public void user_browse_to_pepperfry_live_website_and_click_on_profile() throws Throwable {
	 Assert.assertTrue("User not landed on Peperfry HomePage", peperfrypage.isPeperfryPageDisplayed());
	 peperfrypage.clickOnProfileToLogin();
	 	
	}

	@When("^user login to site using email and password$")
	public void user_login_to_site_using_email_and_password() throws Throwable {
	Assert.assertTrue("Existing user login option not available", peperfrypage.clickExistingUserLogin());  
	Assert.assertTrue("existing user login page not displayed", peperfrypage.existingUserLoginPageDisplayed());
	peperfrypage.enterLoginDetails();
	}

	@When("^user search sofa which redirects to product list$")
	public void user_search_sofa_which_redirects_to_product_list() throws Throwable {
	   Assert.assertTrue("Search Option not displayed", peperfrypage.searchOptionEnabled());
	   peperfrypage.searchSofa(prop.getProperty("searchCategory"));
	}

	@When("^user clicks very first product from the list and product detail page gets open in new tab$")
	public void user_clicks_very_first_product_from_the_list_and_product_detail_page_gets_open_in_new_tab() throws Throwable {
		peperfrypage.selectFirstOption();
		Assert.assertTrue("Prudct deatils page not dispalyed", peperfrypage.verifyProductDetailPage());
	}

	@When("^user selects (\\d+) in the quantity dropdown and clicks on Buy Now button$")
	public void user_selects_in_the_quantity_dropdown_and_clicks_on_Buy_Now_button(int arg1) throws Throwable {
		peperfrypage.selectItemQuantity(arg1);
		Assert.assertTrue("Continue button is not enabled", peperfrypage.iscontinueEnabled());
		peperfrypage.clickContinue();
	}

	@When("^on cart page apply coupon \"([^\"]*)\" and store the You Pay values$")
	public void on_cart_page_apply_coupon_and_store_the_You_Pay_values(String arg1) throws Throwable {
//	   Assert.assertTrue("apply coupon option not displayed", peperfrypage.applyCouponDisplayed());
	   peperfrypage.applyCoupon(arg1);
	}

	@When("^user click on Place Order button, it will redirect to address page$")
	public void user_click_on_Place_Order_button_it_will_redirect_to_address_page() throws Throwable {
		peperfrypage.clickPlaceOrder();
	}

	@Then("^store the You Pay value on address$")
	public void store_the_You_Pay_value_on_address() throws Throwable {
		Assert.assertTrue("Address Page not dipplayed", peperfrypage.VerifyAddressPageDetails());
	}

	@Then("^compare those with earlier stored You Pay value of cart$")
	public void compare_those_with_earlier_stored_You_Pay_value_of_cart() throws Throwable {
		Assert.assertTrue("Values mismatch on both pages",peperfrypage.verifyValues()); 
	}
	
	@When("^hover on profile and click on My Account$")
	public void hover_on_profile_and_click_on_My_Account() throws Throwable {
		peperfrypage.clickMyAccount();
	}

	@When("^on redirected page click on My Address Book$")
	public void on_redirected_page_click_on_My_Address_Book() throws Throwable {
		peperfrypage.clickMyAddressBook();
	}

	@Then("^click on Add New Address and pop will be displayed$")
	public void click_on_Add_New_Address_and_pop_will_be_displayed() throws Throwable {
		peperfrypage.clickAddNewAddress();
		Assert.assertTrue("Add address pop up is not displayed", peperfrypage.addAddressPopUpDisplayed());
	}

	@Then("^enter all the valid details and save the address$")
	public void enter_all_the_valid_details_and_save_the_address() throws Throwable {
		peperfrypage.addPincode();
		peperfrypage.addFirstName();
		peperfrypage.addLastName();
		peperfrypage.addMobileNum();
		peperfrypage.addArea();
		peperfrypage.addLandmark();
		peperfrypage.addCity();
		peperfrypage.selectState();
		peperfrypage.clickSave();
	}


@When("^hover on Furniture and click on (\\d+) Seater Sofa$")
public void hover_on_Furniture_and_click_on_Seater_Sofa(int arg1) throws Throwable {
   Assert.assertTrue("Furniture tab not displayed", peperfrypage.furnitureTabDisplayed());
   peperfrypage.select3SeaterSofa();
}

@Then("^on redirected product listing page click on (\\d+)st product$")
public void on_redirected_product_listing_page_click_on_st_product(int arg1) throws Throwable {
    Assert.assertTrue("Product listing page not displayed", peperfrypage.productListingPageDisplayed());
    peperfrypage.selectFirstProduct();
}

@Then("^it will open product in new tab click on Add to wishlist and store the product name$")
public void it_will_open_product_in_new_tab_click_on_Add_to_wishlist_and_store_the_product_name() throws Throwable {
	
}

@Then("^it will open (\\d+) product in new tab click on Add to wishlist and store the product name$")
public void it_will_open_product_in_new_tab_click_on_Add_to_wishlist_and_store_the_product_name(int arg1) throws Throwable {
	Assert.assertTrue("Product deatils page not dispalyed", peperfrypage.verifyProductDetailPage());
	peperfrypage.addToWishList(arg1);
}


@When("^click on previous tab click on (\\d+)nd product from the list$")
public void click_on_previous_tab_click_on_nd_product_from_the_list(int arg1) throws Throwable {
//	Assert.assertTrue("Product deatils page not dispalyed", peperfrypage.verifyProductDetailPage());
	peperfrypage.selectSecondProduct();
}

@Then("^click on Wishlist on the top section$")
public void click_on_Wishlist_on_the_top_section() throws Throwable {
	peperfrypage.goToWishlist();
}

@Then("^Validate the products in the side panel$")
public void validate_the_products_in_the_side_panel() throws Throwable {
	Assert.assertTrue("wishlist tab not dipslayed", peperfrypage.VerifyWishListTab());
  Assert.assertTrue("Product added to wishlist is not correct", peperfrypage.verifyWishlistedProduct());
}

	
	
}
