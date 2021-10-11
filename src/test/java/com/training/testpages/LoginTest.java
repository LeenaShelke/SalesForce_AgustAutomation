package com.training.testpages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.Utilities.CommonUtilities;
import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;

public class LoginTest extends BaseTest {
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
		//home = new HomePage(driver);
	}
	@Parameters({"username","pwd"})
//	@Test(priority =2,description ="Login To SalesForce -2")
	public void validateLoginCredentials(String username,String password) throws InterruptedException {
		
		login.logintapplication(username,password);
		
		String Homepagemsg= login.ClickLogin();
		String Loginmsg = "Home Page ~ Salesforce - Developer Edition";
		
		if (Loginmsg.equalsIgnoreCase(Homepagemsg))
		{
			
			System.out.println("Home page is launched");//Home page is displayed
		}
		else
		{
			System.out.println("Home page is not launched");
		}
		
		//Log.info("Home Page is displayed");
		
		
	}
	
	@Parameters({"username"})
//	@Test(priority=2,description ="Login Error Message - 1" )
	public void validateLogin(String username) throws InterruptedException
	{
		login.logintapplication(username, "");//clear password
		String errmsg = login.clickOnLogin();
		System.out.println(errmsg);
		AssertJUnit.assertEquals(errmsg, "Please enter your password.");//Error message for clear password
	}
	
	@Parameters({"invalidusername","invalidpwd"})
//	@Test(priority=3,description="Forgot Password- 4 B")
	public void validateLoginPwd(String invalidusername,String invalidpwd) throws InterruptedException
	{
		login.logintapplication(invalidusername,invalidpwd);
		String errmsg = login.clickOnLogin();
		System.out.println(errmsg);//Error message for invalid login credentials
		AssertJUnit.assertEquals(errmsg, "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
	}
	
//	@Test(priority=1,description="Forgot Password- 4 A")
	public void validateForgotPwd() throws Exception
	{
		String  forgotPwdLink = login.ForgotPassword();
		System.out.println(forgotPwdLink);
		AssertJUnit.assertEquals(forgotPwdLink, "Forgot Your Password");
		driver.switchTo().defaultContent();
		String Fname = common.getApplicationProperty("fname");
		BaseTest.enterText(login.fullName(), Fname, "Fullname");
		BaseTest.clickObj(login.Continue(), "Continue");
	}
	
	@Parameters({"username","pwd"})
	@Test(priority=5,description="Check RemeberMe - 3")
	public void validateRememberMe(String username,String password) throws InterruptedException
	{
		login.clickOnRememberMe();
		login.logintapplication(username,password);
		login.ClickLogin();
		login.ClickLogout();
		//login.CheckUsernamefield();
	}
	
	@AfterMethod
	public void teardown() throws IOException {
		takescreenshot(driver);
		driver.quit();
	
	}
	



}
