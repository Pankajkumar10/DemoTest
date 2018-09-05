/**
 * 
 */
package com.GuruTesting.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author C5261904
 *
 */
public class LoginPage {
	public WebDriver ldriver;

	public LoginPage(WebDriver rdriver)
	
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement ClickOnLoginBtn;
	
	@FindBy(xpath="//a[text()='Log out']")
	@CacheLookup
	WebElement ClickOnLogOutBtn;
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void ClickSubmit()
	{
   ClickOnLoginBtn.click();
	}
	public void ClickLogOut()
	{
		ClickOnLogOutBtn.click();
	}
}


