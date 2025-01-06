package rahulshettyseleniumcourse.abstractmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyseleniumcourse.pageobjects.CartPage;
import rahulshettyseleniumcourse.pageobjects.OrderHistoryPage;

public class AbstractMethods {
	WebDriver driver;
	
	

	
	public AbstractMethods(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css= "button[routerlink*='cart']")
	WebElement viewCartButton;
	
	@FindBy(css= "button[routerlink*='myorders']")
	WebElement viewOrdersButton;
	
	public CartPage viewCart() {
		viewCartButton.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}
	
	public OrderHistoryPage viewOrders() {
		viewOrdersButton.click();
		OrderHistoryPage orderHistoryPage=new OrderHistoryPage(driver);
		return orderHistoryPage;
	}
	
	
	
	
	public void waitforElementToAppear(By elementLocated) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocated));
		
	}
	
	public void waitforWebElementToAppear(WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
		
	public void waitforElementToDissapear(WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
	
	public void scrollWindow() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,5000)");
	}
	
	

}
