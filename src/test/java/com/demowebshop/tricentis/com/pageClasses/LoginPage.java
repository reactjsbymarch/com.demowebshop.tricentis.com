package com.demowebshop.tricentis.com.pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(id="Email")
	WebElement txt_Email;
	
	@FindBy(id="Password")
	WebElement txt_Password;
	
	@FindBy(id="RememberMe")
	WebElement chkbx_RememberMe;
	
	@FindBy(linkText="Forgot password?")
	WebElement lnk_ForgotPWD;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement btn_Login;
	
	@FindBy(xpath="(//a[@class='account'])[1]")
	WebElement lnk_MailVerify;
	
	@FindBy(linkText = "Log out")
	WebElement lnk_Logout;
	
	//Action Methods
	public void setMail(String mail) {
		txt_Email.sendKeys(mail);
	}
	public void setPassword(String pwd) {
		txt_Password.sendKeys(pwd);
	}
	public void checkRememberMe() {
		chkbx_RememberMe.click();
	}
	public void clickForgot() {
		lnk_ForgotPWD.click();
	}
	public void clickLogin() {
		btn_Login.click();
	}
	public String getMailID() {
		try {
			return lnk_MailVerify.getText();
		}catch(Exception e){
			return (e.getMessage());
		}
	}
	public boolean isMyAccountExists()   // MyAccount Page heading display status
	{
		try {
			return (lnk_MailVerify.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	public void clickLogout() {
		lnk_Logout.click();
	}
}
