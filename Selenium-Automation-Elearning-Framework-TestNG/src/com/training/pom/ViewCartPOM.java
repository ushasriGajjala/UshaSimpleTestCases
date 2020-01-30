package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ViewCartPOM {
private WebDriver driver; 
	
	public ViewCartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement myAccount; 
	
	@FindBy(linkText="Login")
	private WebElement loginBtn; 
	
	@FindBy(name="email")
	private WebElement email; 
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitBtn; 
	
	@FindBy(xpath="//a[contains(text(),'Uniform Store')]")
	private WebElement uniformStore; 
	
	@FindBy(xpath="//img[@alt='banner1']")
	private WebElement shopUniforms; 
	
	@FindBy(xpath="//div[@class='image']//img[@title='REGULAR T-SHIRTS (YELLOW)']")
	private WebElement yellowTShirt; 
	
	@FindBy(css="#input-option382")
	private WebElement chestSize; 
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement addToCart; 
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement success; 
	
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	private WebElement cart;
	
	@FindBy(xpath="//*[@id='cart']/ul/li[2]/div/p/a[1]/strong/text()")
	private WebElement viewcart;                  
	
	@FindBy(xpath="//button[@onclick='cart.remove('6550');']")
	private WebElement removecart;
	
	public void clickMyAccountBtn() {
		this.myAccount.click(); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickSubmitBtn() {
		this.submitBtn.click(); 
	}
	
	public void clickUniformStore()
	{
		this.uniformStore.click();
	}
	
	public void clickShopUniforms()
	{
		this.shopUniforms.click();
	}
	
	public void clickYellowTShirt()
	{
		this.yellowTShirt.click();
	}
	
	public void selectChestSize()
	{
		this.chestSize.click();
		Select dropdown=new Select(chestSize);
		dropdown.selectByIndex(3);
	}
	
	public void clickAddToCart()
	{
		this.addToCart.click();
	}
	
	public String successText()
	{
		this.success.getText(); 
		return success.getText().replaceAll("×"," ").replace('\n',' ').trim(); 
	}
	public void clickCart()
	{
		this.cart.click();
	}
	
	public void viewCart()
	{
		this.viewcart.click();
	}
	
	public void removeCart()
	{
		this.removecart.click();
	}
	
}
