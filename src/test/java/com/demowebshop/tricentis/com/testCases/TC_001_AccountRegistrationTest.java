package com.demowebshop.tricentis.com.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.tricentis.com.testBase.BaseClass;
import com.demowebshop.tricentis.com.pageClasses.HomePage;
import com.demowebshop.tricentis.com.pageClasses.AccountRegistrationPage;


public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void test_account_registration() throws InterruptedException {
		try {
			logger.info("*** Starting TC_001_AccountRegistrationTest ***");
			HomePage hp=new HomePage(driver);
			hp.clickRegister();
			logger.info("Clicked on Register");
			AccountRegistrationPage arp = new AccountRegistrationPage(driver);
			logger.info("Select Gender");
			arp.selectGender_Male();
			logger.info("Provide customer First Name");
			arp.setFirstName(randomString());
			logger.info("Provide customer Last Name");
			arp.setLastName(randomString());
			logger.info("Provide customer Email");
			String email = randomString();
			arp.setEmail(email+"@gmail.com");
			logger.info("Provide customer password");
			arp.setPassword("Test1234");
			logger.info("Provide customer confirm password");
			arp.setConfirmPWD("Test1234");
			logger.info("Clicked on Register button");
			arp.clickRegister();
			
			String cnfrmMsg = arp.getConfirmationMsg();
			Assert.assertEquals(cnfrmMsg, "Your registration completed");
			arp.clickContinueBtn();
			arp.clickLogout();
			
		}
		catch(Exception e) {
			logger.info("Test Failed");
			Assert.fail(e.getMessage());
		}
		logger.info("*** Finished TC_001_AccountRegistrationTest ***");
	}

}
