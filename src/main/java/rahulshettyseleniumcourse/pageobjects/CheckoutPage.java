package rahulshettyseleniumcourse.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyseleniumcourse.abstractmethods.AbstractMethods;

public class CheckoutPage extends AbstractMethods {
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy (css="input[placeholder*='Select Country']")
	WebElement searchCountryField;
	
	
	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']/button[2]")
	WebElement optionIndia;
	
	@FindBy (css="a[class*='action__submit']")
	WebElement submitOrderButton;
	
	public void selectCountry() {
		scrollWindow();
		searchCountryField.sendKeys("Ind");
		optionIndia.click();
	}
	public OrderConfirmationPage submitOrder() {
		submitOrderButton.click();
		OrderConfirmationPage orderConfirmationPage= new OrderConfirmationPage(driver);
		return orderConfirmationPage;
	}
	}

