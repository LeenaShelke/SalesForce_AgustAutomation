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
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;

public class LeadsTest extends BaseTest {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	LeadsPage Lead;
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
		Lead= new LeadsPage(driver);
		//home = new HomePage(driver);
	}
//	@Test(description="TC20-viewLeadsPage")
		public void viewLeadsPage() throws IOException, InterruptedException
		{
			String username = common.getApplicationProperty("username");
			String password = common.getApplicationProperty("password");
			login.enterintoUsername(username);
			login.enterIntoPassword(password);
			login.clickLoginButton();
			Lead.viewLeadsPage();
			
			
		}

	//@Test(description="TC21-leadsSelectView")
	public void viewSelectView() throws IOException, InterruptedException
	{
		List<String> actuallist =Lead.viewSelectView();
		System.out.println(actuallist);//store values from usermenu dropdown list
		String[] expectedstr = {"All Open Leads","My Unread Leads","Recently Viewed Leads","Today's Leads","View - Custom 1","View - Custom 2"};
		List<String> expectedlist= Arrays.asList(expectedstr);
		System.out.println(expectedlist);
		Assert.assertTrue(actuallist.equals(expectedlist));
		System.out.println("TC21_LeadsSelectView is completed");	
		
	}
//	@Test(description="TC22-defaultView")
	public void viewdefaultView() throws IOException, InterruptedException
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
	
		Lead.defaultView();
		login.ClickLogout();
		driver.get(url);
		BrowserSetup();
		String username1 = common.getApplicationProperty("username");
		String password1 = common.getApplicationProperty("password");
		login.enterintoUsername(username1);
		login.enterIntoPassword(password1);
		login.clickLoginButton();
		Lead.viewLeadsPage();
		Lead.clickGo();
		System.out.println("TC22_defaultView is completed");	
		
	}
		
	//	@Test(description="TC23-viewTodaylead")
		public void viewtodaylead() throws IOException, InterruptedException
		{
			String username = common.getApplicationProperty("username");
			String password = common.getApplicationProperty("password");
			login.enterintoUsername(username);
			login.enterIntoPassword(password);
			login.clickLoginButton();
			Lead.viewTodaylead();
			System.out.println("TC23_viewTodaylead is completed");	
		}
		@Test(description="TC24-Check New button on Leads Home")
		public void chkNewbutton() throws Exception
		{
			String username = common.getApplicationProperty("username");
			String password = common.getApplicationProperty("password");
			login.enterintoUsername(username);
			login.enterIntoPassword(password);
			login.clickLoginButton();
			Lead.chkNewButton();
			System.out.println(" TC24_NewLeads is completed");
		}
		@AfterMethod
		public void teardown() throws IOException {
			takescreenshot(driver);
			driver.quit();
		
		}
}
