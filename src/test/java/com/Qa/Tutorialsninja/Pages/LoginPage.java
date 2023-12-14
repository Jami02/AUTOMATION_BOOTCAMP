package com.Qa.Tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	@FindBy(id = "input-email")
	private WebElement emailInput;

	@FindBy(id = "input-password")
	private WebElement passwordInput;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement loginButton;
	
	
	@FindBy(xpath = "//div[contains(@class,  'alert-dismissible')]")
	private WebElement noMatchForEMailAddressOrPasswordWarningMessage;
	
	@FindBy(linkText = "Forgotten Password")
	private WebElement forgotPasswordLink;

	
	
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}

	public void enterEmail(String email) {
		emailInput.sendKeys(email);

	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}
	
	public String retrieveNoMatchForEMailAddressOrPasswordWarningMessageText() {
		
		String warnigText = noMatchForEMailAddressOrPasswordWarningMessage.getText();
		return warnigText;
			
	}
	
	public void clickForgotPasswordLink() {
		forgotPasswordLink.click();
		
	}
	

}
