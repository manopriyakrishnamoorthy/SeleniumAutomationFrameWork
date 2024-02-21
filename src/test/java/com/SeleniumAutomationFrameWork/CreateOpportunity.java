package com.SeleniumAutomationFrameWork;


import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.salesforceBase.SalesforceBaseTest;

public class CreateOpportunity extends SalesforceBaseTest{
	
	@Test
	public void opportunityclick() throws InterruptedException {
		Thread.sleep(2000);
		WebElement opportunity = driver.findElement(By.xpath("//a[text()='Opportunities']"));
		opportunity.click();
		Thread.sleep(3000);
		String Expecttitle = "Opportunities: Home ~ Salesforce - Developer Edition";
		String actualtitle =driver.getTitle();
		System.out.println(actualtitle);
		if(actualtitle.trim().equalsIgnoreCase(Expecttitle)) {
			System.out.println("test pass. entered to opportunity homepage");
		}
		else {
			System.out.println("test fail.not entered to opportunity homepage");
		}
		driver.close();
	}
	@Test
	public void opportunitiesDropDown() throws InterruptedException {
		
		opportunityclick();
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));
		dropdown.click();
		List<WebElement> actualoptions = driver.findElements(By.xpath("//select[@id='fcf']/option"));
		String[] Expected = {"Closing Next Month","Closing This Month","My Opportunities","New Last Week","New This Week","Opportunity Pipeline","Private","Recently Viewed Opportunities","Won","view"};
		for(String element : Expected) {
			boolean notfound = false;
			for(WebElement actualOption : actualoptions) {
				if(actualOption.getText().trim().equalsIgnoreCase(element)) {
					System.out.println("Opportunities dropDownOption: " + element );
					notfound = true;
					break;
				}
			}
			if(!notfound) {
				System.out.println("Opportunities dropDownOption notfound :" + element);
			}
		}	
		driver.close();
	}
	@Test
	public void CreateANewOpty() throws InterruptedException {
		logInApp();
		opportunitiesDropDown();
		WebElement createNew = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		createNew.click();
		WebElement name = driver.findElement(By.xpath("//*[@id=\"opp3\"]"));
		name.sendKeys("xyz");
		WebElement accountname = driver.findElement(By.id("opp4"));
		accountname.sendKeys("priya moorthy");
		WebElement date = driver.findElement(By.xpath("//*[@id=\"opp9\"]"));
		date.sendKeys("2/5/2024");
		WebElement stage = driver.findElement(By.xpath("//*[@id=\"opp11\"]"));
		Select selectStage = new Select(stage);
		selectStage.selectByIndex(2);
		WebElement prob = driver.findElement(By.xpath("//*[@id=\"opp12\"]"));
		prob.clear();
		prob.sendKeys("20");	
		WebElement primarysource = driver.findElement(By.xpath("//*[@id=\"opp17\"]"));		
		primarysource.sendKeys("");
		WebElement leadsource = driver.findElement(By.xpath("//*[@id=\"opp6\"]"));
		Select selectsouce = new Select(leadsource);
		selectsouce.selectByIndex(1);
		WebElement save = driver.findElement(By.cssSelector("input.btn"));
		save.click();
		driver.close();
		
	}
	@Test
	public void TestOpportunityPipelineReport() throws InterruptedException {
		System.out.println("Beginning Test Opportunity - PipelineReport");
		logInApp();
		opportunityclick();
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));
		dropdown.click();
		Select selectpipeline = new Select(dropdown);
		selectpipeline.selectByIndex(6);
		WebElement go = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		go.click();
		WebElement oppname = driver.findElement(By.cssSelector("select.title"));
		Select selectedOption = new Select(oppname);
		WebElement select = selectedOption.getFirstSelectedOption();
		String selec = select.getText();
		System.out.println("Selected Option: " + selec);
		
		if(selec.trim().equalsIgnoreCase("Opportunity Pipeline")) {
			System.out.println("test pass. entered into opportunity page");
		}
		else {
			System.out.println("test fail.not entered to opportunity page");
		}
		driver.close();
	}
	@Test
	public void TestStuckOpportunitiesReport() throws InterruptedException {
		System.out.println("TestStuckOpportunitiesReport");
		logInApp();
		opportunityclick();
		Thread.sleep(3000);
		WebElement stuck = driver.findElement(By.xpath("//a[text()='Stuck Opportunities']"));
		stuck.click();
		WebElement stuckOppo = driver.findElement(By.xpath("//h1[text()='Stuck Opportunities']"));
		if(stuckOppo.getText().trim().equalsIgnoreCase("Stuck Opportunities")) {
			System.out.println("test pass. entered to stuck page");
		}
		else {
			System.out.println("test fail. not entered to stuck page");
		}
		driver.close();
	}
	@Test
	public void TestQuarterlySummaryReport() throws InterruptedException {
		System.out.println("TestQuarterlySummaryReport");
		logInApp();
		opportunityclick();
		WebElement intervaldropdown = driver.findElement(By.xpath("//*[@id=\"quarter_q\"]"));
		intervaldropdown.click();
		Select selected = new Select(intervaldropdown);
		selected.selectByIndex(1);
		WebElement includedropdown = driver.findElement(By.xpath("//*[@id=\"open\"]"));
		Select selected1 = new Select(includedropdown);
		selected1.selectByIndex(2);
		WebElement runReport = driver.findElement(By.xpath("//input[@value='Run Report']"));
		runReport.click();
		WebElement SummaryReport = driver.findElement(By.xpath("//h1[text()='Opportunity Report']"));
		if(SummaryReport.getText().trim().equalsIgnoreCase("Opportunity Report")) {
			System.out.println("Test pass. entered to summary report page");
		}
		else {
			System.out.println("Teast fail. not entered to summary report page ");
		}
		driver.close();
			
	}
	
//	public static void main(String[] args) throws InterruptedException {
//		// TODO Auto-generated method stub
//		CreateOpportunity obj = new CreateOpportunity();
//		obj.launchBrowser("chrome");
//		obj.launchApp();
//		obj.logInApp();
//		obj.opportunitiesDropDown();
//		obj.logOutApp();
//		obj.CreateANewOpty();
//		obj.logOutApp();
//		obj.TestOpportunityPipelineReport();
//		obj.logOutApp();
//		obj.TestStuckOpportunitiesReport();
//		obj.logOutApp();
//		obj.TestQuarterlySummaryReport();
//	}

}
