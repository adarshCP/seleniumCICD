package rahulshettyseleniumcourse.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyseleniumcourse.abstractmethods.AbstractMethods;

public class OrderConfirmationPage extends AbstractMethods {
	
	WebDriver driver;

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
		
		}
	
	
	
	@FindBy(css="tr td label[class*='ng-star-inserted']")
	private WebElement orderID;
	
	public String getOrderID() {
		String orderIDText= orderID.getText();
		String[] splittedOrderIDs=orderIDText.split(" ");
		String OrderIDConverted =splittedOrderIDs[1];
		return OrderIDConverted;
		
		
	}

	
	}

