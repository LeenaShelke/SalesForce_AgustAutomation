package com.training.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
			
	@FindBy(xpath="//input[@id='Login']")
	WebElement btnLogin;
	
	@FindBy(css="#error")
	List<WebElement>errorMsg;
	
	@FindBy(xpath="//div[@id='error']")
	WebElement pwdErrMsg;
	
	@FindBy(css="#rememberUn")
	WebElement rememberMe;
	
	@FindBy(css="#forgot_password_link")
	WebElement forgotPasswordlink;
	
	@FindBy(xpath="//h2[@id='header']")
	WebElement forgotPasswordlinkmsg;
	
//	@FindBy(css="#idcard-identity")
//	WebElement Usernamefield;
	
	@FindBy(xpath="//span[contains(text(),'Leena')]")
	WebElement Usernamefield;
	
	@FindBy(xpath ="//a[@title='Logout']")
	WebElement Logout;
	
	@FindBy(css="#un")
	WebElement Fname;
	
	 @FindBy(xpath = ".//*[@id='un']") 
	 WebElement Conti;
	 

	
	public void enterintoUsername(String strusername) {
		username.sendKeys(strusername);
	}

	public void enterIntoPassword(String strpassword) {
		password.sendKeys(strpassword);
	}

	public void clickLoginButton() {
		btnLogin.click();
	}

	public WebElement enterintoUsername() {
		return username;
	}

	public WebElement enterIntoPassword() {
		return password;
	}
	public WebElement LoginButton() {
		return btnLogin;
	}
	public WebElement forgotPassword() {
		return forgotPasswordlink;
	}
	public WebElement fullName() {
		return Fname;
	}
	

	public void logintapplication(String strusername, String strpassword) {
		username.sendKeys(strusername);
		password.sendKeys(strpassword);
	//	btnLogin.click();
	}
	public String ClickLogin() throws InterruptedException
	{
		btnLogin.click();
		String str= driver.getTitle();
		Thread.sleep(3000);
		return str;
	}
	public String clickOnLogin() {
		btnLogin.click();
		waitforClickableElement(btnLogin);
		if(errorMsg.size()!=0)
		{
			//System.out.println(errorMsg.get(0).getText());
			return errorMsg.get(0).getText();
		}
		else
			
			return driver.getTitle();
		
	}
	public void clickOnRememberMe()
	{
		rememberMe.click();
		waitforClickableElement(rememberMe);
	}
	public String CheckUsernamefield()
	{
		waitforElement(Usernamefield);
		return Usernamefield.getText();
	}
	public String ForgotPassword() throws InterruptedException
	{
		forgotPasswordlink.click();
		//waitforClickableElement(forgotPasswordlink);
		Thread.sleep(1000);
		return forgotPasswordlinkmsg.getText();
	}
	public WebElement Continue() {
		return Conti;
	}

	public void ClickLogout()
	{
		waitforElement(Usernamefield);
		if(Usernamefield.isDisplayed()) {
			  Usernamefield.click();
		}
		waitforElement(Logout);
		
	//	driver.findElement(By.xpath("//a[@title='Logout']")).click(); 
	
		Logout.click();
		}
}

