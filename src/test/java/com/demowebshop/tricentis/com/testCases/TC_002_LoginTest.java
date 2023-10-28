package com.demowebshop.tricentis.com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.tricentis.com.pageClasses.HomePage;
import com.demowebshop.tricentis.com.pageClasses.LoginPage;
import com.demowebshop.tricentis.com.testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void test_Login() {
		try {
		logger.info("*** Starting TC_002_LoginTest ***");
		HomePage hp=new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		logger.info("Click on Login link");
		hp.clickOnLogin();
		logger.info("Provide mail id");
		lp.setMail(rb.getString("email"));
		logger.info("Provide password");
		lp.setPassword(rb.getString("password"));
		logger.info("Click on Login Button");
		lp.clickLogin();
		String mailverify = lp.getMailID();
		Assert.assertEquals(mailverify, rb.getString("email"));
		logger.info("User logged in successfully");
		}catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Finished TC_002_LoginTest ***");
	}

}
