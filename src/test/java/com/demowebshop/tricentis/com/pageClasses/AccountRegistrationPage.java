package com.demowebshop.tricentis.com.pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	//Elements
	@FindBy(xpath="//input[@id='gender-male']")
	WebElement rdobtn_Male;
	
	@FindBy(id="gender-female")
	WebElement rdobtn_Female;
	
		
	@FindBy(name="FirstName")
	WebElement txt_FirstName;
	
	@FindBy(name="LastName")
	WebElement txt_LastName;
	
	@FindBy(name="Email")
	WebElement txt_Email;
	
	@FindBy(name="Password")
	WebElement txt_Password;
	
	@FindBy(name="ConfirmPassword")
	WebElement txt_ConfirmPWD;
	
	@FindBy (id="register-button")
	WebElement btn_Register;
	
	@FindBy(css="div.page-body > div.result")
	WebElement msg_confirmMessage;
	
	@FindBy(css="div.page-body > div.buttons > input")
	WebElement btn_Continuebtn;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement lnk_logout;
	
	//Action  methods
	public void selectGender_Male() {
		rdobtn_Male.click();
	}
	public void selectGender_Female() {
		rdobtn_Female.click();
	}
	public void setFirstName(String fname) {
		txt_FirstName.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txt_LastName.sendKeys(lname);
	}
	public void setEmail(String email) {
		txt_Email.sendKeys(email);
	}
	public void setPassword(String pwd) {
		txt_Password.sendKeys(pwd);
	}
	public void setConfirmPWD(String confirmPWD) {
		txt_ConfirmPWD.sendKeys(confirmPWD);;
	}
	public void clickRegister() {
		btn_Register.click();
	}
	public void clickContinueBtn() {
		btn_Continuebtn.click();
	}
	public void clickLogout() {
		lnk_logout.click();
	}
	public String getConfirmationMsg() {
		try {
			return msg_confirmMessage.getText();
		}catch(Exception e){
			return (e.getMessage());
		}
	}
	


}
