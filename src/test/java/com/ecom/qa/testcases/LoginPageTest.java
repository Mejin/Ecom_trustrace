package com.ecom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.LoginPage;
import com.ecom.qa.pages.ProductPage;
import com.relevantcodes.extentreports.ExtentReports;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	ProductPage productpage;
	public LoginPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
	    loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	@Test(priority=2)
	public void loginTest(){
		productpage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
