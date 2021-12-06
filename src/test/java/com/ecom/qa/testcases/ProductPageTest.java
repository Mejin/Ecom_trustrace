package com.ecom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.CartPage;
import com.ecom.qa.pages.LoginPage;
import com.ecom.qa.pages.ProductPage;

public class ProductPageTest extends TestBase {
	LoginPage loginPage;
    ProductPage productpage;
    CartPage  cartpage;
	public ProductPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		productpage = new ProductPage();
		loginPage = new LoginPage();
		productpage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void productPageTitleTest(){
		String title = productpage.productPageTitleTest();
		Assert.assertEquals(title, "PRODUCTS");
	}
	@Test(priority=2)
	public void productValidation()
	{
		boolean product = productpage.productValidation();
		Assert.assertEquals(product, true);
		
	}
	@Test(priority=3)
	public void cartButtonValidation()
	{
		boolean cartButton = productpage.productValidation();
		Assert.assertEquals(cartButton, true);
		
	}
	@Test(priority=4)
	public void itemAddedToCart(){
		String productCount = productpage.itemAddedToCart();
		Assert.assertEquals(productCount, "1");
	}
	@Test(priority=5)
	public void addToCart(){
		cartpage = productpage.addToCart();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
