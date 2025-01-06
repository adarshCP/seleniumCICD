package RahulShettySeleniumCourse.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyseleniumcourse.pageobjects.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public LoginPage loginPage;
	public WebDriver intializeDriver() throws IOException {
		
		Properties pro =new Properties();
		FileInputStream fileSc=new FileInputStream (System.getProperty("user.dir")+"//src//main//java//rahulshettyseleniumcourse//resources//Global.properties");
		pro.load(fileSc);
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : pro.getProperty("browser");
		
		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
				
				
			}
			driver= new ChromeDriver(options);
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	@BeforeMethod	(alwaysRun=true)
	public LoginPage launchApp() throws IOException  {
		driver = intializeDriver();
		loginPage= new LoginPage(driver);
		loginPage.goToWeb();
		return loginPage;
	}
	@AfterMethod (alwaysRun=true)
	public void closeBrowser() {
		driver.close();
	}
	
	public List<HashMap<String, String>> getJSONTestData(String filePath) throws IOException {
	 String jsonData=	FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	 
	 ObjectMapper mapper =new ObjectMapper();
	 List<HashMap<String,String>> data =mapper.readValue(jsonData, new TypeReference<List<HashMap<String,String>>>(){});
	return data;
	};
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}
}
