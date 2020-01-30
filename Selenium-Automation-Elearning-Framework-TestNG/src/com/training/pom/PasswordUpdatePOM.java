package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordUpdatePOM {
private WebDriver driver; 
	
	public PasswordUpdatePOM(WebDriver driver) {
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
	
	@FindBy(name="confirm")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitBtn; 
	
	@FindBy(xpath="//a[contains(text(),'Change your password')]")
	private WebElement changePassword;
	
	@FindBy(xpath="//div[contains(text(),'Success: Your password has been successfully updated.')]")
	private WebElement passwordConfirmation;
	
	@FindBy(xpath="//div[@class='text-danger']")
	private WebElement passwordDoesnotMatch;
	
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
	
	public void confirmPassword(String confirmPassword) {
		this.confirmPassword.clear(); 
		this.confirmPassword.sendKeys(confirmPassword); 
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickSubmitBtn() {
		this.submitBtn.click(); 
	}
	
	public void ClickChangePassword() {
		this.changePassword.click(); 
	}
	
	public String PasswordConfirmation() {
		this.passwordConfirmation.getText(); 
		return passwordConfirmation.getText(); 
	}
		
	public String PasswordDoesnotMatch() {
		this.passwordDoesnotMatch.getText(); 
		return passwordDoesnotMatch.getText();
	}
}
