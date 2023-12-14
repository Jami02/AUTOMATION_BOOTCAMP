package com.Qa.Tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	private WebDriver driver;

	// WebElement locators using @FindBy annotations
	@FindBy(id = "input-firstname")
	private WebElement firstNameInput;

	@FindBy(id = "input-lastname")
	private WebElement lastNameInput;

	@FindBy(id = "input-email")
	private WebElement emailInput;

	@FindBy(id = "input-telephone")
	private WebElement telephoneInput;

	@FindBy(id = "input-password")
	private WebElement passwordInput;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordInput;

	@FindBy(xpath = "//input[@name = 'agree']")
	private WebElement privacyPolicyCheckBox;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement registerAccountButton;

	@FindBy(xpath = "//input[@name = 'newsletter' and @value= '1']")
	private WebElement newsLetterRadioButton;

	@FindBy(xpath = "//div[@class = 'alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailWarningMessage;

	@FindBy(xpath = "//div[@class = 'alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarningMessage;
	
	
	

	@FindBy(xpath = "//div[text() = 'First Name must be between 1 and 32 characters!']")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath = "//div[text() = 'Last Name must be between 1 and 32 characters!']")
	private WebElement lastNameWarningMessage;

	@FindBy(xpath = "//div[text() = 'E-Mail Address does not appear to be valid!']")
	private WebElement emailWarningMessage;

	@FindBy(xpath = "//div[text() = 'Telephone must be between 3 and 32 characters!']")
	private WebElement telephoneWarningMessage;

	@FindBy(xpath = "//div[text() = 'Password must be between 4 and 20 characters!']")
	private WebElement passwordWarningMessage;
	
	
	
	

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
	}

	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void enterTelephone(String telephone) {
		telephoneInput.sendKeys(telephone);

	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void confirmPassword(String confirmPassword) {
		confirmPasswordInput.sendKeys(confirmPassword);
	}

	public void clickPrivacyPolicyBox() {
		privacyPolicyCheckBox.click();
	}

	public void clickOnRegisterAccountButton() {
		registerAccountButton.click();

	}

	public void selectNewsLetterRadioButton() {

		newsLetterRadioButton.click();
	}

	public String retrieveTextofDuplicateEmail() {
		String duplicateEmail = duplicateEmailWarningMessage.getText();
		return duplicateEmail;
	}

	public String retrievePrivacyPolicyWarningMessage() {
		String privacyPolicyWarning = privacyPolicyWarningMessage.getText();
		return privacyPolicyWarning;
	}

	public String retrievefirstNameWarningMessage() {
		String firstnameWarning = firstNameWarningMessage.getText();
		return firstnameWarning;
	}

	public String retrievelastNameWarningMessage() {
		String lastnameWarning = lastNameWarningMessage.getText();
		return lastnameWarning;
	}

	public String retrieveEmailWarningMessage() {
		String emailWarning = emailWarningMessage.getText();
		return emailWarning;
	}

	public String retrieveTelephoneWarningMessage() {
		String telephoneWarning = telephoneWarningMessage.getText();
		return telephoneWarning;
	}

	public String retrievePasswordWarningMessage() {
		String passwordWarning = passwordWarningMessage.getText();
		return passwordWarning;
	}

}



