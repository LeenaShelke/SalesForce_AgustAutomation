package com.training.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class RandomScenariosPage extends BasePage{

	public RandomScenariosPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//li[@id='home_Tab']//a[contains(text(),'Home')]")
	 WebElement Home;
	@FindBy(xpath="//a[normalize-space()='Leena sh1']")
	 WebElement NameLink;
	@FindBy(xpath="//a[@id='tryLexDialogX']")
	 WebElement lighteningwindow;
	@FindBy(xpath="(//img[@title='Edit Profile'])[1]")
	 WebElement editProfileicon;
	@FindBy(xpath=("//a[contains(text(),'About')]"))
	WebElement aboutTab;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@value='Save All']")
	WebElement saveAll;
	
	@FindBy(xpath="//span[@id='tailBreadcrumbNode']")
	WebElement displayprofilename;
	
	@FindBy(xpath="//img[@title='All Tabs']")
	WebElement allTabs;
	
	@FindBy(xpath="//input[@title='Customize My Tabs']")
	WebElement  CustomizeTabs;
	@FindBy(xpath="(//select[@id='duel_select_1'])[1]")
	WebElement  contentTab;
	@FindBy(xpath="//img[@title='Remove']")
	WebElement  removeArrow;
	@FindBy(xpath="//input[@title='Save']")
	WebElement  saveBtn;
	@FindBy(xpath="//a[contains(text(),'2021')]")
	WebElement  dateLink;
	@FindBy(xpath="//a[normalize-space()='8:00 PM']")
	WebElement  eightPM;
	@FindBy(xpath="//img[@title='Subject Combo (New Window)']")
	WebElement  subject;
	@FindBy(xpath="//a[@href='javascript:pickValue(4);']")
	WebElement  other;
	@FindBy(xpath="//input[@id='EndDateTime']")
	WebElement Date;
	@FindBy(xpath="//tr[@id='calRow2']//td[contains(@class,'weekday')][contains(text(),'6')]")
	WebElement pickingdate;
	@FindBy(xpath="//input[@id='EndDateTime_time']")
	WebElement endtime;
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement btnSave;
	
	public String chkLoggedInuser() throws InterruptedException {
		
	
		clickObj(Home, "Home");
		handleLightenningwindow(lighteningwindow);
		waitforElement(NameLink);
		String getName=NameLink.getText();
		// TODO Auto-generated method stub
		return getName;
	}
	public String chkeditedLAstname() throws InterruptedException {
		// TODO Auto-generated method stub
		clickObj(Home, "Home");
		waitforElement(lighteningwindow);
		handleLightenningwindow(lighteningwindow);
		waitforElement(NameLink);
		clickObj(NameLink, "User name");
		waitforElement(editProfileicon);
		clickObj(editProfileicon, "User name");
		Thread.sleep(7000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(2);//switch to editProfile window
		waitforClickableElement(aboutTab);
		System.out.println("Clicked on About tab");
		aboutTab.click();
		waitforElement(lastname);
		lastname.clear();
		lastname.sendKeys("sona");
		saveAll.click();
		driver.switchTo().defaultContent();
		String str= displayprofilename.getText();
		return str;
	}
	public void verifyTabs() throws InterruptedException {
		// TODO Auto-generated method stub
		waitforElement(allTabs);
		clickObj(allTabs, "AllTabs");
		//handleLightenningwindow(lighteningwindow);
		waitforElement(CustomizeTabs);
		clickObj(CustomizeTabs, "Customize Tabs");
		waitforElement(contentTab);
		Thread.sleep(4000);
		selectByVisibleText(contentTab, "Content");
		waitforElement(removeArrow);
		clickObj(removeArrow, "Remove Arrow");
		clickObj(saveBtn,"Save");
		
	}
	public void blockCalenderEvent() throws InterruptedException {
		// TODO Auto-generated method stub
		clickObj(Home, "Home");
		waitforElement(lighteningwindow);
		handleLightenningwindow(lighteningwindow);
		waitforElement(dateLink);
		clickObj(dateLink, "Date Link");
		waitforElement(eightPM);
		clickObj(eightPM, "8PM");
		waitforElement(subject);
		clickObj(subject, "Subject");
		Thread.sleep(6000);
		Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		String newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		other.click();
		// driver.switchTo().defaultContent();
		driver.switchTo().window(currentHandle);
		Thread.sleep(2000);
		Date.sendKeys("10/11/2021");;
		driver.findElement(By.xpath("//img[contains(@class,'calRight')]")).click();
		Thread.sleep(5000);
		pickingdate.click();
		waitforElement(endtime);
		clickObj(endtime,"endtime");
		mouseOver(driver, endtime);
		//selectByVisibleText(endtime, "7:00 PM");
		driver.findElement(By.xpath("//input[@id='EndDateTime_time']")).click();
		driver.findElement(By.xpath("//div[@id='timePickerItem_42']")).click();
		waitforElement(btnSave);
		btnSave.click();
		
	}
	public void Blockingcalenderweeklyrecurrance() throws InterruptedException {
		// TODO Auto-generated method stub
		clickObj(Home, "Home");
		waitforElement(lighteningwindow);
		handleLightenningwindow(lighteningwindow);
		waitforElement(dateLink);
		clickObj(dateLink, "Date Link");
		waitforElement(eightPM);
		clickObj(eightPM, "8PM");
		waitforElement(subject);
		clickObj(subject, "Subject");
		Thread.sleep(6000);
		Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		String newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		other.click();
		// driver.switchTo().defaultContent();
		driver.switchTo().window(currentHandle);
		Thread.sleep(4000);
		Date.sendKeys("10/11/2021");;
		driver.findElement(By.xpath("//img[contains(@class,'calRight')]")).click();
	//	waitforElement(pickingdate);
	//	pickingdate.click();
		waitforElement(endtime);
		clickObj(endtime,"endtime");
		mouseOver(driver, endtime);
		WebElement recurr=driver.findElement(By.id("IsRecurrence"));
		clickObj(recurr,"recurrence");
		WebElement rectyp=driver.findElement(By.id("rectypeftw"));
		clickObj(rectyp, "reccurencetype");
		WebElement recendtime=driver.findElement(By.name("RecurrenceEndDateOnly"));
		recendtime.sendKeys("03/03/2019");
		WebElement save=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Save']"));
		clickObj(save,"save");
		
		
		
	}

}
