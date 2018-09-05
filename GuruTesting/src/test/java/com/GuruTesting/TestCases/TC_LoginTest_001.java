package com.GuruTesting.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GuruTesting.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass{

	
	@Test
	public void loginTest() throws IOException {
	
		LoginPage login=new LoginPage(driver);
		login.setUserName(username);
		logger.info("Username Entered");
		login.setPassword(password);
		logger.info("Password entered");
		login.ClickSubmit();
		logger.info("Clicked on Login Button");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
				{
			logger.info("LoginTest PASSED");
			Assert.assertTrue(true);
				} 
		else {
			captureScreen(driver,"loginTest");
			logger.info("LoginTest FAILED");
			Assert.assertTrue(false);
			
		}
				
		
	
	
	}
	
}
