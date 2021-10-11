package com.training.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
public static WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver  = driver;
		PageFactory.initElements(driver, this);	
	}
	public static void waitExplicitly1(WebDriver driver,WebElement obj )
	{
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(obj));
		
	}	
	public static void handleLightenningwindow(WebElement Obj) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(12000);
		Obj.click();
	}
	public static void selectByVisibleText(WebElement obj, String Name) {
		if(obj.isDisplayed()) {
			 Select drop = new Select(obj);
			 drop.selectByVisibleText(Name);
		 System.out.println("Pass: dropdown is selected");
		 }else {
		 System.out.println("Fail: dropdown is not available check your application");
		 }
		 }
	
	/*
	 * Name of the method: Radiobutton
	 * Brief Description: To click on the radio button 
	 * Arguments: obj --> web object, objName--> name of the object
	 * Created by: Automation team
	 * Creation Date: Feb 12 2019
	 * Last Modified: Feb 12 2019
	 * */
	public static void Radiobutton(WebElement obj, String objName) {
		
		if(obj.isDisplayed() ){
			obj.click();
			System.out.println("Pass: "+objName+" is clicked");
		}else {
			System.out.println("Fail:"+objName+" is not displayed .Please check your application");			
		}
	}
	/* name of the method:   switchtoAlert
	 * BriefDescription  :   Switch to alert
	 * Arguments         :  driver
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 
	public static void switchtoAlert(WebDriver driver) {
		 driver.switchTo().alert().accept();
		 System.out.println("Pass: alert is present and accept");
	}
	public static void enterText(WebElement obj,String textval,String objName) throws Exception

	{
		if(obj.isDisplayed())
		{
			Thread.sleep(4000);
			obj.sendKeys(textval);
			System.out.println("pass: "+textval+"value is entered in "+objName+"field");
			//Call take screenshot function
//			logger.log(LogStatus.PASS,textval+"value is entered in "+objName+"field");
			
			
		}
		else
		{
			System.out.println("fail:" +objName+ "field does not exist please check application");
//			logger.log(LogStatus.FAIL,textval+objName+"field does not exist please check application");
			
		}
	}
	public static void clickObj(WebElement obj,String objName)
	{
		if(obj.isDisplayed())
		{
			obj.click();
			System.out.println("pass :" +objName + "button is clicked");
//			logger.log(LogStatus.PASS, objName+ "button is displayed ,please check the application");
		}
		else
		{
			System.out.println("Fail:" +objName+"button is not displayed ,please check the application");
//			logger.log(LogStatus.FAIL, objName+ "button is not displayed ,please check the application");
		}
	}
	public static void waitforElement(WebElement element){

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitforClickableElement(WebElement element){

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/* name of the method:   mouseOver
	 * BriefDescription  :   mouseOver  
	 * Arguments         :  obj,index 
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 

	public static void mouseOver(WebDriver driver,WebElement obj) {
		if(obj.isDisplayed()) {
	   Actions action=new Actions(driver);
	   action.moveToElement(obj).build().perform();
		System.out.println("Pass: "+obj+" is present");
//		logger.log(LogStatus.PASS,  "obj is present" );
		}
	 else {
			System.out.println("Fail:"+obj+" is not present.Please chk application");
//			logger.log(LogStatus.FAIL,  "obj is not present.Please chk application" );
		}
	}
	public static void selectDropdown(WebElement obj, String objName) {
		
		if(obj.isDisplayed()) {
			System.out.println("Pass: "+objName+" is  selected");
			obj.click();
		}else
		{
		
			System.out.println("Fail:"+objName+" is not present.Please chk application");	
//		
	    }}
	public Select getList(WebElement listcontainer)
	{
		Select sel = new Select(listcontainer);
		
		return sel;
	}

}
