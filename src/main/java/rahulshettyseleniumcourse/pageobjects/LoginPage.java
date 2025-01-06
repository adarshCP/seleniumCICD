package rahulshettyseleniumcourse.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyseleniumcourse.abstractmethods.AbstractMethods;

/**
 * Hello world!
 */
public class LoginPage extends AbstractMethods {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='userEmail']")
	private WebElement userEmail;
	
	@FindBy(xpath = "//input[@id='userPassword']")
	private WebElement userPassword;
	
	@FindBy(xpath = "//input[@id='login']")
	private WebElement userLogin;

	
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	private WebElement loginError;
	
	public PlpPage login(String email,String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		userLogin.click();
		PlpPage plpPage=new PlpPage(driver);
		return plpPage;
	}
	
	
	public void goToWeb() {
		driver.get("https://rahulshettyacademy.com/client/");
		
	}
	
	public String getLoginErrorMsg() {
		waitforWebElementToAppear(loginError);
		String loginErrorMessage =loginError.getText();
		return loginErrorMessage;
	}
	
}
