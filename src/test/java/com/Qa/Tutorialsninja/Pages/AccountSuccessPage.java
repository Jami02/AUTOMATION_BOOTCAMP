package com.Qa.Tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
	public WebDriver driver;

	@FindBy(xpath = "//p[text() = 'Congratulations! Your new account has been successfully created!']")
	private WebElement accountSuccessRegisterationMessage;

	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateDisplayStatusOfAccountSuccessRegisterationMessage() {
		boolean statusDisplay = accountSuccessRegisterationMessage.isDisplayed();
		return statusDisplay;

	}

}
