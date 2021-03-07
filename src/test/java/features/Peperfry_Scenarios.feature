Feature: Login Feature
  Verify if user is able to do end to end flow in to peperfy site

Background: User is Logged In
Given user launch Chrome browser to search peperfry site
Then user browse to pepperfry live website and click on profile
When user login to site using email and password

@uat 
Scenario: To verify you pay value on cart and address are same
Given user launch Chrome browser to search peperfry site
Then user browse to pepperfry live website and click on profile
When user login to site using email and password
And user search sofa which redirects to product list
And user clicks very first product from the list and product detail page gets open in new tab
And user selects 2 in the quantity dropdown and clicks on Buy Now button
And on cart page apply coupon "Republic" and store the You Pay values
And user click on Place Order button, it will redirect to address page
Then store the You Pay value on address
Then compare those with earlier stored You Pay value of cart


Scenario: To verify entering valid data address gets added in address book 
And hover on profile and click on My Account
And on redirected page click on My Address Book
Then click on Add New Address and pop will be displayed
Then enter all the valid details and save the address

@Test1
Scenario: To verify products getting added to wishlist
When hover on Furniture and click on 3 Seater Sofa
Then on redirected product listing page click on 1st product
Then it will open 1 product in new tab click on Add to wishlist and store the product name
When click on previous tab click on 2nd product from the list
Then it will open 2 product in new tab click on Add to wishlist and store the product name
Then click on Wishlist on the top section
Then Validate the products in the side panel
