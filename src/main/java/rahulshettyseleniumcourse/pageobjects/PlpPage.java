package rahulshettyseleniumcourse.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyseleniumcourse.abstractmethods.AbstractMethods;

/**
 * Hello world!
 */
public class PlpPage extends AbstractMethods {
	WebDriver driver;

	public PlpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//	List<WebElement> products = driver.findElements(
//			By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
	
	@FindBy(xpath = "//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']")
	List<WebElement> productList;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By elementLocated =By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']");
	
	By addtocartButtom=By.cssSelector(".card-body button:last-of-type");
	
	By toastContainer =By.cssSelector("#toast-container");
	
	
	
	public List<WebElement> getProductList() {
		waitforElementToAppear(elementLocated);
		return productList;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return prod;
	}
	
	public void addtoCart(String productName) throws InterruptedException {
		
		WebElement prod=getProductByName(productName);
		scrollWindow();
		waitforWebElementToAppear(prod.findElement(addtocartButtom));
		
	    prod.findElement(addtocartButtom).click();
		waitforElementToAppear(toastContainer);
		waitforElementToDissapear(spinner);
		
	}
	
	
}
