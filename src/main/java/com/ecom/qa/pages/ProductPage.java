package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;

public class ProductPage extends TestBase {

	@FindBy(xpath = "//button[contains(@id,'backpack')]")
	WebElement addtocart;
	
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement itemAdded;

	@FindBy(xpath = "//*[text()='Products' and @class='title']")
	WebElement title;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartbutton;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public String productPageTitleTest(){
		return title.getText();
	}
	
	public boolean cartButtonValidation(){
		return cartbutton.isDisplayed();		
	}
	
	public boolean productValidation(){
		return addtocart.isDisplayed();		
	}
	
	public String itemAddedToCart() {
		 addtocart.click();
		return itemAdded.getText(); 
	}
	
	
	public CartPage addToCart(){
		
		cartbutton.click();   	
		//after clicking on login it will land on cart page . so returning cartpage object    	
		return new CartPage();
	}
}
