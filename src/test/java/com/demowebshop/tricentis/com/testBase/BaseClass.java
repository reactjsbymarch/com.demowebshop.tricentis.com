package com.demowebshop.tricentis.com.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public WebDriverWait wait;
	public ResourceBundle rb;
	
	@BeforeClass(groups = { "Master", "Sanity", "Regression" })
	@Parameters("browser")
	public void setUp(String br) {
		logger = LogManager.getLogger(this.getClass());
		rb =ResourceBundle.getBundle("config");
		if(br.equalsIgnoreCase("chrome")) {
			ChromeOptions co = new ChromeOptions();
			co.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
			driver = new ChromeDriver(co);
		}else if(br.equalsIgnoreCase("edge")) {
			EdgeOptions eo = new EdgeOptions();
			eo.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
			driver = new EdgeDriver();
		}else if(br.equalsIgnoreCase("firefox")) {
			FirefoxOptions fo = new FirefoxOptions();
			fo.setCapability("excludeSwitches", new String[] {"enable-automation"});
			driver = new FirefoxDriver();
		}else {
			System.out.println("driver not found");
		}
		
		
		driver.get(rb.getString("appURL"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10, 1));
	}
	
	public String randomString() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return (generateString);
		}
	public String randomnum() {
		String generatenum = RandomStringUtils.randomNumeric(10);
		return (generatenum);
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	@AfterClass(groups = { "Master", "Sanity", "Regression" })
	public void tearDown() {
		driver.quit();
	}

}
