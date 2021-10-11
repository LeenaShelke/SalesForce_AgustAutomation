package com.training.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class ContactsPage extends BasePage {
	public ContactsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[@id='tryLexDialogX']")
	WebElement lighteningwindow;
	@FindBy(xpath="//a[normalize-space()='Contacts']")
	WebElement contactTab;
	@FindBy(xpath="//input[contains(@title,'New')]")
	WebElement new_Element;
	@FindBy(xpath="//input[@id='name_firstcon2']")
	WebElement first_name;
	@FindBy(xpath="//input[@id='name_lastcon2']")
	WebElement last_name;
	@FindBy(xpath="//input[@id='con4']")
	WebElement account_name;
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement save;
	@FindBy(xpath="//h2[normalize-space()='New Contact']")
	WebElement ContactHeader;
	public String createNewcontact() throws Exception {
		// TODO Auto-generated method stub
		waitforElement(contactTab);
		clickObj(contactTab, "ContactsTab");
		handleLightenningwindow(lighteningwindow);
		clickObj(new_Element, "new_Element");
		enterText(first_name, "Radhika", "FirstName");
		enterText(last_name, "Agarwal", "LastName");
		waitforElement(account_name);
		enterText(account_name, "Vibha", "Accountname");
		clickObj(save, "SaveButton");
		waitforElement(ContactHeader);
		String contactheader = ContactHeader.getText();
		return contactheader;
	}
	@FindBy(xpath="//a[contains(text(),'Create New View')]")
	WebElement Contactnewview;
	@FindBy(xpath="//input[@id='fname']")
	WebElement ViewNames;
	@FindBy(xpath="//input[@id='devname']")
	WebElement View_UniqueName;
	@FindBy(xpath="//div[@class='pbBottomButtons']//input[@title='Save']")
	WebElement save1;
	// Create new view on contact page
	public void createNewView() throws Exception {
		// TODO Auto-generated method stub
		waitforElement(contactTab);
		clickObj(contactTab, "ContactsTab");
		handleLightenningwindow(lighteningwindow);
		waitforElement(Contactnewview);
		clickObj(Contactnewview, "Contactnewview");
		waitforElement(ViewNames);
		enterText(ViewNames, "sales" , "ViewName");
		waitforElement(View_UniqueName);
		View_UniqueName.clear();
		enterText(View_UniqueName, "SALE" , "ViewUniqueName");
		waitforElement(save1);
		clickObj(save1, "SaveButton");
		
	}
	@FindBy(xpath="(//select[@id='fcf'])[1]")
	WebElement Rec_Created;
	// Check recently created contacts
	public void chkCreatedContact() throws InterruptedException {
		// TODO Auto-generated method stub
		waitforElement(contactTab);
		clickObj(contactTab, "ContactsTab");
		handleLightenningwindow(lighteningwindow);
		waitforClickableElement(Rec_Created);
		selectByVisibleText(Rec_Created, "Recently Viewed Contacts");
		
	}
	//Check for My contacts
	public void chkMycontacts() throws InterruptedException {
		// TODO Auto-generated method stub
		waitforElement(contactTab);
		clickObj(contactTab, "ContactsTab");
		handleLightenningwindow(lighteningwindow);
		waitforClickableElement(Rec_Created);
		selectByVisibleText(Rec_Created, "My Contacts");
		Thread.sleep(5000);
	}
	//View a Contact in the contact page
	
	@FindBy(xpath="(//a[contains(text(),'Agarwal, Radhika')])[1]")
	WebElement Contactname;
	public void viewContact() throws InterruptedException {
		// TODO Auto-generated method stub
		waitforElement(contactTab);
		clickObj(contactTab, "ContactsTab");
		handleLightenningwindow(lighteningwindow);
		clickObj(Contactname, "Contactname");
	}
	// Check the Error message if, the required information is not entered while creating a New view in Contacts
	@FindBy(xpath="(//div[@class='errorMsg'])[1]")
	WebElement chkErrmsg;
	
	public String chkErrorMsg() throws Exception {
		waitforElement(contactTab);
		clickObj(contactTab, "ContactsTab");
		handleLightenningwindow(lighteningwindow);
		waitforElement(Contactnewview);
		clickObj(Contactnewview, "Contactnewview");
		waitforElement(ViewNames);
		//enterText(ViewNames, "sales" , "ViewName");
		waitforElement(View_UniqueName);
		View_UniqueName.clear();
		enterText(View_UniqueName, "EFGH" , "ViewUniqueName");
		waitforElement(save1);
		clickObj(save1, "SaveButton");
		waitforElement(chkErrmsg);
		String errMsg=chkErrmsg.getText();
		System.out.println(errMsg);
		return errMsg;
	}
	@FindBy(xpath="(//input[@title='Cancel'])[2]")
	WebElement chkCancelbutton;
//	Check the Cancel button works fine in Create New View
	public void chkCancelbutton() throws Exception {
		// TODO Auto-generated method stub
		waitforElement(contactTab);
		clickObj(contactTab, "ContactsTab");
		handleLightenningwindow(lighteningwindow);
		waitforElement(Contactnewview);
		clickObj(Contactnewview, "Contactnewview");
		waitforElement(ViewNames);
		enterText(ViewNames, "ABCD" , "ViewName");
		waitforElement(View_UniqueName);
		View_UniqueName.clear();
		enterText(View_UniqueName, "EFGH" , "ViewUniqueName");
		waitforElement(chkCancelbutton);
		clickObj(chkCancelbutton, "CancelButton");
		
	}
	//Check the Save and New button works in New Contact page
	@FindBy(xpath="(//input[@title='Save & New'])[1]")
	WebElement chkSaveNewbutton;
	public void chkSaveNewbutton(String lname,String accname) throws Exception {
		// TODO Auto-generated method stub
		waitforElement(contactTab);
		clickObj(contactTab, "ContactsTab");
		handleLightenningwindow(lighteningwindow);
		clickObj(new_Element, "new_Element");
		enterText(last_name, lname, "LastName");
		waitforElement(account_name);
		enterText(account_name, accname, "Accountname");
		clickObj(chkSaveNewbutton, "New and Save");
	}
}
