package com.demowebshop.tricentis.com.pageClasses;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnk_Register;
	
	@FindBy(xpath="//a[text()='Log in']")
	WebElement lnk_LogIn;
	
	@FindBy(xpath="//span[text()='Shopping cart']")
	WebElement lnk_Shoppingcart;
	
	@FindBy(xpath="//span[text()='Wishlist']")
	WebElement lnk_Wishlist;
	
	//Action Methods
	public void clickRegister() {
		lnk_Register.click();
	}
	public void clickOnLogin() {
		lnk_LogIn.click();
	}
	public void clickOnShoppingcart() {
		lnk_Shoppingcart.click();
	}
	public void clickOnWishlist() {
		lnk_Wishlist.click();
	}
}
