package com.training.testpages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.Utilities.CommonUtilities;
import com.training.base.BaseTest;
import com.training.pages.ContactsPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.RandomScenariosPage;

public class RandomScenariosTest extends BaseTest{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	RandomScenariosPage RandomScenarios;
	String url;
	CommonUtilities common = new CommonUtilities();
	
	@BeforeMethod
	public void beforeTest() throws IOException
	{
		driver= getdriver();
		url= common.getApplicationProperty("url");
		driver.get(url);
		BrowserSetup();
		login = new LoginPage(driver);
		//home = new HomePage(driver);
		RandomScenarios= new RandomScenariosPage(driver);
		
	}
//	@Test(description="TC33-Verify if the firstname and lastname of the loggedin user is displayed")
			public void chkLoggedInuser() throws Exception
			{

		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		String expectedTitle = common.getApplicationProperty("displayname");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		String actualTitle = RandomScenarios.chkLoggedInuser();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("TC33_VerifyName is Completed");
		
			}
	//@Test(description="TC34")
	public void chkeditedLastname() throws Exception
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		String actualLastName=RandomScenarios.chkeditedLAstname();
		System.out.println(actualLastName);
	}	
//	@Test(description="TC35 -Verify the tab customization")
	public void VerifyTab() throws Exception
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		RandomScenarios.verifyTabs();
		login.ClickLogout();
		url= common.getApplicationProperty("url");
		driver.get(url);
		BrowserSetup();
		String username1 = common.getApplicationProperty("username");
		String password1 = common.getApplicationProperty("password");
		login.enterintoUsername(username1);
		login.enterIntoPassword(password1);
		login.clickLoginButton();
		System.out.println("TC35_CustomTab Executed sucessfully");  
		
	}
//	@Test(description="TC36- Blocking an event in the calender")
	public void blockEvent() throws Exception
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		RandomScenarios.blockCalenderEvent();
		System.out.println("TC36_EventinCalender Executed sucessfully"); 
	}
	@Test(description="TC37- Blocking an event in the calender with weekly recurrance")
	public void Blockingcalenderweeklyrecurrance() throws Exception
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		RandomScenarios.Blockingcalenderweeklyrecurrance();
		System.out.println("TC37_BlockingAnEvent_Calendar_WeeklyRecurring is done");
	}
	@AfterMethod
	public void teardown() throws IOException {
		takescreenshot(driver);
		driver.quit();
	
	}
}
