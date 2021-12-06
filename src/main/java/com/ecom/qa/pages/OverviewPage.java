package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ecom.qa.base.TestBase;

public class OverviewPage extends TestBase {
	@FindBy(xpath = "//span[@class='title']")
	WebElement title;
	
	@FindBy(xpath = "//button[@id='cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath = "//button[@id='finish']")
	WebElement finishButton;



	public OverviewPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateOverviewPageTitle() {
		return title.getText();
	}
	public boolean cancelButtonValidation() {
		return cancelButton.isDisplayed();
	}
	
	public ThankyouPage finish(){
		finishButton.click();
		 return new ThankyouPage();
	}
	
	
	
}
