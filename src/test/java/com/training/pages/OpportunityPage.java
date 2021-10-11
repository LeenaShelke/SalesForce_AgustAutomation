package com.training.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class OpportunityPage extends BasePage{

	public OpportunityPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//li[@id='Opportunity_Tab']")
	WebElement OpportunitiesTab;
	@FindBy(xpath="//select[@id='fcf']")
	WebElement Oppdropdown;
	@FindBy(xpath="//select[@id='fcf']")
	List<WebElement> Menuitem;
	@FindBy(xpath="//a[@id='tryLexDialogX']")
	WebElement lighteningwindow;
	
	public List<String> dropdownlist() throws InterruptedException {
		// TODO Auto-generated method stub
		waitforElement(OpportunitiesTab);
		clickObj(OpportunitiesTab, "Opportunities");
		handleLightenningwindow(lighteningwindow);
		Oppdropdown.click();
		List<String> list = new ArrayList<String>(); //to get the list from usermenu dropdown
		for(WebElement ele: Menuitem)
		{
			//System.out.println(ele.getText());
			list.add(ele.getText());
		}
		return list;
	  
	}
	
	//Create New Opportunity
	@FindBy(xpath="//input[contains(@title,'New')]")
	WebElement New_button;
	@FindBy(xpath="//input[@id='opp3']")
	WebElement Oppname;
	@FindBy(xpath="//img[@title='Account Name Lookup (New Window)']")
	WebElement LookupWindow;
	@FindBy(xpath="//select[@id='opp11']")
	WebElement Stage;
	@FindBy(xpath="//input[@id='opp12']")
	WebElement Portability;
	@FindBy(xpath="//a[@class='calToday']")
	WebElement today;
	@FindBy(xpath="(//input[@title='Save'])[2]")
	WebElement save;
		
	public void createNewOpp() throws InterruptedException
	{
		waitforElement(OpportunitiesTab);
		clickObj(OpportunitiesTab, "Opportunities");
		handleLightenningwindow(lighteningwindow);
		clickObj(New_button, "New_button");
		Oppname.clear();
		Oppname.sendKeys("ABCD");
		
		//WebElement AccNameOpp = driver.findElement(By.xpath("//input[@id='opp4']"));
		//AccNameOpp.sendKeys("Workday123");
	
		LookupWindow.click();
		String oldWindow = driver.getWindowHandle();
		//Switching driver control to new window.
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[1]);
		
		Thread.sleep(3000);
		
		//switch to first frame
		driver.switchTo().frame("searchFrame");
		driver.findElement(By.id("lksrch")).sendKeys("Vibha");
		driver.findElement(By.xpath("//input[@name='go']")).click();
		
		//Switching to Lookup Window
		driver.switchTo().defaultContent();
		
		//Switching to Insideframe(result)
		
		driver.switchTo().frame("resultsFrame");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tr[@class='dataRow even last first']/th/a")).click();
		
		driver.switchTo().window(getWindow[0]);
	
		Thread.sleep(2000);
		
		//Coming out of the window to original window.
		driver.findElement(By.xpath("//input[@id='opp9']")).click();
		today.click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		Stage.click();
		Select dropdown = new Select(Stage);
		dropdown.selectByValue("Qualification");
		Portability.sendKeys("80");
		save.click();
		//driver.close();
	}
	@FindBy(xpath="//a[contains(text(),'Opportunity Pipeline')]")
	WebElement OpportunityPipeline;
	@FindBy(xpath="//h1[normalize-space()='Opportunity Pipeline'])")
	WebElement oppHeadername;	
	public String testPipelineReport() throws InterruptedException {
		// TODO Auto-generated method stub
		waitforElement(OpportunitiesTab);
		clickObj(OpportunitiesTab, "Opportunities");
		handleLightenningwindow(lighteningwindow);
		waitforElement(OpportunityPipeline);
		clickObj(OpportunityPipeline, "Opportunity Pipeline");
		waitforElement(oppHeadername);
		Thread.sleep(6000);
		return(oppHeadername.getText());
	}
	//test stuck Pipeline Repport
	@FindBy(xpath="//a[normalize-space()='Stuck Opportunities']")
	WebElement stuckPipelineReport;
	@FindBy(xpath="//h1[normalize-space()='Stuck Opportunities']")
	WebElement stuckoppHeadername;	
	
	public String testStuckPipelineReport() throws InterruptedException {
		// TODO Auto-generated method stub
		waitforElement(OpportunitiesTab);
		clickObj(OpportunitiesTab, "Opportunities");
		handleLightenningwindow(lighteningwindow);
		stuckPipelineReport.click();
		waitforElement(stuckoppHeadername);
		return(stuckoppHeadername.getText());
	}
//Test Quarterly Summary Report 
	@FindBy(xpath="//select[@id='quarter_q']")
	WebElement Interval;
	@FindBy(xpath="//select[@id='open']")
	WebElement include;
	@FindBy(xpath="//input[@title='Run Report']")
	WebElement RunReport;
	public void testQuatSummReport() throws InterruptedException {
		// TODO Auto-generated method stub
		waitforElement(OpportunitiesTab);
		clickObj(OpportunitiesTab, "Opportunities");
		handleLightenningwindow(lighteningwindow);
		waitforElement(Interval);
		clickObj(Interval, "Interval");
		
		selectByVisibleText(Interval,"Next FQ");
		
		//WebElement include = driver.findElement(By.xpath("//select[@id='open']"));
		//clickObj(include, "include");
		
		//WebElement Dropdown1 = driver.findElement(By.xpath("//select[@id='open']"));
		selectByVisibleText(include, "Open Opportunities");
		
		
		clickObj(RunReport, "RunReport");
		
	}
	}

