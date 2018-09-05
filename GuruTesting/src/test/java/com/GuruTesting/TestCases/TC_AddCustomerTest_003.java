package com.GuruTesting.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GuruTesting.pageObjects.AddCustomerPage;
import com.GuruTesting.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
    
	@Test
	public void addNewCustomer() throws InterruptedException, IOException 
	{
		LoginPage login=new LoginPage(driver);
		login.setUserName(username);
		login.setPassword(password);
		login.ClickSubmit();
		logger.info("Login is Successful");
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		logger.info("Providing Customer details");
		addcust.custName("Pankaj");
		addcust.custgender("male");
		addcust.custdob("10","15","1991");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("BANGALORE");
		addcust.custstate("KARNATAKA");
		addcust.custpinno("560066");
		addcust.custtelephoneno("8123272483");
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		System.out.println(email);
		
		addcust.custpassword("12345");
		addcust.custsubmit();
		logger.info("Validating Customer creation Successful");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
		} else {
			captureScreen(driver,"addNewCustomer"); 
			Assert.assertTrue(false);
		}
	}
	
}
