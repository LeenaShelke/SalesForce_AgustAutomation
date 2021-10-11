package com.training.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.base.BasePage;

public class HomePage extends BasePage {
	static String downloadPath = "C:\\Users\\sagar\\Downloads";
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="name")
	WebElement firstName;
	@FindBy(xpath="//div[@id='userNavButton']")
	WebElement Username;
	@FindBy(xpath="//div[@id='userNav-menuItems']//a")
	List<WebElement> Menuitem;
	
	@FindBy(css="a[title='Logout']")
	WebElement Logout;
	
	@FindBy(css="a[title='Developer Console (New Window)']")
	WebElement DeveloperConsoleWindow;
	
	@FindBy(xpath="//a[normalize-space()='My Profile']")
	WebElement myprofile;
	
	@FindBy(xpath="//img[@title='Edit Profile'][1]")
	WebElement editprofile;
	
	@FindBy(xpath=("//a[contains(text(),'About')]"))
	WebElement aboutTab;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@value='Save All']")
	WebElement saveAll;
	
	@FindBy(xpath="//span[@id='tailBreadcrumbNode']")
	WebElement displayprofilename;
	
	@FindBy(xpath="//a[normalize-space()='My Settings']")
	WebElement mySettings;
	
	@FindBy(xpath="//*[@id='PersonalInfo_font']")
	WebElement Personal;
	
	@FindBy(xpath="//*[@id='LoginHistory_font']")
	WebElement loginHistory;
	
	@FindBy(xpath="//a[contains(text(),'Download login history for last six months, includ')]")
	WebElement LoginHistory6Months;
	
	@FindBy(xpath="//*[@id='DisplayAndLayout_font']")
	WebElement DisplayandLayout;
	
	@FindBy(xpath="//*[@id='CustomizeTabs_font']")
	WebElement CustomizeMyTabs;
	
	@FindBy(xpath="//span[@id='PersonalCollaboration_font']")
	WebElement dropdownChatter;
	
	@FindBy(xpath="//span[@id='EmailSetup_font']")
	WebElement Email;
	
	@FindBy(xpath="//span[@id='EmailSettings_font']")
	WebElement MyEmailSettings;
	
	
	@FindBy(xpath="//input[@id='sender_name']")
	WebElement Email_Name;
	
	@FindBy(xpath="//input[@id='sender_email']")
	WebElement Email_Address;
	
	@FindBy(xpath="//input[@id='auto_bcc1']")
	WebElement Bcc_radioButton;
	
	@FindBy(xpath="//input[@title='Save']")
	WebElement Save_button;
	
	public void enterIntoFirstName(String strFirstName)  {
		waitforElement(firstName);
		firstName.sendKeys(strFirstName);
		
	}
	public List<String> UserMenudropdown() throws InterruptedException
	{
		waitforElement(Username);
		List<String> list = new ArrayList<String>(); //to get the list from usermenu dropdown
		for(WebElement ele: Menuitem)
		{
			System.out.println(ele.getText());
			list.add(ele.getText());
		}
		return list;
	  
	}
	public void Logout()
	{
		waitforElement(Logout);
		//waitforClickableElement(Logout);
		Logout.click();
			}
	public void clickDeveloperConsole() throws InterruptedException
	{
		
	//	waitforClickableElement(DeveloperConsoleWindow);
		waitforElement(DeveloperConsoleWindow);
	//	System.out.println(DeveloperConsoleWindow.getText());
		DeveloperConsoleWindow.click();
		// Developer log window will display
		
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		driver.close();
			
	
	}
	public void ClickOnMenudropdown() throws InterruptedException {
		// TODO Auto-generated method stub
		waitforElement(Username);
		Username.click();
		Thread.sleep(3000);
	}
	public void myprofile() throws InterruptedException {
		// TODO Auto-generated method stub
		waitforElement(myprofile);
		myprofile.click();
		waitforClickableElement(editprofile);
		//waitforElement(editprofile);
		editprofile.click();
		Thread.sleep(7000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(2);//switch to editProfile window
		waitforClickableElement(aboutTab);
		System.out.println("Clicked on About tab");
		aboutTab.click();
		waitforElement(lastname);
		lastname.clear();
		lastname.sendKeys("sh1");
		saveAll.click();
		driver.switchTo().defaultContent();
		String str= displayprofilename.getText();
		System.out.println("Profile Name" +str);
			
	}
	public void mySettings() throws InterruptedException {
		// TODO Auto-generated method stub
	//	WebElement MySettings = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		mySettings.click();
		String expectedUrl = driver.getCurrentUrl();
		String actualUrl = "https://tekarch-6c-dev-ed.my.salesforce.com/ui/setup/Setup?setupid=PersonalSetup";
		if(actualUrl.equalsIgnoreCase(expectedUrl)) {
			System.out.println("User is on MySettings page");
		}
		else {
			System.out.println("MySettings page is not Lunched");
		}}
	public void loginHistory()
	{
		//Personal and Login History
				waitforClickableElement(Personal);
				Personal.click();
				waitforElement(loginHistory);
				loginHistory.click();
				//downloading .csv file
				waitforElement(LoginHistory6Months);
				LoginHistory6Months.click();
				File getLatestFile = getLatestFilefromDir(downloadPath);
				String fileName = getLatestFile.getName();
				if(isFileDownloaded_Extension(downloadPath, ".csv") == true) {
					System.out.println("file is downloded");
				}
				else {
					System.out.println("file is not downloded");
				}
				waitforElement(DisplayandLayout);
				DisplayandLayout.click();
				waitforElement(CustomizeMyTabs); 
				CustomizeMyTabs.click();
				
	}			
				//Email Tab
	public void EmailTab()			
	{
				Email.click();
				MyEmailSettings.click();
				Email_Name.clear();
				Email_Name.sendKeys("Leena");
				Email_Address.clear();
				Email_Address.sendKeys("leena.shelke@gmail.com");
				Bcc_radioButton.click();
				Save_button.click();
	}
	
	@FindBy(xpath="//span[@id='CalendarAndReminders_font']")
	WebElement Calender_and_Reminders;
	@FindBy(xpath="//span[@id='Reminders_font']")
	WebElement ActivityReminders;
	@FindBy(xpath="//input[@id='testbtn']")
	WebElement Test_Reminder;
	public void CalenderRemaindersTab() throws InterruptedException
	{
		//Calender & Remainders
				
				Calender_and_Reminders.click();
				Thread.sleep(5000);
				ActivityReminders.click();
				Thread.sleep(5000);
				Test_Reminder.click();
				Thread.sleep(5000);
				String parentWindow = driver.getWindowHandle();
				for(String handle : driver.getWindowHandles()) { 
					if(handle != parentWindow) {
						driver.switchTo().window(handle);
					String	expectedUrl1 = driver.getCurrentUrl();
					String	actualUrl1 = "https://tekarch-6c-dev-ed.my.salesforce.com/ui/core/activity/ActivityReminderPage?at=1633666289203&test=1";

					if(actualUrl1.equalsIgnoreCase(expectedUrl1)) {
							System.out.println("MySettings page is not Lunched");
					}
						else {
							System.out.println("User is on MySettings page");
						}	
					}
				}
				
	}		
	
	
	//This method is used to get the latest downloaded file from directory
	public static File getLatestFilefromDir(String dirPath) {
		File dir = new File(downloadPath);
		File[] files = dir.listFiles();
		if(files == null || files.length==0) {
			return null;
		}
		File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}

	//This method checks the extension of the file downloaded
	public static boolean isFileDownloaded_Extension(String dirPath, String extension) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] files = dir.listFiles();
		if(files == null || files.length==0) {
			flag = false;
		}
		for(int i=1; i<files.length; i++) {
			if(files[i].getName().contains(extension)) {
				flag = true;
			}
		}
		return flag;
	}

//This method is to verify if the file is downloaded or not
		public boolean isFileDownloaded(String downloadPath, String fileName) {
			boolean flag = false;
			File dir = new File(downloadPath);
			File[] dir_contents = dir.listFiles();
		
				for(int i=0; i<dir_contents.length; i++) {
					if(dir_contents[i].getName().equalsIgnoreCase(fileName)) {
					return flag = true;
				}
			}
			return flag;
		}
			
}
