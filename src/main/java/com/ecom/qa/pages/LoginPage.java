package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(xpath="//*[@id='user-name']")
	WebElement username;
	
	@FindBy(xpath="//*[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//*[@id='login-button']")
	WebElement login;
	
	//initializing the current class page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//login page actions
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public ProductPage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		    	
		//after clicking on login it will land on cart page . so returning productPage object    	
		return new ProductPage();
	}
}
