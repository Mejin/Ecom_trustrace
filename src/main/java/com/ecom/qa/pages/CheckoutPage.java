package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;

public class CheckoutPage extends TestBase {
	@FindBy(xpath = "//span[@class='title']")
	WebElement title;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueButton;

	@FindBy(xpath = "//button[@id='cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalCode;

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateCheckoutPageTitle() {
		return title.getText();
	}
	
	public boolean cancelButtonValidation() {
		return cancelButton.isDisplayed();
	}
	public void detailsAdding(String Fname,String Lname,String Pcode) {
		firstName.sendKeys(Fname);
		lastName.sendKeys(Lname);
		postalCode.sendKeys(Pcode);
		
	}
	
	public OverviewPage clickContinueButton() {
		 continueButton.click();
		 return new OverviewPage();
	}
	
	
	
}
