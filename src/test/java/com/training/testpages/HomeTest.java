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


	public class HomeTest extends BaseTest {
		WebDriver driver;
		LoginPage login;
		HomePage home;
		CommonUtilities common = new CommonUtilities();
		
		@BeforeMethod
		public void beforeTest() throws IOException
		{
			driver= getdriver();
			String url= common.getApplicationProperty("url");
			
			driver.get(url);
			BrowserSetup();
			login = new LoginPage(driver);
			home = new HomePage(driver);
		}
		
	//	@Test(priority =1,description ="Select user menu for drop down")
		public void selectUserMenu() throws IOException, InterruptedException
		{
			String username = common.getApplicationProperty("username");
			String password = common.getApplicationProperty("password");
			login.enterintoUsername(username);
			login.enterIntoPassword(password);
			login.clickLoginButton();
			home.ClickOnMenudropdown();
			List<String> actuallist =home.UserMenudropdown();//store values from usermenu dropdown list
			String[] expectedstr = {"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};
			List<String> expectedlist= Arrays.asList(expectedstr);
			System.out.println(expectedlist);
			Assert.assertTrue(actuallist.equals(expectedlist));
		
			
		}
//		@Test(description="TC06")
		public void viewMyProfile() throws IOException, InterruptedException{
			String username = common.getApplicationProperty("username");
			String password = common.getApplicationProperty("password");
			login.enterintoUsername(username);
			login.enterIntoPassword(password);
			login.clickLoginButton();
			home.ClickOnMenudropdown();
			home.myprofile();
			System.out.println("Test Pass :Lastname is updated in AboutTab");
		}
		@Test(description="TC07")
		public void viewMySettings() throws IOException, InterruptedException{
			String username = common.getApplicationProperty("username");
			String password = common.getApplicationProperty("password");
			login.enterintoUsername(username);
			login.enterIntoPassword(password);
			login.clickLoginButton();
			home.ClickOnMenudropdown();
			home.mySettings();
			home.loginHistory();
			home.EmailTab();
			home.CalenderRemaindersTab();
			driver.close();
			System.out.println("Tc_7_SelectMySettings is completed");
			
			
		}
//		@Test(priority =2,description="TC08")
			public void clickDeveloperConsole() throws InterruptedException, IOException
			{
				String username = common.getApplicationProperty("username");
				String password = common.getApplicationProperty("password");
				login.enterintoUsername(username);
				login.enterIntoPassword(password);
				login.clickLoginButton();
				home.UserMenudropdown();
				home.clickDeveloperConsole();
				System.out.println("Test Pass: Developer console window closed");
				driver.close();
			}
	//	@Test(priority =2,description="TC09")
		public void logout() throws IOException, InterruptedException{
			String username = common.getApplicationProperty("username");
			String password = common.getApplicationProperty("password");
			login.enterintoUsername(username);
			login.enterIntoPassword(password);
			login.clickLoginButton();
			home.ClickOnMenudropdown();
			home.Logout();
			System.out.println("User Logged out successfully");
			driver.close();
		}
	
		@AfterMethod
		public void teardown() throws IOException {
			takescreenshot(driver);
			driver.quit();
		
		}
	}


