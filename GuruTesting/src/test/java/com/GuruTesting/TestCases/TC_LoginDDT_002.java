package com.GuruTesting.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GuruTesting.Utilites.XLUtils;
import com.GuruTesting.pageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException {
		
		LoginPage login=new LoginPage(driver);
		login.setUserName(user);
		logger.info("username provided");
		login.setPassword(pwd);
		logger.info("Password provided");
		login.ClickSubmit();
		logger.info("Clicked on LoginBtn");
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)//failure case
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("Login failed");
			Thread.sleep(3000);
		}
		else //passed case
		{
			Assert.assertTrue(true);
			logger.info("Login Success");
			login.ClickLogOut();
			driver.switchTo().alert().accept();//close alert popup window
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
		}
	}
	
	public boolean isAlertPresent() 
	{
		try
		{
		driver.switchTo().alert();
		return true;
	} 
	 catch(NoAlertPresentException e)
	{ 
		return false;
	
	
	}
	}
	
	@DataProvider(name="LoginData")
    public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/GuruTesting/TestData/LoginData.xlsx";
	    int rownum=XLUtils.getRowCount(path, "sheet1");
	    int colcount=XLUtils.getCellCount(path, "sheet1", 1);
	    String logindata[][]=new String[rownum][colcount];
	    for(int i=1;i<=rownum;i++) {
	    	for(int j=0;j<colcount;j++) {
	    		logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);//1,0
	    	}
	    }
	    return logindata;
	}


}


