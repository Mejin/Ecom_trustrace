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
import com.ecom.qa.pages.ThankyouPage;

public class OverviewPageTest extends TestBase  {
	
	LoginPage loginPage;
    ProductPage productpage;
    CartPage  cartpage;
    CheckoutPage checkoutpage;
    OverviewPage overviewpage;
    ThankyouPage thankyoupage;
    CheckoutPageTest checkoutpagetest;
    public OverviewPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		productpage = new ProductPage();
		loginPage = new LoginPage();
		checkoutpage = new CheckoutPage();
		overviewpage=new OverviewPage();
	//	thankyoupage=new ThankyouPage();
		checkoutpagetest=new CheckoutPageTest();
		
		productpage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		String s=productpage.itemAddedToCart();
		cartpage=productpage.addToCart();
		
		checkoutpage=cartpage.Checkout();
	//	checkoutpagetest.detailsAdding();
		checkoutpage.detailsAdding(prop.getProperty("firstname"), prop.getProperty("Lastname"), prop.getProperty("zipcode"));
		overviewpage=checkoutpage.clickContinueButton();
		
	}
	@Test(priority=1)
	public void OverviewPagetitleTest(){
		String title = overviewpage.validateOverviewPageTitle();
		Assert.assertEquals(title, "CHECKOUT: OVERVIEW");
	}
	@Test(priority=2)
	public void cancelButtonValidation()
	{
		boolean product = overviewpage.cancelButtonValidation();
		Assert.assertEquals(product, true);
		
	}
	@Test(priority=3)
	public ThankyouPage finish(){
		overviewpage.finish();
		 return thankyoupage;
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
