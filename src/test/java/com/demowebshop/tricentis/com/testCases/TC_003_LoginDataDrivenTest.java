package com.demowebshop.tricentis.com.testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.demowebshop.tricentis.com.pageClasses.HomePage;
import com.demowebshop.tricentis.com.pageClasses.LoginPage;
import com.demowebshop.tricentis.com.testBase.BaseClass;
import com.demowebshop.tricentis.com.utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_LoginDDT(String email, String pwd, String exp) {
		logger.info("*** Starting TC_003_LoginDataDrivenTest ***");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickOnLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setMail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			boolean targetpage = lp.isMyAccountExists();
			
			if (exp.equals("Valid")) {
				if (targetpage == true) {
					lp.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equals("Invalid")) {
				if (targetpage == true) {
					lp.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("*** Finished TC_003_LoginDataDrivenTest ***");

	}

}
