package com.Qa.Tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;

	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown;

	@FindBy(linkText = "Login")
	private WebElement selectLoginOption;

	@FindBy(linkText = "Register")
	private WebElement selectRegisterOption;
	
	
	
	
	@FindBy(xpath = "//input[@name = 'search']")
	private WebElement searchBoxField;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	
	
	
	

	public LandingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMyAccountDropdown() {
		myAccountDropdown.click();

	}

	public void selectLoginOption() {
		selectLoginOption.click();

	}

	public void selectRegisterOption() {
		selectRegisterOption.click();

	}
	
	public void enterProductDetailsInSearchBoxField(String productText) {
		
		searchBoxField.sendKeys(productText);
		
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
		
	}
	
	


}
