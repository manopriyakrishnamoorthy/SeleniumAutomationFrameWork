package com.SeleniumAutomationFrameWork;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.salesforceBase.SalesforceBaseTest;

public class contacts extends SalesforceBaseTest {
	@Test
	public void  CreateNewContact() throws InterruptedException  {
		Thread.sleep(2000);
		WebElement contactTab = driver.findElement(By.xpath("//a[text()='Contacts']"));
		contactTab.click();
		System.out.println("clicked contact Tab");
		String title =driver.getTitle();
		if(title.trim().equalsIgnoreCase("Contacts: Home ~ Salesforce - Developer Edition")) {
			System.out.println("entered into New contact home page");
		}
		else {
			
			
			System.out.println("not entered to home page");
		}
		WebElement newcontact = driver.findElement(By.xpath("//input[@value=' New ']"));
		newcontact.click();
		System.out.println(driver.getTitle());
		String Expect ="Contact Edit: New Contact ~ Salesforce - Developer Edition";
		String actual = driver.getTitle();		
		if(actual.trim().equalsIgnoreCase(Expect)) {
			System.out.println("entered to contact edit page");
		}
		else {
			System.out.println("not entered to contact edit page");
		}
		WebElement lastname = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		lastname.sendKeys("geeta");
		WebElement AccountName = driver.findElement(By.xpath("//input[@id='con4']"));
		AccountName.sendKeys("priya moorthy");
		WebElement save = driver.findElement(By.xpath("//input[@value=' Save ']"));
		save.click();
		System.out.println(driver.getTitle());
		Expect = "Contact: geeta ~ Salesforce - Developer Edition";
		actual = driver.getTitle();
		if(actual.trim().equalsIgnoreCase(Expect)) {
			System.out.println("Test pass.new contact created page opened");
		}
		else {
			System.out.println("Test fail. new contact not opened");
		}
	
	}
	@Test
	public void CreateNewViewintheContactPage() throws InterruptedException {
		logInApp();
		Thread.sleep(2000);
		WebElement contactTab = driver.findElement(By.xpath("//a[text()='Contacts']"));
		contactTab.click();
		System.out.println("clicked contact Tab");
		WebElement createNewView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		createNewView.click();
		Thread.sleep(2000);
		System.out.println("new view page opened");
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		viewName.sendKeys("sales");
		Random random = new Random();
		String name = "salesforce" + random.nextInt(12345) + 10000;
		WebElement uniqviewName = driver.findElement(By.xpath("//input[@id='devname']"));
		uniqviewName.sendKeys(name);
		System.out.println("entered view name and uniq name");
		WebElement save = driver.findElement(By.xpath("//input[@value=' Save ']"));
		save.click();
		String Expect = "Contacts ~ Salesforce - Developer Edition";
		String actual = driver.getTitle();
		if(actual.trim().equalsIgnoreCase(Expect)) {
			System.out.println("Test pass. entered to contact page");
		}
		else {
			System.out.println("Test Fail. not entered to contact page");
		}
		
	}
	
	@Test
	public void CheckRecentlyCreatedContactInTheContactPage() throws InterruptedException {
		logInApp();
		Thread.sleep(2000);
		WebElement contactTab = driver.findElement(By.xpath("//a[text()='Contacts']"));
		contactTab.click();
		System.out.println("clicked contact Tab");
		Thread.sleep(2000);
		WebElement recentlyView = driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		Select dropdown = new Select(recentlyView);
		dropdown.selectByVisibleText("Recently Created");
		System.out.println("Test Pass. recent view displayed");
		
		
	}
	@Test
	
	public void ViewAContactInTheContactPage() throws InterruptedException {
		logInApp();
		WebElement contactTab = driver.findElement(By.xpath("//a[text()='Contacts']"));
		contactTab.click();
		System.out.println("clicked contact Tabpage displayed");
		Thread.sleep(2000);
		WebElement contactName = driver.findElement(By.xpath("//a[text()='geeta']"));
		contactName.click();
		String Expect = "Contact: geeta ~ Salesforce - Developer Edition";
		String actual = driver.getTitle();
		if(actual.trim().equalsIgnoreCase(Expect)) {
			System.out.println("Test pass.new contact created page opened");
		}
		else {
			System.out.println("Test fail. new contact not opened");
		}
		
	}
	@Test
	public void  CheckTheErrorMessage() throws InterruptedException {
		logInApp();
		Thread.sleep(2000);
		WebElement contactTab = driver.findElement(By.xpath("//a[text()='Contacts']"));
		contactTab.click();
		System.out.println("contact page displayed");
		WebElement viewpage = driver.findElement(By.xpath("//a[text()='Create New View']"));
		viewpage.click();
		System.out.println("create view page opened");
		WebElement uniqviewName = driver.findElement(By.xpath("//input[@id='devname']"));
		uniqviewName.sendKeys("EFGH");
		WebElement save = driver.findElement(By.xpath("//input[@value=' Save ']"));
		save.click();
		WebElement error = driver.findElement(By.xpath("//div[text()=' You must enter a value']"));
		String Expect = "Error: You must enter a value";
		System.out.println("Error msg : " + error.getText());
		String actual = error.getText();
		if(actual.trim().equalsIgnoreCase(Expect)) {
			System.out.println("Test pass. error msg shown");
		}
		else {
			System.out.println("Test Fail. error msg not shown");
		}
		
	}
	@Test
	public void ChecktheCancelButtonWorksfineinCreateNewView() throws InterruptedException {
		logInApp();
		Thread.sleep(2000);
		WebElement contactTab = driver.findElement(By.xpath("//a[text()='Contacts']"));
		contactTab.click();
		System.out.println("contact page displayed");
		WebElement viewpage = driver.findElement(By.xpath("//a[text()='Create New View']"));
		viewpage.click();
		System.out.println("create view page opened");
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		viewName.sendKeys("ABCD");
		WebElement uniqviewName = driver.findElement(By.xpath("//input[@id='devname']"));
		uniqviewName.sendKeys("EFGH");
		WebElement cancel = driver.findElement(By.xpath("//input[@value='Cancel']"));
		cancel.click();
		String title =driver.getTitle();
		if(title.trim().equalsIgnoreCase("Contacts: Home ~ Salesforce - Developer Edition")) {
			System.out.println("Test pass. opend the contact page without creating ABCD viewname");
		}
		else {
			System.out.println("Test fail.not opend contact page");
		}
	}
	@Test
	
	public void ChecktheSaveandNewButtonWorksinNewContactPage() throws InterruptedException {
		logInApp();
		Thread.sleep(2000);
		WebElement contactTab = driver.findElement(By.xpath("//a[text()='Contacts']"));
		contactTab.click();
		System.out.println("clicked contact Tab");
		String title =driver.getTitle();
		if(title.trim().equalsIgnoreCase("Contacts: Home ~ Salesforce - Developer Edition")) {
			System.out.println("entered into New contact home page");
		}
		else {
			System.out.println("not entered to home page");
		}
		WebElement newcontact = driver.findElement(By.xpath("//input[@value=' New ']"));
		newcontact.click();
		Thread.sleep(3000);
		WebElement lastname = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		lastname.sendKeys("Indian");
		WebElement AccountName = driver.findElement(By.xpath("//input[@id='con4']"));
		AccountName.sendKeys("Global Media");
		WebElement saveNew = driver.findElement(By.xpath("//input[@value='Save & New']"));
		saveNew.click();
		String Expect ="Contact Edit: New Contact ~ Salesforce - Developer Edition";
		String actual = driver.getTitle();		
		if(actual.trim().equalsIgnoreCase(Expect)) {
			System.out.println("entered to contact edit page with new edit name");
		}
		else {
			System.out.println("not entered to contact edit page");
		}
	}

//	public static void main(String[] args) throws InterruptedException {
//		// TODO Auto-generated method stub
//		contacts obj = new contacts();
//		obj.launchBrowser("chrome");
//		obj.launchApp();
//		obj.logInApp();
//		obj.CreateNewContact();
//		obj.logOutApp();
//		obj.CreateNewViewintheContactPage();
//		obj.logOutApp();
//		obj.CheckRecentlyCreatedContactInTheContactPage();
//		obj.logOutApp();
//		obj.ViewAContactInTheContactPage();
//		obj.logOutApp();
//		obj.CheckTheErrorMessage();
//		obj.logOutApp();
//		obj.ChecktheCancelButtonWorksfineinCreateNewView();
//		obj.logOutApp();
//		obj.ChecktheSaveandNewButtonWorksinNewContactPage();
//		
//	}

}
