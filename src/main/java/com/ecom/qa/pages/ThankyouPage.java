package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;

public class ThankyouPage extends TestBase {
	@FindBy(xpath = "//span[@class='title']")
	WebElement title;
	
	@FindBy(xpath = "//button[@id='back-to-products']")
	WebElement BacktohomeButton;
	
	@FindBy(xpath = "//*[text()='THANK YOU FOR YOUR ORDER']")
	WebElement Thankyou;



	public ThankyouPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateThankyouPageTitle() {
		return title.getText();
	}
	public boolean BacktohomeButtonValidation() {
		return BacktohomeButton.isDisplayed();
	}
	
	public boolean Thankyoupagetext(){
		return Thankyou.isDisplayed();
		 
	}
	
}
