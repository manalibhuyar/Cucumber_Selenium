package Pages;

import java.util.NoSuchElementException;
import java.util.Set;
import resources.*;
import Pages.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Peperfry_Page extends page {

	@FindBy(id="registerPopupLink")
	private WebElement login;

	@FindBy(xpath="//div[@class='nav_cart_wish_wrap']/div[4]")
	private WebElement profile;

	@FindBy(xpath="//*[@id='regPopUp']/div/div[2]/div[2]/div[1]/a")
	private WebElement existingUserLogin;

	@FindBy(name="user[new]")
	private WebElement email;

	@FindBy(id="password")
	private WebElement password;

	@FindBy(id="formSubmit-popup_login_username_form")
	private WebElement log_in;

	@FindBy(id="search")
	private WebElement search;

	@FindBy(id="searchButton")
	private WebElement searchButton;

	@FindBy(xpath="//div[@class='row srch-rslt-prod-container']/div/div/div[2]/a")
	private WebElement firstOption;

	@FindBy(id="select2-quantity-container")
	private WebElement quantityContainer;

	@FindBy(xpath="//ul[@class='select2-results__options']/li[2]")
	private WebElement quantity;

	@FindBy(id="vipBuyNowButton")
	private WebElement buyNow;

	@FindBy(name="coupon_code")
	private WebElement coupon_code;

	@FindBy(id="total_pay_coupon")
	private WebElement total_pay_coupon;

	@FindBy(xpath="//span[@class='ck-proceed-btn-wrap']/a[1]")
	private WebElement placeOrder;

	@FindBy(id="address")
	private WebElement address;

	@FindBy(xpath="//div[@class='profile-tooltip-list']/div[2]/a")
	private WebElement myAccount;

	@FindBy(xpath="//*[@id='address']/a")
	private WebElement addAddress;

	@FindBy(xpath="//*[@id='editAddressBlock']/label/a")
	private WebElement addNewAddress;

	@FindBy(id="my-addr-book-newaddr-popup")
	private WebElement addAddressPopUp;

	@FindBy(id="postcode")
	private WebElement postcode;

	@FindBy(id="name")
	private WebElement firstName ;

	@FindBy(id="name2")
	private WebElement lastName ;

	@FindBy(id="mobile")
	private WebElement mobileNumber;

	@FindBy(id="street")
	private WebElement streetAddress;

	@FindBy(id="area")
	private WebElement area;

	@FindBy(id="landmark")
	private WebElement landmark;

	@FindBy(id="city")
	private WebElement city;

	@FindBy(id="select2-selectState-result-j586-Maharashtra")
	private WebElement state;

	@FindBy(id="saveAddress")
	private WebElement saveAddress;
	
	@FindBy(xpath="//*[@id='menu_wrapper']/ul/li[1]/a")
	private WebElement furnitureTab;
	
	@FindBy(xpath="//*[@id='meta-furniture']/div/div[1]/div[2]/div[4]/a")
	private WebElement threeSeaterSofa;
	
	@FindBy(css=".clip-main-title.pf-center")
	private WebElement allThreeSeaterSofaPage;
	
	@FindBy(xpath="//*[@id='productView']/div[1]/div/div[3]/div/h2/a")
	private WebElement firstThreeSeaterSofa;
	
	@FindBy(css="vipProduct__wishlist.add-to-wishlist.")
	private WebElement addToWishList;
	
	@FindBy(className="v-pro-ttl.pf-medium-bold-text")
	private WebElement firstSofaName;
	
	@FindBy(xpath="//*[@id='productView']/div[2]/div/div[3]/div/h2/a")
	private WebElement secondThreeSeaterSofa;
	
	@FindBy(className="wishlist_bar")
	private WebElement wishList;
	
	@FindBy(id="mini-userwishlist-tab")
	private WebElement wishListTab;
	
	@FindBy(xpath="//*[@id='mCSB_11_container']/div[1]/div/div/div[2]/p[1]/a")
	private WebElement wishListedFirstItem;
	
	@FindBy(xpath="//*[@id='mCSB_11_container']/div[1]/div/div/div[2]/p[1]/a")
	private WebElement wishListedSecItem;
	
	public String parentWindow="";
	public String parentWindowTitle="";
	public String couponValue="";
	public String addressPageValue="";
	public String firstWishlistedProd="";
	public String secondWishlistedProd="";

	public boolean isPeperfryPageDisplayed() throws InterruptedException {
		Thread.sleep(4000);
		Log.info("**************************");
		PageFactory.initElements(driver, this);

		parentWindowTitle=driver.getTitle();
		Log.info("Title of home page is:"+ parentWindowTitle);

		Assert.assertTrue("user not landed on peperfry page", driver.getTitle().contains("Online Furniture"));

		if(driver.getTitle().contains("Online Furniture"))
			return true;
		else
			return false;
	}


	public void clickOnProfileToLogin() {
		//		action.moveToElement(profile);
		//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("registerPopupLink")));
		//		Log.info("Clicking on login button");
		////		login.click();
	}


	public void enterLoginDetails() {
		this.email.sendKeys(prop.getProperty("email"));
		this.password.sendKeys(prop.getProperty("password"));
		this.log_in.click();
	}


	public boolean clickExistingUserLogin() {
		return this.existingUserLogin.isDisplayed();
	}


	public boolean existingUserLoginPageDisplayed() throws InterruptedException {
		this.existingUserLogin.click();
		Thread.sleep(5000);
		if(this.email.isDisplayed())
			return true;
		else
			return false;
	}


	public boolean searchOptionEnabled() {
		return this.search.isEnabled();
	}


	public void searchSofa(String property) throws InterruptedException {
		Log.info("Seraching for Sofa");
		System.out.println("Seraching for Sofa");
		System.out.println("property to search"+ property);
		Thread.sleep(3000);
		this.search.sendKeys(property);
		this.searchButton.click();
	}


	public void selectFirstOption() {
		Log.info("Clicking on first enlisted product");
		System.out.println("Clicking on first enlisted product");
		wait.until(ExpectedConditions.elementToBeClickable(firstOption));
		parentWindow=this.driver.getWindowHandle();
		Log.info("Parent window foun is:"+ parentWindow);
		System.out.println("Parent window foun is:"+ parentWindow);
		this.firstOption.click();

	}

	public boolean verifyProductDetailPage() throws InterruptedException {
		Thread.sleep(4000);
		Set<String> allWindowHandles = driver.getWindowHandles();
		for(String handle : allWindowHandles)
		{
			Log.info("Switching to window - > " + handle);
			System.out.println("Switching to window - > " + handle);
			driver.switchTo().window(handle); 
		}
		if(parentWindowTitle.equalsIgnoreCase(driver.getTitle()))
			return false;
		else
			return true;
	}


	public void selectItemQuantity(int arg1) {
		Log.info("Selecting product quantity");
		this.quantityContainer.click();
		this.quantity.click();
	}

	public boolean iscontinueEnabled() {
		return	this.buyNow.isEnabled();
	}

	public void clickContinue() {
		Log.info("Clicking on Buy Now");
		System.out.println("Clicking on Buy Now");
		this.buyNow.click();
	}

	public boolean applyCouponDisplayed() throws InterruptedException {
		Thread.sleep(10000);
		return this.coupon_code.isDisplayed();
	}

	public void applyCoupon(String coupon) {
		Log.info("Entering the coupon code: "+coupon);
		System.out.println("Entering the coupon code: "+coupon);
		//		this.coupon_code.sendKeys(coupon);
		couponValue=this.total_pay_coupon.getAttribute("innerText");
		Log.info("coupon Value on capture page is :"+ couponValue);
		System.out.println("coupon Value on capture page is :"+ couponValue);
	}

	public void clickPlaceOrder() {
		Log.info("Clicking on place order");
		this.placeOrder.click();
	}

	public boolean VerifyAddressPageDetails() {
		Log.info("Getting total amount displayed on address page:"+ total_pay_coupon);
		System.out.println("Getting total amount displayed on address page:"+ total_pay_coupon.getAttribute("innerText"));
		addressPageValue=this.total_pay_coupon.getAttribute("innerText");
		return this.address.isDisplayed();
	}

	public boolean verifyValues() {
		Log.info("Verifying both page toatl values are same or not !");
		System.out.println("Verifying both page toatl values are same or not !");
		if(addressPageValue==couponValue)
			return true;
		else
			return false;
	}


	public void clickMyAccount() throws InterruptedException {
		System.out.println("clcking on my account");
		Thread.sleep(6000);
		this.myAccount.click();
	}


	public void clickMyAddressBook() {
		System.out.println("clicking on add address");
		this.addAddress.click();

	}

	public boolean addAddressPopUpDisplayed() throws InterruptedException {
		Thread.sleep(2000);
		return this.addAddressPopUp.isDisplayed();
	}


	public void clickAddNewAddress() {
		System.out.println("Adding a address");
		this.addNewAddress.click();
	}


	public void addPincode() {
		try {
			System.out.println("adding pincode:"+ prop.getProperty("pincode"));
			this.postcode.sendKeys(prop.getProperty("pincode"));
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e);
		}
	}


	public void addFirstName() {
		try 
		{
			System.out.println("adding first name:"+ prop.getProperty("firstName"));
			this.firstName.sendKeys(prop.getProperty("firstName"));
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e);
		}
	}


	public void addLastName() {
		try 
		{
			System.out.println("adding last name:"+ prop.getProperty("lastName"));
			this.lastName.sendKeys(prop.getProperty("lastName"));
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e);
		}
	}


	public void addMobileNum() {
		try 
		{
			System.out.println("adding mobile number:"+ prop.getProperty("mobile"));
			this.mobileNumber.sendKeys(prop.getProperty("mobile"));
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e);
		}
	}


	public void addArea() {
		try 
		{
			System.out.println("adding area name:"+ prop.getProperty("area"));
			this.area.sendKeys(prop.getProperty("area"));
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e);
		}
	}


	public void addLandmark() {
		System.out.println("adding landamrk name:"+ prop.getProperty("landmark"));
		this.landmark.sendKeys(prop.getProperty("landmark"));

	}


	public void addCity() {
		try 
		{
			System.out.println("adding city name:"+ prop.getProperty("city"));
			this.city.sendKeys(prop.getProperty("city"));
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e);
		}
	}


	public void clickSave() {
		try 
		{
			System.out.println("saving the address");
			this.saveAddress.click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e);
		}
	}


	public void selectState() {
		try 
		{
			System.out.println("adding state name:");
			this.state.click();;
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e);
		}
	}


	public boolean furnitureTabDisplayed() {
		boolean flag=false;
		try {
		if(	this.furnitureTab.isDisplayed())
			flag= true;
		}
		catch(NoSuchElementException e)
		{
			Pages.Log.info("Exception found is:"+e);
		}
		return flag;
	}


	public void select3SeaterSofa() throws InterruptedException {
		Log.info("Moving to furniture tab");
		Thread.sleep(4000);
		action.moveToElement(furnitureTab).perform();
		Log.info("Selecting 3 seater sofa tab");
		Thread.sleep(4000);
		this.threeSeaterSofa.click();
	}


	public boolean productListingPageDisplayed() throws InterruptedException {
		boolean flag= false;
		Thread.sleep(4000);
		try {
			if(this.allThreeSeaterSofaPage.isDisplayed())
				flag=true;
		}
		catch(NoSuchElementException e)
		{
			Pages.Log.info(" "+e);
		}
		return flag;
	}


	public void selectFirstProduct() {
		Pages.Log.info("selecting first enlisted sofa");
		Log.info("Clicking on first enlisted product");
		System.out.println("Clicking on first enlisted product");
		wait.until(ExpectedConditions.elementToBeClickable(firstThreeSeaterSofa));
		parentWindow=this.driver.getWindowHandle();
		Log.info("Parent window foun is:"+ parentWindow);
		System.out.println("Parent window foun is:"+ parentWindow);
		this.firstThreeSeaterSofa.click();
		
	}


	public void addToWishList(int item) {
		Pages.Log.info("Adding product to wishList");
		this.addToWishList.click();
		if(item==1)
		{
		firstWishlistedProd= this.firstSofaName.getAttribute("innerText");
		Pages.Log.info("First Wishlisted product is:"+ firstWishlistedProd);
		}
		else if(item==2)
		{
			secondWishlistedProd= this.firstSofaName.getAttribute("innerText");
			Pages.Log.info("First Wishlisted product is:"+ secondWishlistedProd);
		}
		Pages.Log.info("Going back to all sofa page");
		driver.close();
		driver.switchTo().window(parentWindow);
	}


	public void selectSecondProduct() {
		Pages.Log.info("Selecting second product from sofa page");
		this.secondThreeSeaterSofa.click();
	}


	public void goToWishlist() {
		Pages.Log.info("checking wishllisted product");
		this.wishList.click();
		
	}


	public boolean verifyWishlistedProduct() {
		Pages.Log.info("Verifying wishlisted products");
		Pages.Log.info("first item text: "+ wishListedFirstItem.getAttribute("innerText"));
		Pages.Log.info("second item text: "+ wishListedSecItem.getAttribute("innerText"));
		if((wishListedFirstItem.getAttribute("innerText").equals(secondWishlistedProd)) && (wishListedSecItem.getAttribute("innerText").equals(firstWishlistedProd)))
		return true;
		else
			return false;
	}


	public boolean VerifyWishListTab() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mini-userwishlist-tab")));
		Pages.Log.info("verifying wish list tab displayed or not");
		return this.wishListTab.isDisplayed();
	}









}
