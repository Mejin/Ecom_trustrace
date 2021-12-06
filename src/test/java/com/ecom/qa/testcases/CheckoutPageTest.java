package com.ecom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.CartPage;
import com.ecom.qa.pages.CheckoutPage;
import com.ecom.qa.pages.LoginPage;
import com.ecom.qa.pages.OverviewPage;
import com.ecom.qa.pages.ProductPage;

public class CheckoutPageTest extends TestBase {
	LoginPage loginPage;
    ProductPage productpage;
    CartPage  cartpage;
    CheckoutPage checkoutpage;
    OverviewPage overviewpage;
    
    public CheckoutPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		productpage = new ProductPage();
		loginPage = new LoginPage();
		checkoutpage = new CheckoutPage();
		
		productpage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String s=productpage.itemAddedToCart();
		cartpage=productpage.addToCart();
		checkoutpage=cartpage.Checkout();
		
	}
	@Test(priority=1)
	public void checkoutPageTitleTest(){
		String title = checkoutpage.validateCheckoutPageTitle();
		Assert.assertEquals(title, "CHECKOUT: YOUR INFORMATION");
	}
	@Test(priority=2)
	public void cancelButtonValidation()
	{
		boolean product = checkoutpage.cancelButtonValidation();
		Assert.assertEquals(product, true);
		
	}
	@Test(priority=3)
	public void detailsAdding(){
		checkoutpage.detailsAdding(prop.getProperty("firstname"), prop.getProperty("Lastname"), prop.getProperty("zipcode"));
	}
	@Test(priority=4)
	public OverviewPage Checkout(){
		checkoutpage.clickContinueButton();
		 return overviewpage;
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
