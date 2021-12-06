package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;

public class CartPage extends TestBase {
	@FindBy(xpath = "//button[text()='Remove']")
	WebElement removeButton;

	@FindBy(xpath = "//button[@id='continue-shopping']")
	WebElement continueShopping;

	@FindBy(xpath = "//span[@class='title']")
	WebElement title;

	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkoutbutton;

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateCartPageTitle() {
		return title.getText();
	}

	public boolean RemoveButtonValidation() {
		return removeButton.isDisplayed();
	}

	public boolean continueShoppingValidation() {
		return continueShopping.isDisplayed();
	}

	public CheckoutPage Checkout() {

		checkoutbutton.click();
		// after clicking on login it will land on cart page . so returning CheckoutPage
		// object
		return new CheckoutPage();
	}
}
