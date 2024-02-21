package com.salesforceBase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;
import com.salesforce.utilities.Constants;
import com.salesforce.utilities.ExtentReportsUtility;
import com.salesforce.utilities.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.salesforce.utilities.ListenerUtility.class)

public class SalesforceBaseTest {
	
	
	protected ExtentReportsUtility extentReport=ExtentReportsUtility.getInstance();

	protected Logger baseTestlog=LogManager.getLogger();
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUpBeforeMethod(@Optional("chrome") String name,ITestResult result) {
		
		baseTestlog.info(".........BeforeMethod setUpBeforeMethod executed---------------");
		launchBrowser(name);
		
		String url=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"url");
		goToUrl(url);
	}
	
	@AfterMethod
	public void tearDownAfterTestMethod() {
		closeBrowser();
		baseTestlog.info("******tearDownAfterTestMethod executed***********");
	}
	
	

	protected WebDriver  driver = null;
	public void launchBrowser(String browsername) {
		switch (browsername.toLowerCase()){
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("chrome launched successfully");
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				System.out.println("Edge launched successfully");
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				System.out.println("firefox launched successfully");
				break;
			default: 
				System.out.println("unsupported browser");
				break;
		
		}
	}
	
	public void goToUrl(String url) {
		driver.get(url);
		baseTestlog.info(url + "is entered");
		
	}
	
	public void closeBrowser() {
		driver.close();
		baseTestlog.info("browser instance closed");
		driver=null;
	}
	public void quitBrowser() {
		driver.quit();
		baseTestlog.info("all browser closed");
		driver=null;
		
	}
	
	public void takescreenshot(String filepath) {
		 TakesScreenshot screenCapture=(TakesScreenshot)driver;
		 File src=screenCapture.getScreenshotAs(OutputType.FILE);
		 File destination=new File(filepath);
		 try {
			Files.copy(src, destination);
			baseTestlog.info("captured the screen");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			baseTestlog.info("went wrong when capturing the screen");
			
		}
	}
	
	
	public void launchApp() throws InterruptedException {
		driver.get("https://login.salesforce.com/");
		if (driver.getTitle().equalsIgnoreCase("Login | Salesforce")) {
			System.out.println("Salesforce application page is displayed");
		}
		else {
			System.out.println("Failed ! Salesforce application page is not displayed");
		}	
		Thread.sleep(2000);
	}
	
	public void logInApp() throws InterruptedException {
		Thread.sleep(1000);
		WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		username.sendKeys("priya@tekarch.com");
		System.out.println("User Name is displayed in User name field");
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys("salesforce1");
		System.out.println("Password displayed in password feild");
//		WebElement rememberButton = driver.findElement(By.xpath("//*[@id=\"rememberUn\"]"));
//	    rememberButton.click();
		WebElement logButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/input[2]"));
		logButton.click();
		Thread.sleep(3000);
	    String title = driver.getTitle();
	    if(driver.getTitle().equalsIgnoreCase(title)) {
	    	System.out.println("Test pass. Salesforce homepage displayed");
	    }
	    else {
	    	System.out.println("test failed. Salesforce homepage not displayed");
	    }
	}
	
	public void logInApp(String username, String password) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"username\"]"))
			.sendKeys(username);
		System.out.println("User Name is displayed in User name field");
		driver.findElement(By.xpath("//*[@id=\"password\"]"))
			.sendKeys(password);
		System.out.println("Password displayed in password feild");

		WebElement logButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/input[2]"));
		logButton.click();
		Thread.sleep(3000);
	    String title = driver.getTitle();
	    if(driver.getTitle().equalsIgnoreCase(title)) {
	    	System.out.println("Test pass. Salesforce homepage displayed");
	    }
	    else {
	    	System.out.println("test failed. Salesforce homepage not displayed");
	    }
	}
	
	public void logOutApp() throws InterruptedException {
		Thread.sleep(3000);
		WebElement dropdown = driver.findElement(By.id("userNav-arrow"));
	    dropdown.click();
	    Thread.sleep(1000);
		WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
	    logout.click();
	    System.out.println("Home page loggedout successfully");
	}
}


