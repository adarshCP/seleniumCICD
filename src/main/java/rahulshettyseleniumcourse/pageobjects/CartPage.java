package rahulshettyseleniumcourse.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyseleniumcourse.abstractmethods.AbstractMethods;

public class CartPage extends AbstractMethods {
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartItems;
	
	
	@FindBy(css="div[class*='subtotal'] button")
	WebElement proceedCheckoutButton;
	
	By cartItemsVisibility =By.xpath("//div[@class='cartSection']/h3");
	
	By proceedCheckoutButtonVisibility =By.cssSelector("div[class*='subtotal'] button");
	
	public List<WebElement> getCartItems() {
		waitforElementToAppear(cartItemsVisibility);
		return cartItems;
	}
	
	public boolean isAddedProductVisibleinCart(String productName) {
		boolean isAdded=getCartItems().stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return isAdded;
	
	}
	
	public CheckoutPage navigateToCheckout() {
		waitforElementToAppear(proceedCheckoutButtonVisibility);
		proceedCheckoutButton.click();
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		return checkoutPage;
	}
}
