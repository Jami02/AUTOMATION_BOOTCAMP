package com.Qa.Tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

public WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validProduct;
	
	@FindBy(xpath = "//p[text() = 'There is no product that matches the search criteria.']")
	private WebElement noProductAvailableDisplayMessage;
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayValidProductStatus() {
		boolean displayStatus = validProduct.isDisplayed();
		return displayStatus;
	}
	
	public boolean displayInvalidOrNoProductStatus() {
		boolean displayStatus = noProductAvailableDisplayMessage.isDisplayed();
		return displayStatus;
	}

	}

