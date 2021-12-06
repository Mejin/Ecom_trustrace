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

public class ThankyouPageTest extends TestBase {
	LoginPage loginPage;
    ProductPage productpage;
    CartPage  cartpage;
    CheckoutPage checkoutpage;
    OverviewPage overviewpage;
    ThankyouPage thankyoupage;
    CheckoutPageTest checkoutpagetest;
    public ThankyouPageTest()
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
		thankyoupage=new ThankyouPage();
		checkoutpagetest=new CheckoutPageTest();
		
		productpage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		String s=productpage.itemAddedToCart();
		cartpage=productpage.addToCart();
		
		checkoutpage=cartpage.Checkout();
	//	checkoutpagetest.detailsAdding();
		checkoutpage.detailsAdding(prop.getProperty("firstname"), prop.getProperty("Lastname"), prop.getProperty("zipcode"));
		overviewpage=checkoutpage.clickContinueButton();
		thankyoupage=overviewpage.finish();
		
	}
	
	@Test(priority=1)
	public void validateThankyouPageTitle(){
		String title = thankyoupage.validateThankyouPageTitle();
		Assert.assertEquals(title, "CHECKOUT: COMPLETE!");
	}
	@Test(priority=2)
	public void BacktohomeButtonValidation()
	{
		boolean product = thankyoupage.BacktohomeButtonValidation();
		Assert.assertEquals(product, true);
		
	}
	@Test(priority=3)
	public void Thankyoupagetext()
	{
		boolean product = thankyoupage.Thankyoupagetext();
		Assert.assertEquals(product, true);
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
