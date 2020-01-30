package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.PasswordUpdatePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PasswordMisMatchTest {
	private WebDriver driver;
	private String baseUrl;
	private PasswordUpdatePOM passwordUpdatePOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String doesNotMatch;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		passwordUpdatePOM = new PasswordUpdatePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	/*@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}*/
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void PasswordMismatch() {
		passwordUpdatePOM.clickMyAccountBtn();
		passwordUpdatePOM.clickLoginBtn();
		passwordUpdatePOM.sendEmail("bathini.ushasrireddy@gmail.com");
		passwordUpdatePOM.sendPassword("Usha@123");
		passwordUpdatePOM.clickSubmitBtn();
		passwordUpdatePOM.ClickChangePassword();
		passwordUpdatePOM.sendPassword("Usha@123");
		passwordUpdatePOM.confirmPassword("Usha@505");
		passwordUpdatePOM.clickSubmitBtn();
		doesNotMatch=passwordUpdatePOM.PasswordDoesnotMatch();
		Assert.assertEquals("Password confirmation does not match password!",doesNotMatch);
		 
		//screenShot.captureScreenShot("First");
	}
}
