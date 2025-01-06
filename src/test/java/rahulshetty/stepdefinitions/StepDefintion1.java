package rahulshetty.stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import RahulShettySeleniumCourse.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyseleniumcourse.pageobjects.CartPage;
import rahulshettyseleniumcourse.pageobjects.CheckoutPage;
import rahulshettyseleniumcourse.pageobjects.LoginPage;
import rahulshettyseleniumcourse.pageobjects.OrderConfirmationPage;
import rahulshettyseleniumcourse.pageobjects.PlpPage;

public class StepDefintion1 extends BaseTest {
	
	public LoginPage loginPage;
	public PlpPage plpPage;
	CheckoutPage checkoutPage;
	OrderConfirmationPage orderConfirmationPage;
	
	@Given("I landed on Ecommerce Website")
	public void I_landed_on_Ecommerce_Website() throws IOException {
		loginPage=launchApp();
	}
	
	@Given("^I logged in to the website with email (.+) and password (.+)$")
	public void I_logged_in_to_the_website_with_email_and_password(String email , String password) {
		 plpPage = loginPage.login(email,password);
	}
	@When("^I added product (.+) to cart$")
	public void  I_added_product_to_cart(String productName) throws InterruptedException {
		plpPage.addtoCart(productName);
	}
	@When ("^I proceeded to the checkout with product (.+) and submitted the order$")
	public void I_proceeded_to_the_checkout_with_product_and_submitted_the_order(String productName) {
		CartPage cartPage = plpPage.viewCart();

		boolean isAdded = cartPage.isAddedProductVisibleinCart(productName);
		Assert.assertTrue(isAdded);

		checkoutPage = cartPage.navigateToCheckout();

		checkoutPage.selectCountry();

		orderConfirmationPage = checkoutPage.submitOrder();
		
	}
	
	@Then("I verify the order id in the order confirmation page")
	public void  I_verify_the_order_id_in_the_order_confirmation_page() {
		String orderID = orderConfirmationPage.getOrderID();

		System.out.println("Order ID is "+orderID);
		driver.close();	
		}
	
	
	
	@Then("I verify the error message {string} is displayed")
	public void i_verify_the_error_message_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
		String loginErrorMessage = loginPage.getLoginErrorMsg();
		Assert.assertEquals(loginErrorMessage,string);
		driver.close();
	}
	
	
	
}
