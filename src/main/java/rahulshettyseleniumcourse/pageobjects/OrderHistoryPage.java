package rahulshettyseleniumcourse.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyseleniumcourse.abstractmethods.AbstractMethods;

public class OrderHistoryPage extends AbstractMethods {
	
	WebDriver driver;

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderHistoryItemNames;
	
	public List<WebElement> getOrderHistoryItemNames() {
		return orderHistoryItemNames;
	}
	
	
	

	
	public boolean isPlacedOrderVisibleInOrderHistoryPage(String productName) {
		boolean isOrderVisible=getOrderHistoryItemNames().stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return isOrderVisible;
	
	}
	
	
}
