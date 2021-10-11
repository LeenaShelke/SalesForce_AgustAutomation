package com.training.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class LeadsPage extends BasePage {
	public LeadsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[@title='Leads Tab']")
	WebElement Leadstab;
	@FindBy(xpath="//a[@id='tryLexDialogX']")
	WebElement lighteningwindow;
	@FindBy(xpath="//select[@id='fcf']")
	WebElement Leaddropdown;
	@FindBy(xpath="//select[@id='fcf']")
	List<WebElement> Menuitem;
	//View Leads Tab Page
	public void viewLeadsPage() throws InterruptedException {
		// TODO Auto-generated method stub
		waitforElement(Leadstab);
		clickObj(Leadstab, "Leads");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
	}
	// View dropdown list
	public List<String> viewSelectView() throws InterruptedException {
		// TODO Auto-generated method stub
		waitforElement(Leadstab);
		clickObj(Leadstab, "LeadsTab");
		handleLightenningwindow(lighteningwindow);
		Leaddropdown.click();
		List<String> list = new ArrayList<String>(); //to get the list from usermenu dropdown
		for(WebElement ele: Menuitem)
		{
			//System.out.println(ele.getText());
			list.add(ele.getText());
		}
		return list;
		
	}
	// View default View 
	@FindBy(xpath="//select[@id='fcf']")
	WebElement LeadSelect;
	public void defaultView() throws InterruptedException {
		// TODO Auto-generated method stub
		waitforElement(Leadstab);
		clickObj(Leadstab, "LeadsTab");
		handleLightenningwindow(lighteningwindow);
		waitforElement(LeadSelect);
		clickObj(LeadSelect, "LeadSelect");
		selectByVisibleText(LeadSelect, "My Unread Leads");
	
	}
	@FindBy(xpath="//input[@title='Go!']")
	WebElement Go;
	public void clickGo() {
		// TODO Auto-generated method stub
		waitforClickableElement(Go);
		Go.click();
	}
	
	public void viewTodaylead() throws InterruptedException {
		// TODO Auto-generated method stub
		waitforElement(Leadstab);
		clickObj(Leadstab, "LeadsTab");
		handleLightenningwindow(lighteningwindow);
		waitforElement(LeadSelect);
		clickObj(LeadSelect, "LeadSelect");
		selectByVisibleText(LeadSelect, "Today's Leads");
	}
	@FindBy(xpath="//input[@title='New']")
	WebElement Newbutton;
	@FindBy(xpath="(//input[@id='name_lastlea2'])[1]")
	WebElement lastname;
	@FindBy(xpath="//select[@id='lea13']")
	WebElement LeadStatus;
	@FindBy(xpath="(//input[@id='lea3'])[1]")
	WebElement Companyname;
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement SaveButton;
	// Check For New Button functionality
	public void chkNewButton() throws Exception {
		waitforElement(Leadstab);
		clickObj(Leadstab, "LeadsTab");
		handleLightenningwindow(lighteningwindow);
		waitforElement(Newbutton);
		clickObj(Newbutton, "New");
		waitforElement(lastname);
		enterText(lastname, "soham", "LastName");
		clickObj(LeadStatus, "LeadStatus");
		selectByVisibleText(LeadStatus, "Open - Not Contacted");
		waitforElement(Companyname);
		enterText(Companyname, "wellsfargo", "companyname");
		clickObj(SaveButton, "SaveButton");
	}
	
}
