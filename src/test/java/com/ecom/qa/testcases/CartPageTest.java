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

public class CartPageTest extends TestBase {
	LoginPage loginPage;
    ProductPage productpage;
    CartPage  cartpage;
    CheckoutPage checkoutpage;
    public CartPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		productpage = new ProductPage();
		loginPage = new LoginPage();
		productpage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String s=productpage.itemAddedToCart();
		cartpage=productpage.addToCart();
	}
	@Test(priority=1)
	public void CartPageTitleTest(){
		String title = cartpage.validateCartPageTitle();
		Assert.assertEquals(title, "YOUR CART");
	}
	@Test(priority=2)
	public void RemoveButtonValidation()
	{
		boolean product = cartpage.RemoveButtonValidation();
		Assert.assertEquals(product, true);
		
	}
	@Test(priority=3)
	public void continueShoppingValidation()
	{
		boolean continueShopping = cartpage.continueShoppingValidation();
		Assert.assertEquals(continueShopping, true);
		
	}
	@Test(priority=4)
	public CheckoutPage Checkout(){
		 cartpage.Checkout();
		 return checkoutpage;
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
