package com.SeleniumAutomationFrameWork;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.salesforceBase.SalesforceBaseTest;

public class SalesforceLeads extends SalesforceBaseTest {
	
	@Test
	public void TC20LeadsTab() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement Leads = driver.findElement(By.xpath("//a[text()=\"Leads\"]"));
		Leads.click();
		Thread.sleep(3000);
		WebElement leadshome = driver.findElement(By.xpath("//a[text()='Leads']"));
		System.out.println(driver.getTitle());
		String titleSelected = leadshome.getAttribute("title");
		
		System.out.println(titleSelected);
		
		if(titleSelected.trim().endsWith("Selected")) {
			System.out.println("Test pass .  Entered into Leads homepage");
		}
		else {
			System.out.println("Test fail. page not supported");
		}
		
	}
	@Test
	public void  TC21LeadsSelectView() throws InterruptedException {
		TC20LeadsTab();
		WebElement dropdown = driver.findElement(By.id("fcf"));
		dropdown.click();
		System.out.println("Leads dropdown option " + dropdown.getText());	
	}
	@Test
	public void  TC22defaultView() throws InterruptedException {
		TC21LeadsSelectView();
		WebElement dropdown = driver.findElement(By.id("fcf"));
		Select selectLead = new Select(dropdown);
	    selectLead.selectByIndex(3);
	    WebElement Go = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
	    Go.click();
	    System.out.println("Todays Leads selected");
	    logOutApp();
	    Thread.sleep(3000);
	    logInApp();
	    WebElement Leads = driver.findElement(By.xpath("//a[text()=\"Leads\"]"));
		Leads.click();
		Thread.sleep(3000);
		WebElement leadshome = driver.findElement(By.xpath("//a[text()='Leads']"));
		String titleSelected = leadshome.getAttribute("title");
		System.out.println(titleSelected);
		
		if(titleSelected.trim().endsWith("Selected")) {
			System.out.println("Test pass .  Entered into Leads homepage");
		}
		else {
			System.out.println("Test fail. page not supported");
		}
		Go  = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
	    Go.click();
	    System.out.println("Todays Leads selected");
	}
	    @Test
	    public void  LeadsTC23() throws InterruptedException {
	    	logInApp();
	    	WebElement Leads = driver.findElement(By.xpath("//a[text()=\"Leads\"]"));
			Leads.click();
			Thread.sleep(3000);
			WebElement leadshome = driver.findElement(By.xpath("//a[text()='Leads']"));
			String titleSelected = leadshome.getAttribute("title");
			System.out.println(titleSelected);
			
			if(titleSelected.trim().endsWith("Selected")) {
				System.out.println("Test pass .  Entered into Leads homepage");
			}
			else {
				System.out.println("Test fail. page not supported");
			}
			WebElement Go  = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		    Go.click();
		    System.out.println("Todays Leads selected");
		}
	@Test
	public void  LeadsTC24() throws InterruptedException {
		logInApp();
		WebElement Leads = driver.findElement(By.xpath("//a[text()=\"Leads\"]"));
		Leads.click();
		Thread.sleep(3000);
		WebElement newButton = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		newButton.click();
		WebElement lastName = driver.findElement(By.id("name_lastlea2"));
		lastName.sendKeys("ABCD");
		WebElement company = driver.findElement(By.id("lea3"));
		company.sendKeys("ABCD");
		WebElement save = driver.findElement(By.xpath("//input[@name='save']"));
		save.click();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		WebElement topname = driver.findElement(By.xpath("//h2[@class='topName']"));
		if(topname.getText().trim().equalsIgnoreCase("ABCD")) {
			System.out.println("test pass.Lead created successfully");		
		}
		else {
			System.out.println("test fail. lead not created");
		}
	}
	
//	public static void main(String[] args) throws InterruptedException {
//		SalesforceLeads obj = new SalesforceLeads();
//		obj.launchBrowser("chrome");
//		obj.launchApp();
//		
////		obj.TC20LeadsTab();;
////		obj.logOutApp();
////		obj.TC21LeadsSelectView();
////		obj.logOutApp();
////		obj.TC22defaultView();
////		obj.logOutApp();
////    	obj.LeadsTC23();
////		obj.logOutApp();
//		obj.LeadsTC24();
//
//	}

}
