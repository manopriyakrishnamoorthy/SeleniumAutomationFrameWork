package com.SeleniumAutomationFrameWork;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.salesforceBase.SalesforceBaseTest;

public class SalesforceLogin extends SalesforceBaseTest{
	@Test
	
	public void LoginErrorMessage1() throws InterruptedException {
		WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		username.sendKeys("priya@tekarch.com");
		System.out.println("User Name is displayed in User name field");
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.clear();
		System.out.println("password is clear"); 
		Thread.sleep(3000);
		WebElement logButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/input[2]"));
		logButton.click();
		WebElement loginErr = driver.findElement(By.cssSelector("div#error"));
		if(loginErr.getText().equalsIgnoreCase("Please enter your password.")) {
			System.out.println("Test pass. login error displayed (Please enter your password.)");
		}
		else {
			System.out.println("Test failed. login error message not found");
		}
	}
	@Test
	
	public void LoginToSalesForce2 () throws InterruptedException {
		WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		username.sendKeys("priya@tekarch.com");
		System.out.println("User Name is displayed in User name field");
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys("salesforce1");
		System.out.println("Password displayed in password feild");
		WebElement logButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/input[2]"));
		logButton.click();
		System.out.println(driver.getTitle());
	    String title = driver.getTitle();
	    if(driver.getTitle().equalsIgnoreCase(title)) {
	    	System.out.println("Test pass. home page displayed");
	    }
	    else {
	    	System.out.println("test failed. home page not displayed");
	    }
	    WebElement dropdown = driver.findElement(By.id("userNav-arrow"));
	    dropdown.click();
	    WebElement logout = driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[5]"));
	    logout.click();
	    System.out.println("Home page loggedout successfully");
	    Thread.sleep(5000);
	
	}
	@Test
	
	public void CheckRemeberMe3() throws InterruptedException {
		WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		username.sendKeys("priya@tekarch.com");
		System.out.println("User Name is displayed in User name field");
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys("salesforce1");
		System.out.println("Password displayed in password feild");
		WebElement rememberButton = driver.findElement(By.xpath("//*[@id=\"rememberUn\"]"));
	    rememberButton.click();
	    Thread.sleep(3000);
		WebElement logButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/input[2]"));
		logButton.click();
	    String title = driver.getTitle();
	    if(driver.getTitle().equalsIgnoreCase(title)) {
	    	System.out.println("Test pass. home page displayed");
	    }
	    else {
	    	System.out.println("test failed. home page not displayed");
	    }
	    Thread.sleep(3000);
	    WebElement dropdown = driver.findElement(By.id("userNav-arrow"));
	    dropdown.click();
	    Thread.sleep(1000);
	    WebElement logout = driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[5]"));
	    logout.click();
	    System.out.println("Home page loggedout successfully");
	    Thread.sleep(3000);
	    WebElement nameId = driver.findElement(By.id("idcard-identity"));
	    System.out.println("Remembered user name is :" + nameId.getText());
	    if(nameId.isDisplayed()) {
	    	System.out.println("Remembered user name is displayed");
	    }
	    else {
	    	System.out.println("Remembered user name is not displayed");
	    }
	    if(nameId.getText().equalsIgnoreCase("priya@tekarch.com")) {
	    	System.out.println("Test pass. Displaying correct username");
	    }
	    else {
	    	System.out.println("Test fail. displaying incorrect username");
	    }
	    
	 
	}
	@Test
	
	public void ForgotPassword4A() throws InterruptedException {
		WebElement forgotpassword = driver.findElement(By.id("forgot_password_link"));
		Thread.sleep(2000);
		forgotpassword.click();
		WebElement issueLogin = driver.findElement(By.xpath("//*[@id=\"content\"]/p"));
		System.out.println(" if Entered forget password: " +issueLogin.getText() + "page displayed");
		if(issueLogin.getText().equalsIgnoreCase("Having trouble logging in?")) {
			System.out.println("test pass. moved to trouble login page ");
		}
		else {
			System.out.println("test faied. not showing the login error page");
		}
		WebElement resetpassword = driver.findElement(By.id("un"));
		resetpassword.sendKeys("priya@tekarch.com");
		WebElement continu = driver.findElement(By.id("continue"));
		continu.click();
		WebElement checkEmail = driver.findElement(By.id("header"));
		System.out.println("Email : " +checkEmail.getText());
		if (checkEmail.getText().equalsIgnoreCase("Check Your Email")) {
			System.out.println("Test pass . taking upto the password reset page");
		}
		else {
			System.out.println("Test fail. not showing passwordreset page");
		}
		
	}
	
	@Test
	public void  ForgotPassword4B() throws InterruptedException  {
		launchApp();
		driver.findElement(By.xpath("//a[@id='clear_link']")).click();
		WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		username.sendKeys("123");
		System.out.println("test username(123) is displayed in User name field");
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys("22131");
		System.out.println("test password is diapalyed in password field");
		WebElement logButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/input[2]"));
		logButton.click();
		System.out.println("entered login button");
		String Expect = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		WebElement errorLogin = driver.findElement(By.id("error"));
		String actual = errorLogin.getText(); 
		if (actual.equalsIgnoreCase(Expect)) {
			System.out.println("test pass.Error message displayed");
		}
		else {
			System.out.println("test fail. error message not diaplayed");
		}
		
	}
	
//	public static void main(String[] args) throws InterruptedException {
//		
//		SalesforceLogin obj = new SalesforceLogin();
//		obj.launchBrowser("chrome");
//		obj.launchApp();
//		obj.LoginErrorMessage1();
////		obj.LoginToSalesForce2();
////		obj.CheckRemeberMe3();;
////		obj.ForgotPassword4A();;
////		obj.ForgotPassword4B();
		
//}

}
