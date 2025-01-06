package RahuleShettySeleniumCourse.seleniumframeworkdesign;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import RahulShettySeleniumCourse.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyseleniumcourse.pageobjects.CartPage;
import rahulshettyseleniumcourse.pageobjects.CheckoutPage;
import rahulshettyseleniumcourse.pageobjects.LoginPage;
import rahulshettyseleniumcourse.pageobjects.OrderConfirmationPage;
import rahulshettyseleniumcourse.pageobjects.PlpPage;

public class LoginErrorValidationTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer = RahulShettySeleniumCourse.TestComponents.Retry.class)
	public void LoginErrorValidation() throws IOException {

		// TODO Auto-generated method stub

		loginPage.login("adarsxahp@mail.com", "Password@123");
		String loginErrorMessage = loginPage.getLoginErrorMsg();
		Assert.assertEquals(loginErrorMessage, "Incorrect email sor password.");

	}
	
	@Test 
	public void productAddedToCartTest() throws IOException, InterruptedException {

		// TODO Auto-generated method stub

		PlpPage plpPage = loginPage.login("adarshp@mail.com", "Password@123");

		List<WebElement> productList = plpPage.getProductList();
		System.out.println(productList);

		String productName = "IPHONE 13 PRO";
		plpPage.addtoCart(productName);

		CartPage cartPage = plpPage.viewCart();

		boolean isAdded = cartPage.isAddedProductVisibleinCart(productName);
		Assert.assertFalse(isAdded);

	}
}
