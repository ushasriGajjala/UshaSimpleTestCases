package com.training.sanity.tests;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.PasswordUpdatePOM;
import com.training.pom.ViewCartPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ViewCartTest {
	private WebDriver driver;
	private String baseUrl;
	private ViewCartPOM viewCartPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String Expected,Actual;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		viewCartPOM = new ViewCartPOM(driver); 
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
		Thread.sleep(5000);
		driver.quit();
	}
	@Test
	public void viewCart() {
		viewCartPOM.clickMyAccountBtn();
		viewCartPOM.clickLoginBtn();
		viewCartPOM.sendEmail("bathini.ushasrireddy@gmail.com");
		viewCartPOM.sendPassword("Usha@123");
		viewCartPOM.clickSubmitBtn();
		viewCartPOM.clickUniformStore();
		viewCartPOM.clickShopUniforms(); 
		viewCartPOM.clickYellowTShirt();
		viewCartPOM.selectChestSize();
		viewCartPOM.clickAddToCart();
		Expected="Success: You have added REGULAR T-SHIRTS (YELLOW) to your shopping cart!";
		Actual=viewCartPOM.successText();
		System.out.println(Actual);
		Assert.assertEquals(Expected,Actual);
		viewCartPOM.clickCart();
		System.out.println("usha");
		WebElement Webelement=driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']"));
		Actions act=new Actions(driver);
		act.moveToElement(Webelement);
		//driver.findElement(By.xpath("//nav[@id='top']//tr[1]//td[2]//a[1]")).click();
		//viewCartPOM.viewCart();
		viewCartPOM.removeCart();
		System.out.println("sri");
		//screenShot.captureScreenShot("First");
	}
}
