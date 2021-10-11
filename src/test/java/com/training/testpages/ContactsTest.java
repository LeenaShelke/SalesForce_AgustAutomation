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
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;

public class ContactsTest extends BaseTest{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	ContactsPage Contact;
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
		Contact= new ContactsPage(driver);
		//home = new HomePage(driver);
	}
	//@Test(description="TC25-Create new Contact")
		public void createNewContact() throws Exception
		{
			String username = common.getApplicationProperty("username");
			String password = common.getApplicationProperty("password");
			login.enterintoUsername(username);
			login.enterIntoPassword(password);
			login.clickLoginButton();
			String actualcontactHeader =Contact.createNewcontact();	
			String expectedcontactHeader ="Radhika Agarwal";
			Assert.assertEquals(actualcontactHeader, expectedcontactHeader);
			System.out.println(" TC_25_Createnewcontact is completed");
		}
	//@Test(description="TC26-Create new view in the Contact Page")
	public void createNewView() throws Exception
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		Contact.createNewView();
		System.out.println("TC_26_CreatenewviewintheContactPage is Completed"); 
	}
//	@Test(description="TC27 -Check recently created contact in the Contact Page")
	public void checkCreatedcontact() throws Exception
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		Contact.chkCreatedContact();
		System.out.println("TC_27_Checkrecentlycreatedcontact is Completed");
	}
	//@Test(description="TC28 -Check 'My contacts' view in the Contact Page")
	public void checkMycontacts() throws Exception
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		Contact.chkMycontacts();
		System.out.println("TC28_MyContacts is Completed");
	}
//	@Test(description="TC29 -View a contact in the contact Page")
	public void viewContact() throws Exception
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		Contact.viewContact();
		System.out.println("TC_29_ViewcontactinthecontactPage is completed");
		
	}
//	@Test(description="TC30 -Check the Error message if, the required information is not entered while creating a New view in Contacts")
	public void chkErrorMsg() throws Exception
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		String actualErrMsg=Contact.chkErrorMsg();
		String expectedErrMsg ="Error: You must enter a value";
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
		System.out.println("TC_30_ChecktheContactErrormessage is Completed");
	}
	@Test(description="TC31 -Check the Cancel button works fine in Create New View")
	public void chkCancelbutton() throws Exception
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		Contact.chkCancelbutton();
		System.out.println("TC_31_CheckingCancelbutton is Completed");
	}
	@Test(description="TC32 -Check the Save and New button works in New Contact page")
	public void chkSaveNewbutton() throws Exception
	{
		String username = common.getApplicationProperty("username");
		String password = common.getApplicationProperty("password");
		String Lastname = common.getApplicationProperty("lname");
		String accname = common.getApplicationProperty("accname");
		login.enterintoUsername(username);
		login.enterIntoPassword(password);
		login.clickLoginButton();
		Contact.chkSaveNewbutton(Lastname,accname);
		System.out.println("TC_32_CheckingSaveandNewbutton is Completed");
	}
	
		@AfterMethod
		public void teardown() throws IOException {
			takescreenshot(driver);
			driver.quit();
		
		}
}
