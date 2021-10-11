package com.training.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class AccountPage extends BasePage {
	
	public AccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[@title='Accounts Tab']")
	WebElement Accounts_Tab;
	@FindBy(xpath="//input[@title='New']")
	WebElement Newbutton;
	@FindBy(css="#acc2")
	WebElement AccountName;
	@FindBy(css="#acc6")
	WebElement selecttype;
	
	@FindBy(xpath="(//select[@id='00N5g00000Q46to'])[1]")
	WebElement  coustomerpriority;
	
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement Savebutton;
//	@FindBy(xpath="//p[contains(text(),'Lightning Experience is the next generation of Salesforce.']")
	@FindBy(xpath="//a[@id='tryLexDialogX']")
	
	WebElement lighteningwindow;
	//Opening Accounts page
	public void createAccount() throws InterruptedException
	{
	
	Accounts_Tab.click();
	System.out.println("Clicked on Accounts Ta..");
	handleLightenningwindow(lighteningwindow);
	//Creating New Account
	Newbutton.click();
	System.out.println("Clicked on New tab..");
	
	AccountName.clear();
	AccountName.sendKeys("CitiBank");
	Select select = new Select(selecttype);
	select.selectByVisibleText("Technology Partner");
	Select select1 = new Select(coustomerpriority);
	select1.selectByVisibleText("Low");
	Savebutton.click();
	System.out.println("Clicked on Save button..");
	//System.out.println("Tc_10_create account is completed");}
	
}
	

	@FindBy(xpath="//a[normalize-space()='Create New View']")
	WebElement CreateNewView;
	@FindBy(xpath="//input[@id='fname']")
	WebElement ViewName;
	@FindBy(xpath="//input[@id='devname']")
	WebElement ViewUniqueName;
	@FindBy(xpath="(//input[@title='Save'])[2]")
	WebElement Save;
	WebElement dropdown;
	public void createView() throws InterruptedException {
		// TODO Auto-generated method stub
		Accounts_Tab.click();
		System.out.println("Clicked on Accounts Ta..");
		handleLightenningwindow(lighteningwindow);
		waitforElement(CreateNewView);
		CreateNewView.click();
		System.out.println("Clicked on Create New View..");
		waitforElement(ViewName);
		ViewName.clear();
		ViewName.sendKeys("Xyz123");
		String value = ViewName.getAttribute("value");
		
		System.out.println(value);
		waitforElement(ViewUniqueName);
		ViewUniqueName.clear();
		ViewUniqueName.sendKeys("sample");
		waitforElement(Save);
		Save.click();
		System.out.println("Clicked on save button"); 

		WebElement dropdown = driver.findElement(By.className("title"));
		dropdown.click();
		Select dropdown_options = new Select(dropdown);
		List<WebElement> options = dropdown_options.getOptions();
		
		for(int i=0; i<options.size(); i++) {
			if(options.get(i).getText().equals(value)) {
				System.out.println("Account name is displayed in the dropdown");
			}
		}
		
	}
	//Edit View 
	@FindBy(xpath="//select[@name='fcf']")
	WebElement View;
	@FindBy(xpath="(//a[contains(text(),'Edit')])[1]")
	WebElement EditLink;
	@FindBy(xpath="//select[@id='fcol1']")
	WebElement firstcolumn;
	@FindBy(xpath="//select[@id='fop1']")
	WebElement AddfieldsOperator;
	@FindBy(xpath="//select[@id='colselector_select_1']")
	WebElement Available_Fields_dropdown;
	@FindBy(xpath="(//input[@title='Save'])[2]")
	WebElement save;
	@FindBy(xpath="//input[@id='fname']")
	WebElement s3;
	public void editView() throws Exception {
		// TODO Auto-generated method stub
		Accounts_Tab.click();
		System.out.println("Clicked on Accounts Ta..");
		handleLightenningwindow(lighteningwindow);
		waitforElement(View);
		clickObj(View, "View");
			
	    Select dropdown = new Select(View);
	    dropdown.selectByIndex(1);
			
		WebElement EditLink = driver.findElement(By.linkText("Edit"));
		clickObj(EditLink, "EditLink");
		s3.clear();
		enterText(s3, "viewname", "ViewName");
		System.out.println("Viewname entered in the field");
			
		clickObj(firstcolumn, "firstcolumn");
		Thread.sleep(1000);
		Select accfield = new Select(firstcolumn);
		accfield.selectByIndex(1);
		Thread.sleep(1000);
		Select operator = new Select(AddfieldsOperator);
		operator.selectByIndex(3);
			
		WebElement value = driver.findElement(By.id("fval1"));
		value.clear();
		value.sendKeys("<a>");
		/*These statements verifies if the "Last Activity" is availble in the Available Fields
		 * If Last Activity is available under Available Fields, It add the same to Selected Fields
		 * and save the modifications
		 */
		
		Select Available_Fields_dropdown_list = new Select(Available_Fields_dropdown);
		List<WebElement> Available_Fields_dropdown_options = Available_Fields_dropdown_list.getOptions();

		boolean Element_available = false; //using as a reference to validate if the last activity is in available fields dropdown or not
		
		for(int i=0; i<Available_Fields_dropdown_options.size(); i++) {
			if(Available_Fields_dropdown_options.get(i).getText().equals("Last Activity")) {
				Element_available = true;
				WebElement Add_arrow = driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
				Add_arrow.click();
				break;
			}
		}

		/*These statements verifies if the "Last Activity" is availble in the Selected Fields
		 * If Last Activity is available under Selected Fields, save the modifications
		 * 		 */
		if(Element_available = false) {
			WebElement Selected_Fields_dropdown = driver.findElement(By.xpath("//select[@id='colselector_select_1']"));
			Select Selected_Fields_dropdown_list = new Select(Available_Fields_dropdown);
			List<WebElement> Selected_Fields_dropdown_options = Available_Fields_dropdown_list.getOptions();

			for(int i=0; i<Available_Fields_dropdown_options.size(); i++) {
				if(Selected_Fields_dropdown_options.get(i).getText().equals("Last Activity")) {
					break;
				}
			}	
		}
		
		
		save.click();
		
		
	}
//Merging two accounts
	@FindBy(xpath="//a[contains(text(),'Merge Accounts')]")
	WebElement Mergeacc;
	@FindBy(xpath="//input[@id='srch']")
	WebElement fb;
	@FindBy(xpath="//input[@name='srchbutton']")
	WebElement FindAcc;
	@FindBy(xpath="//input[@id='cid0']")
	WebElement Button1;
	@FindBy(xpath="//input[@id='cid1']")
	WebElement Button2;
	@FindBy(xpath="//input[@id='cid2']")
	WebElement Button3;
	@FindBy(xpath="//div[contains(@class,'pbTopButtons')]//input[contains(@title,'Next')]")
	WebElement Next;
	@FindBy(xpath="//div[@class='pbTopButtons']//input[@title='Merge']")
	WebElement Merge;
	public void mergeAccount() throws Exception {
		// TODO Auto-generated method stub
		Accounts_Tab.click();
		System.out.println("Clicked on Accounts Ta..");
		handleLightenningwindow(lighteningwindow);	
		clickObj(Mergeacc, "Mergeacc");
		fb.clear();
		enterText(fb, "Vibha", "FindAccounts");
		clickObj(FindAcc, "FindAcc");
	    Next.click();    
	    Merge.click();	    
	    switchtoAlert(driver);	
	  	}
//Create Accounts Report
	@FindBy(xpath="//a[contains(text(),'Accounts with last activity > 30 days')]")
	WebElement LastActivity;
	@FindBy(xpath="//img[@id='ext-gen148']")
	WebElement dropdown1;
	@FindBy(xpath="//div[contains(text(),'Created Date')]")
	WebElement createddate;
	@FindBy(xpath="//input[@id='ext-comp-1042']")
	WebElement startdate;
	@FindBy(xpath="//input[@id='ext-comp-1045']")
	WebElement enddate;
	@FindBy(xpath="//button[@id='ext-gen49']")
	WebElement save1;
	@FindBy(xpath="//table[@id='dlgSaveAndRun']")
	WebElement Saveandrun;
	public void createReport() throws Exception {
		// TODO Auto-generated method stub
		Accounts_Tab.click();
		System.out.println("Clicked on Accounts Ta..");
		handleLightenningwindow(lighteningwindow);	
		
		clickObj(LastActivity, "LastActivity");
		clickObj(dropdown1, "dropdown");
		clickObj(createddate, "createddate");
		
		startdate.clear();
		enterText(startdate, "10/08/2021","calenderdate");
		WebElement enddate = driver.findElement(By.name("endDate"));
		enddate.clear();
		enterText(enddate, "10/09/2021", "calenderdate");
		
		save1.click();
		
		WebElement Reportnames =  driver.findElement(By.name("reportName"));
		Reportnames.clear();
		enterText(Reportnames, "Accountreports", "ChangeReportName");
		WebElement ReportUniName =  driver.findElement(By.id("saveReportDlg_DeveloperName"));
		ReportUniName.clear();
		enterText(ReportUniName, "Accountreports", "ChangeReportUniqueName");
		Thread.sleep(4000);
	   
		clickObj(Saveandrun, "Saveandrun");
		
	}
	
}
