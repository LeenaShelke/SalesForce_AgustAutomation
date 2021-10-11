package com.training.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.training.Utilities.CommonUtilities;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
private WebDriver driver;

CommonUtilities common = new CommonUtilities();

@BeforeTest
public WebDriver getdriver() 
{
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	
	return driver;
}

public void BrowserSetup()
{
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	DOMConfigurator.configure("log4j.xml");
}

public static void takescreenshot(WebDriver driver) throws IOException {
	
	  TakesScreenshot scrShot = ((TakesScreenshot)driver);
	  File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
	  
	  	Date currentDate = new Date();
	  	String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);
	  	String fileSeperator = System.getProperty("file.separator");
	    String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "Screenshots";
	    String reportFileName = "ScreenShot"+timestamp+".png";
	    String filePath =  reportFilepath +fileSeperator+ reportFileName;
	    File DestFile = new File(filePath);
	    FileUtils.copyFile(srcFile, DestFile);
	
}

	/* name of the method:   clickobject--->Button
	 * BriefDescription  :   clicking a button
	 * Arguments         :  obj-->object,objName--->object name
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */
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
	

/*
 * Name of the method: selectCheckBox
 * Brief Description: Select the checkbox
 * Arguments: obj --> web object, objName--> name of the object
 * Created by: Automation team
 * Creation Date: Feb 12 2019
 * Last Modified: Feb 12 2019
 * */
	public static void selectCheckBox(WebElement obj, String objName) {
		
		if(obj.isDisplayed()) {
			
			if(obj.isSelected()) {
				System.out.println("Pass: "+objName+" is already selected");
//				logger.log(LogStatus.INFO, objName + "is already selected");
			}else{
			obj.click();
			System.out.println("Pass: "+objName+" is selected");
//			logger.log(LogStatus.PASS, objName + "is selected");
		    }}
			else {
			System.out.println("Fail:"+objName+" is not present.Please chk application");	
//			logger.log(LogStatus.FAIL, objName+ " is not displayed ,please check the application");
		}	
	}
	
	/*
	 * Name of the method: selectDropdown
	 * Brief Description: Select the Dropdown list
	 * Arguments: obj --> web object, objName--> name of the object
	 * Created by: Automation team
	 * Creation Date: Feb 12 2019
	 * Last Modified: Feb 12 2019
	 * */
	public static void selectDropdown(WebElement obj, String objName) {
						
				if(obj.isDisplayed()) {
					System.out.println("Pass: "+objName+" is  selected");
					obj.click();
				}else
				{
				
					System.out.println("Fail:"+objName+" is not present.Please chk application");	
//				
			    }}
				
			
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
	
	/*
	 * Name of the method: validateErrormsg
	 * Brief Description: to validate the error msg 
	 * Arguments: actualmsg --> name of the object, errormsg--> name of the object
	 * Created by: Automation team
	 * Creation Date: Feb 12 2019
	 * Last Modified: Feb 12 2019
	 * */
	
	public static void validateErrormsg(String actualmsg, String errormsg) {
		
		if(actualmsg.equals(errormsg))
		{
			System.out.println("TestCase is passed");
//			logger.log(LogStatus.PASS,  "TestCase is passed" );
		}else
	    {
		System.out.println("TestCase is failed");
//		logger.log(LogStatus.FAIL,  "TestCase is failed" );
	    }
	}

/* name of the method:   iFrame
 * BriefDescription  :   iframe using webelement 
 * Arguments         :  driver--->driver 
 *                      obj--->webelement
 *  createdby        :  Automation team 
 *  created date     :02/13/19 
 *  LastModified Date:02/13/19          
 */
public static void switchFrame( WebDriver driver,WebElement obj) {
	 
    if(obj.isDisplayed()) {
     driver.switchTo().frame(obj);
     System.out.println("Pass: we can switch to the "+obj+ " frame");
//     logger.log(LogStatus.PASS,  "Switch to frame" );
     
    }else {
     System.out.println("fail: we can't switch to the "+obj+ " frame");
//     logger.log(LogStatus.FAIL,  "Cannot Switch to frame" );
    }
}

/* name of the method:   switchFrameid
 * BriefDescription  :   iframe using webelement 
 * Arguments         :  driver--->driver 
 *                      obj--->iframe id
 *  createdby        :  Automation team 
 *  created date     :02/13/19 
 *  LastModified Date:02/13/19          
 */

public static void switchFrameid( WebDriver driver,String obj) {
	 
     driver.switchTo().frame(obj);
     System.out.println("Pass: we can switch to the "+obj+ " frame");
//     logger.log(LogStatus.PASS,  "we can switch to the frame" );
     
    }

/* name of the method:   switchdefaultFrame
 * BriefDescription  :   iframe for switching back to default frame 
 * Arguments         :  driver--->driver 
 *  createdby        :  Automation team 
 *  created date     :02/13/19 
 *  LastModified Date:02/13/19          
 */ 
public static void switchdefaultFrame( WebDriver driver)
{
driver.switchTo().defaultContent();
System.out.println("Pass: we can switch to the "+ driver + " back to frame");
//logger.log(LogStatus.PASS,  "we can switch back to the frame" );
}



/* name of the method:   selectbyText
 * BriefDescription  :   selected by clicking the dropdown 
 * Arguments         :  obj,objName 
 *  createdby        :  Automation team 
 *  created date     :02/13/19 
 *  LastModified Date:02/13/19          
 */ 
public static void SelectbyText(WebElement we, String VisibleText){
	   if(we.isDisplayed())
	   {
		   Select selObj=new Select(we);
           selObj.selectByVisibleText(VisibleText);
	           System.out.println("Pass: "+VisibleText+ " is Selected by VisibleText" );
//	           logger.log(LogStatus.PASS, " is Selected by VisibleText" );
	           
	   } 
	   else
	   {
	    System.out.println("Fail: "+VisibleText+ " is not available");
//	    logger.log(LogStatus.FAIL, " is not Selected by VisibleText" );
	    
	   }
	   
	   
}

/* name of the method:   SelectByValue
 * BriefDescription  :   selectedByValue by clicking the dropdown 
 * Arguments         :  obj,index 
 *  createdby        :  Automation team 
 *  created date     :02/13/19 
 *  LastModified Date:02/13/19          
 */ 
public static void SelectByValue(WebElement obj, String val) {
	  //if(obj.isSelected()) {
	if(obj.isDisplayed()) {
	   Select selObj=new Select(obj);
	    
	   selObj.selectByValue(val);
	  System.out.println("pass:"+val + " is selected from drop down ");
//	  logger.log(LogStatus.PASS, " is selected from drop down " );
	 
	  }else {
	   System.out.println("Fail:"+val+"is not selected");
//	   logger.log(LogStatus.FAIL, " is not selected from drop down " );
	  }
	 }	  


/* name of the method:   SelectByindex
 * BriefDescription  :   selected by clicking the dropdown 
 * Arguments         :  obj,index 
 *  createdby        :  Automation team 
 *  created date     :02/13/19 
 *  LastModified Date:02/13/19          
 */ 
public static void selectByIndex(WebElement obj, int index) {
	  if(obj.isDisplayed()) {
	   Select selObj=new Select(obj);
	  selObj.selectByIndex(index);
	  
	  System.out.println("pass:"+index + " is selected from drop down ");
//	  logger.log(LogStatus.PASS, " is selected from drop down " );
	  }else {
	   System.out.println("Fail:"+index+"is not selected");
//	   logger.log(LogStatus.FAIL, " is not selected from drop down " );
	  }
	 }








	
/*	public static String[][] readXlData(String path, String string) throws IOException{
		FileInputStream fs=new FileInputStream(new File(path));
		HSSFWorkbook wb=new HSSFWorkbook(fs);
		HSSFSheet sheet=wb.getSheet("Sheet1");
		int rowCount=sheet.getLastRowNum()+1;
		int colCount=sheet.getRow(0).getLastCellNum();
		String[][] data=new String[rowCount][colCount];
		for(int i=0;i<rowCount;i++){
			for(int j=0;j<colCount;j++){
				int cellType=sheet.getRow(i).getCell(j).getCellType();
				
				if(cellType==HSSFCell.CELL_TYPE_NUMERIC){
					int val=(int)sheet.getRow(i).getCell(j).getNumericCellValue();
					data[i][j]=String.valueOf(val);
				}
				else
					data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					
			}
		}
		return (data);
	}*/

}
