package com.training.testpages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.Utilities.CommonUtilities;
import com.training.base.BaseTest;
import com.training.pages.AccountPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;

public class AccountTest extends BaseTest{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	AccountPage account;
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
		account = new AccountPage(driver);
	}
	//@Test(description="TC10CreateAccount")
	public void createAccount() throws IOException, InterruptedException
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		account.createAccount();
		System.out.println("Tc_10_create account is completed");
	}
	//@Test(description="TC11CreateNewView")
	public void createNewView() throws IOException, InterruptedException
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		account.createView();
		System.out.println("Tc_11_create new view is completed");
	}
//	@Test(description="TC12EditView")
	public void EditView() throws Exception
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		account.editView();
		System.out.println("TC12Accounts_Edit_view is completed");
	}
//	@Test(description="TC13MergeAccount")
	public void mergeAccount() throws Exception
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		account.mergeAccount();
		System.out.println("TC13_MergeAccounts is completed");
	}
	@Test(description="TC14CreateAccountReport")
	public void createAccReport() throws Exception
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		account.createReport();
		System.out.println("TC_14_Createaccountreport is completed");
	}
	@AfterMethod
	public void teardown() throws IOException {
		takescreenshot(driver);
		driver.quit();
		
	}
}
