package RahuleShettySeleniumCourse.seleniumframeworkdesign;

import java.time.Duration;
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
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyseleniumcourse.pageobjects.LoginPage;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		LoginPage loginpage= new LoginPage(driver);

		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("adarshp@mail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']")));
		

		List<WebElement> products = driver.findElements(
				By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
		System.out.println(products);

		// Using for loop

//		for (int i =0 ; i<products.size();i++) {
//			String productName =products.get(i).findElement(By.cssSelector("div[class='card-body'] h5 b")).getText();
//			
//			if (productName.equalsIgnoreCase("ZARA coat 3")) {
//				products.get(i).findElement(By.cssSelector(".card-body button:last-of-type")).click();
//				break;
//			}
//		}

		// Using Streams
		String productName ="IPHONE 13 PRO";

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
				.findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		
	

		List<WebElement> cartItems= driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		
		System.out.println(cartItems);
		boolean isProductAddedtoCart =cartItems.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(isProductAddedtoCart);
		

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='subtotal'] button")));
		
		driver.findElement(By.cssSelector("div[class*='subtotal'] button")).click();
		
		js.executeScript("window.scrollBy(0,13000)");
		
		driver.findElement(By.cssSelector("input[placeholder*='Select Country']")).sendKeys("Ind");
		
		driver.findElement(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button[2]")).click();
		
		
		
		
		
//		Thread.sleep(3000);
		
		WebElement submitOrderButton=driver.findElement(By.cssSelector("a[class*='action__submit']"));
		
		
		submitOrderButton.click();
		
		String orderID=driver.findElement(By.cssSelector("tr td label[class*='ng-star-inserted']")).getText();
		
		System.out.println("Order No -"+orderID);
		
		driver.quit();
	}
}
