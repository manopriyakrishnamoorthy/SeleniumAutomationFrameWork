package com.SeleniumAutomationFrameWork;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.salesforceBase.SalesforceBaseTest;

public class createAccount extends SalesforceBaseTest {
	@Test
	public void  AddAccounttoTab() throws InterruptedException {
		WebElement add = driver.findElement(By.xpath("//img[@class='allTabsArrow']"));
		add.click();
		System.out.println("clicked add button to add account");
		WebElement myTab = driver.findElement(By.xpath("//input[@class='btnImportant']"));
		myTab.click();
		System.out.println("customized my tab");
		WebElement account = driver.findElement(By.xpath("//option[text()='Accounts']"));
		account.click();
		WebElement addAccount = driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
		addAccount.click();
		System.out.println("account added to the tab");
		WebElement save = driver.findElement(By.xpath("//input[@class='btn primary']"));
		save.click();
		System.out.println("test pass.AllTab page displayed");
		logOutApp();
		Thread.sleep(3000);
		logInApp();
		String Expected = "Accounts";
		WebElement acc = driver.findElement(By.xpath("//a[text()='Accounts']"));
		String Actual =acc.getText();
		if(Actual.trim().equalsIgnoreCase(Expected)) {
			System.out.println("Test pass. Account added to tab");
		}
		else {
			System.out.println("test fail.account not added to tab");
		}
  }
	@Test
	public void  CreateAnAccount() throws InterruptedException {
		logInApp();
		Thread.sleep(2000);
		WebElement accountdata = driver.findElement(By.xpath("//a[text()='Accounts']"));
		accountdata.click();
		WebElement newAccount = driver.findElement(By.xpath("//input[@name='new']"));
		newAccount.click();
		System.out.println("Entering accountdetails");
		Thread.sleep(2000);
		WebElement accountname = driver.findElement(By.xpath("//input[@id='acc2']"));
		accountname.sendKeys("priya moorthy");
		System.out.println("Account name entered");
		WebElement typedropdown = driver.findElement(By.xpath("//select[@id='acc6']"));
		Select selecttype = new Select(typedropdown);
		selecttype.selectByVisibleText("Technology Partner");
		WebElement prioritydropdown = driver.findElement(By.id("00Nam000000N1oF"));
		Select selectpriority = new Select(prioritydropdown);
		selectpriority.selectByVisibleText("High");
		System.out.println("account type and priority entered");
		WebElement saveAccount = driver.findElement(By.xpath("//input[@name='save']"));
		saveAccount.click();
		System.out.println("Account Details entered to the account");
		String Expected = "Account Detail";
		WebElement accDetail = driver.findElement(By.xpath("//h2[text()='Account Detail']"));
		String Actual = accDetail.getText();
		if(Actual.trim().equalsIgnoreCase(Expected)) {
			System.out.println("Test pass. Account details page opened");
		}
		else {
			System.out.println("Test fail. not oped to the account page");
		}
	}
	@Test
	public void CreateNewView() throws InterruptedException {
		logInApp();
		Thread.sleep(2000);
		WebElement accountdata = driver.findElement(By.xpath("//a[text()='Accounts']"));
		accountdata.click();
		Thread.sleep(2000);
		WebElement createVeiw = driver.findElement(By.xpath("//a[text()='Create New View']"));
		createVeiw.click();
		System.out.println("clicked create new view");
		WebElement newView = driver.findElement(By.xpath("//h2[text()=' Create New View']"));
		String Expected = "Create New View";
		String actual =newView.getText(); 
		if(actual.trim().equalsIgnoreCase(Expected)) {
			System.out.println("Test pass.Entered to Create New View page");
			}
		else {
			System.out.println("Test fail. not entered to New viewPage");
		}
	}
	@Test
	public void  EditView() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement account= driver.findElement(By.xpath("//a[text()='Accounts']"));
		account.click();
		Thread.sleep(2000);
		System.out.println("clicked accounts");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='fcf']"));
		dropdown.click();
		WebElement edit = driver.findElement(By.xpath("//a[text()='Edit']"));
		edit.click();
		System.out.println("clicked edit");
		WebElement viewname = driver.findElement(By.xpath("//input[@id='fname']"));
		viewname.sendKeys("new view name");
		WebElement filterdropdown = driver.findElement(By.xpath("//select[@id='fcol2']"));
		Select selectdropdown = new Select(filterdropdown);
		selectdropdown.selectByVisibleText("Account Name");
		WebElement operator = driver.findElement(By.xpath("//select[@id='fop2']"));
		Select operatorSelect = new Select(operator);
		operatorSelect.selectByVisibleText("contains");
		Thread.sleep(3000);
		WebElement value = driver.findElement(By.xpath("//input[@id='fval2']"));
		value.sendKeys("a");
		Thread.sleep(3000);
		WebElement save = driver.findElement(By.xpath("//input[@title='Save']"));
		save.click();
		System.out.println("Edit page saved");
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@name='fcf']/option[4]"));
	    String Expect = "new view name";
		String actual = dropdown1.getText();
		if(actual.trim().equalsIgnoreCase(Expect)) {
			System.out.println("Test pass. New view name in the drop down is displayed");
		}
		else {
			System.out.println("Test fail.New view name not shown");
		}
		
	}
	@Test
	public void  MergeAccounts() throws InterruptedException {
		logInApp();
		WebElement account= driver.findElement(By.xpath("//a[text()='Accounts']"));
		account.click();
		Thread.sleep(2000);
		WebElement merge = driver.findElement(By.xpath("//a[text()='Merge Accounts']"));
		merge.click();
		System.out.println("clicked merge");
		WebElement AccountName = driver.findElement(By.xpath("//input[@id='srch']"));
		AccountName.sendKeys("priya moorthy");
		WebElement find = driver.findElement(By.xpath("//input[@value='Find Accounts']"));
		find.click();
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='cid2']"));
		checkbox.click();
		WebElement next = driver.findElement(By.xpath("//input[@name='goNext']"));
		next.click();
		Thread.sleep(3000);
		WebElement mergeAcc = driver.findElement(By.xpath("//input[@title='Merge']"));
		mergeAcc.click();
		driver.switchTo().alert().accept();
		System.out.println("Test pass.Account merged");
	}
	@Test
	public void CreateAccountReport() throws InterruptedException {
		logInApp();
		Thread.sleep(2000);
		WebElement account= driver.findElement(By.xpath("//a[text()='Accounts']"));
		account.click();
		Thread.sleep(2000);
		WebElement AccReport = driver.findElement(By.xpath("//a[text()='Accounts with last activity > 30 days']"));
		AccReport.click();
		System.out.println("clicked account report");
		Thread.sleep(3000);
		WebElement fromDate = driver.findElement(By.xpath("//img[@id='ext-gen152']"));
		fromDate.click();
		Thread.sleep(2000);
		WebElement today = driver.findElement(By.xpath("//table[@id='ext-comp-1111']/tbody/tr[2]/td[2]/em/button"));
		today.click();
		System.out.println("clicked todays date in From field");
		WebElement toDate = driver.findElement(By.xpath("//img[@id='ext-gen154']"));
		toDate.click();
		WebElement toDatetoday = driver.findElement(By.xpath("//table[@id='ext-comp-1113']/tbody/tr[2]/td[2]/em/button"));
		toDatetoday.click();
		System.out.println("clicked todays date in To field");
		WebElement save = driver.findElement(By.xpath("//button[text()='Save']"));
		save.click();
		WebElement reportname = driver.findElement(By.xpath("//input[@name='reportName']"));
		reportname.sendKeys("java");
		Random random = new Random();
		String name = "xyz" + random.nextInt(123)+100;
		WebElement uniqname = driver.findElement(By.xpath("//input[@name='reportDevName']"));
		uniqname.sendKeys(name);
		Thread.sleep(3000);
		WebElement savename = driver.findElement(By.xpath("//table[@id='dlgSaveReport']/tbody/tr[2]/td[2]/em/button"));
		savename.click();
		System.out.println("Report saved");
		Thread.sleep(3000);
		WebElement reportnamedisplay = driver.findElement(By.xpath("//h2[text()='java']"));
		String Expect = "java";
		String actual = reportnamedisplay.getText();
		if(actual.trim().equalsIgnoreCase(Expect)) {
			System.out.println("test pass.report name displayed");
		}
		else {
			System.out.println("test fail.report name not shown");
		}
				driver.close();
	}
	
	
//	public static void main(String[] args) throws InterruptedException {
//		// TODO Auto-generated method stub
//		createAccount obj = new createAccount();
//		obj.launchBrowser("chrome");
//		obj.launchApp();
//		obj.logInApp();
//		obj.AddAccounttoTab();
//		obj.logOutApp();
//		obj.CreateAnAccount();
//		obj.logOutApp();
//		obj.CreateNewView();
//		obj.logOutApp();
//		obj.EditView();
//		obj.logOutApp();
//		obj.MergeAccounts();
//		obj.logOutApp();
//		obj.CreateAccountReport();
//	 
//	}

}
