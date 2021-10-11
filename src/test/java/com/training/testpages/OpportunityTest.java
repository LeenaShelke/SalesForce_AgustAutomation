package com.training.testpages;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.Utilities.CommonUtilities;
import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;

public class OpportunityTest extends BaseTest{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	OpportunityPage opp;
	CommonUtilities common = new CommonUtilities();
	
	@BeforeMethod
	public void beforeTest() throws IOException
	{
		driver= getdriver();
		
		String url= common.getApplicationProperty("url");
		driver.get(url);
		BrowserSetup();
		login = new LoginPage(driver);
		opp = new OpportunityPage(driver);
		//home = new HomePage(driver);
	}
//	@Test(description="TC15-Opportunitiesdropdown")
		public void oppDropdown() throws IOException, InterruptedException
		{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		List<String> actuallist =opp.dropdownlist();
		System.out.println(actuallist);//store values from usermenu dropdown list
		String[] expectedstr = {"All Opportunities","Closing Next Month","Closing This Month","My Opportunities","New Last Week","New This Week","Opportunity Pipeline","Private","Recently Viewed Opportunities","Won"};
		List<String> expectedlist= Arrays.asList(expectedstr);
		System.out.println(expectedlist);
		Assert.assertTrue(actuallist.equals(expectedlist));
		System.out.println("TC_15_opportunitiesdropdown is completed");
		}
//	@Test(description="TC16-Opportunitiesdropdown")
	public void createNewopp() throws IOException, InterruptedException
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		opp.createNewOpp();
		System.out.println("TC16_CreatenewOpp is completed");
	}
//	@Test(description="TC17-Test Opportunity Pipeline Report")
	public void testOpppipelineReport() throws IOException, InterruptedException
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		
		String actualTitle=opp.testPipelineReport();
		System.out.println(actualTitle);
		String expectedTitle = "Opportunity Pipeline";
		Assert.assertEquals(actualTitle,expectedTitle);
		System.out.println("TC17_TestOpportunityPipeline is completed");
	}
//	@Test(description="TC18-Test Stuck Opportunities Report")
	public void teststuckpipelineReport() throws IOException, InterruptedException
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		String actualoppHeader=opp.testStuckPipelineReport();
		String expectedoppHeader ="Stuck Opportunities";
		Assert.assertEquals(actualoppHeader,expectedoppHeader);
		System.out.println("TC_18_TestStuckOpportunitiesReport is completed");
}
	@Test(description="TC19-Test Quarterly Summary Report")
	public void testQuatSummReport() throws IOException, InterruptedException
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		opp.testQuatSummReport();
		System.out.println("TC_19_TestQuarterlySummaryReport is completed");
}
	@AfterMethod
	public void teardown() throws IOException {
		takescreenshot(driver);
		driver.quit();
	
	}
	
}
