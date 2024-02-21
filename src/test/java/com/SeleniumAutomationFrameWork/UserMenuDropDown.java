package com.SeleniumAutomationFrameWork;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.salesforceBase.SalesforceBaseTest;

public class UserMenuDropDown extends SalesforceBaseTest {
	
	@Test
	public void SelectUserMenuForUsernamedropDown() throws InterruptedException {
		Thread.sleep(2000);
		WebElement usermenu = driver.findElement(By.id("userNav-arrow"));
		Actions action = new Actions(driver);
		action.moveToElement(usermenu);
		System.out.println("checked user menu");
		WebElement dropdown = driver.findElement(By.id("userNav-arrow"));
		dropdown.click();
		System.out.println("drop down menu checked");

	}
	@Test
	public void SelectMyProfileOption() throws InterruptedException, AWTException {
		logInApp();
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.id("userNav-arrow"));
		dropdown.click();
		WebElement myProfile = driver.findElement(By.xpath("//a[text()='My Profile']"));
		myProfile.click();
		System.out.println("Opend to My profile page");
		Thread.sleep(2000);
		WebElement edit = driver.findElement(By.xpath("//img[@title='Edit Profile']"));
		edit.click();
		Thread.sleep(3000);
		driver.switchTo().frame("contactInfoContentId");
		WebElement about = driver.findElement(By.xpath("//li[@id='aboutTab']/a"));
		about.click();
		Thread.sleep(2000);
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastName']"));
		lastname.clear();
		lastname.sendKeys("krishna");
		WebElement saveAll = driver.findElement(By.xpath("//input[@value='Save All']"));
		saveAll.click();
		driver.switchTo().defaultContent();
		String expect = "User: priya krishna ~ Salesforce - Developer Edition";
		String actual = driver.getTitle();
		if (actual.trim().equalsIgnoreCase(expect)) {
			System.out.println("User profile with changed name is displayed");
		} else {
			System.out.println("changed name not displayed");
		}
		Thread.sleep(2000);
		WebElement post = driver.findElement(By.xpath("//span[text()='Post']"));
		post.click();
		Thread.sleep(2000);
		WebElement frame = driver.findElement(By.xpath("//div[@id='cke_43_contents']/iframe"));
		WebElement enterpost = null;
		try {
			
			driver.switchTo().frame(frame);
			enterpost = driver.findElement(By.xpath("//body[text()='Share an update, @mention someone...']"));
			System.out.println("post " +enterpost);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		enterpost.sendKeys("hello");
		driver.switchTo().defaultContent();
		WebElement share = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		share.click();
		System.out.println("text posted and shared");
		Thread.sleep(2000);
		WebElement file = driver.findElement(By.xpath("//span[text()='File']"));
		file.click();
		System.out.println("file clicked");
		WebElement uploadFile = driver.findElement(By.xpath("//a[text()='Upload a file from your computer']"));
		uploadFile.click();
		System.out.println("clicked uploaded file");
		Thread.sleep(2000);
		WebElement chooseFile = driver.findElement(By.xpath("//input[@id='chatterFile']"));
		chooseFile.sendKeys("C:\\Users\\manop\\OneDrive\\Desktop\\R.jpg");
		System.out.println("choose file clicked");
		WebElement shareImg = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		shareImg.click();
		System.out.println("Image posted");
		WebElement moderator = driver.findElement(By.xpath("//span[text()='Moderator']"));
		Actions action = new Actions(driver);
		action.moveToElement(moderator).build().perform();
		System.out.println("mouse moved");
		//???? Due to account issue can not upload image to my profile 
//		WebElement addPhoto = driver.findElement(By.xpath("//a[text()='Add Photo']"));
//		action.moveToElement(addPhoto).build().perform();
//		action.click(addPhoto).build().perform();
//		System.out.println("clicked Addphoto link");
//		Thread.sleep(2000);
//		driver.switchTo().frame("uploadPhotoContentId");
//		WebElement choosefileAddPhoto = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
//		choosefileAddPhoto.sendKeys("C:\\Users\\manop\\OneDrive\\Desktop\\image.jpg");
//		Thread.sleep(2000);
//		System.out.println("upload img choosed");
//		WebElement saveImg = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']"));
//		saveImg.click();
//		System.out.println("imgage saved");
	}
	
	@Test
	public void SelectDevelopersConsoleOption() throws InterruptedException {
		logInApp();
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.id("userNav-arrow"));
		dropdown.click();
		WebElement DevlopersConsole = driver.findElement(By.xpath("//a[text()='Developer Console']"));
		DevlopersConsole.click();
		System.out.println("new window opened");
		Thread.sleep(5000);
		//driver.switchTo().window("windowHandler");
		System.out.println("current windowHandle : " + driver.getWindowHandle());
		String parentwindow = driver.getWindowHandle();
		System.out.println("all window : " + driver.getWindowHandles());
		Set<String> allHandles = driver.getWindowHandles();
		for(String handle : allHandles) {
			if(!handle.equalsIgnoreCase(parentwindow)) {
				driver.switchTo().window(handle);
				driver.close();
				System.out.println("closed the new window");
			}
		}
	}
	
	@Test
	public void SelectLogoutOption() throws InterruptedException {
		logInApp();
		Thread.sleep(0);
		logOutApp();
	}
	
//	public static void main(String[] args) throws InterruptedException, AWTException {
//		// TODO Auto-generated method stub
//		UserMenuDropDown obj = new UserMenuDropDown();
//		obj.launchBrowser("chrome");
//		obj.launchApp();
//		obj.logInApp();
//		obj.SelectUserMenuForUsernamedropDown();
//		obj.logOutApp();
//		obj.SelectMyProfileOption();
//	    obj.logOutApp();
//		obj.SelectDevelopersConsoleOption();
//		obj.logOutApp();
//		obj.SelectLogoutOption();
//		}

}
