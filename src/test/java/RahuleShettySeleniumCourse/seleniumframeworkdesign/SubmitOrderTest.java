package RahuleShettySeleniumCourse.seleniumframeworkdesign;

import java.io.IOException;
import java.io.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RahulShettySeleniumCourse.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyseleniumcourse.pageobjects.CartPage;
import rahulshettyseleniumcourse.pageobjects.CheckoutPage;
import rahulshettyseleniumcourse.pageobjects.LoginPage;
import rahulshettyseleniumcourse.pageobjects.OrderConfirmationPage;
import rahulshettyseleniumcourse.pageobjects.OrderHistoryPage;
import rahulshettyseleniumcourse.pageobjects.PlpPage;
import java.io.File;
import org.openqa.selenium.TakesScreenshot;
public class SubmitOrderTest extends BaseTest {

	@Test(dataProvider = "getData", groups = "submitOrder")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		// TODO Auto-generated method stub

		PlpPage plpPage = loginPage.login(input.get("email"), input.get("password"));

		List<WebElement> productList = plpPage.getProductList();
		

		plpPage.addtoCart(input.get("productName"));

		CartPage cartPage = plpPage.viewCart();

		boolean isAdded = cartPage.isAddedProductVisibleinCart(input.get("productName"));
		Assert.assertTrue(isAdded);

		CheckoutPage checkoutPage = cartPage.navigateToCheckout();

		checkoutPage.selectCountry();

		OrderConfirmationPage orderConfirmationPage = checkoutPage.submitOrder();
		String orderID = orderConfirmationPage.getOrderID();

		System.out.println(orderID);

	}

	@Test(dependsOnMethods = { "submitOrder" })

	public void orderHistoryTest() {

		PlpPage plpPage = loginPage.login("adarshp@mail.com", "Password@123");

		OrderHistoryPage orderHistoryPage = plpPage.viewOrders();
//		Assert.assertTrue(orderHistoryPage.isPlacedOrderVisibleInOrderHistoryPage(productName));
//		
	}

	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "adarshp@mail.com");
//		map.put("password", "Password@123");
//		map.put("productName", "IPHONE 13 PRO");
//
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "adarshp@mail.com");
//		map1.put("password", "Password@123");
//		map1.put("productName", "IPHONE 13 PRO");
		List<HashMap<String,String>> jsonData=getJSONTestData(System.getProperty("user.dir")+"\\src\\test\\java\\purchaseorderdata\\purchaseorderdata.json");
		

		return new Object[][] { {jsonData.get(0) },{jsonData.get(1) } };
	}
	
	
	

}

