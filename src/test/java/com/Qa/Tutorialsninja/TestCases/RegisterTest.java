package com.Qa.Tutorialsninja.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Qa.Tutorialsninja.Pages.AccountSuccessPage;
import com.Qa.Tutorialsninja.Pages.LandingPage;
import com.Qa.Tutorialsninja.Pages.RegisterPage;
import com.Qa.Tutorialsninja.TestBase.TestBase;
import com.Qa.Tutorialsninja.Utilities.Utilities;

public class RegisterTest extends TestBase {

	public RegisterTest() throws Exception {
		super();

	}
	
	public WebDriver driver;

	@BeforeMethod
	public void registerSetup() {

		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickMyAccountDropdown();
		landingPage.selectRegisterOption();

	}

	@Test(priority = 1, groups="RegisterTest")
	public void verifyRegisterWithMandatoryDetails() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstname"));
		registerPage.enterLastName(dataProp.getProperty("lastname"));
		registerPage.enterEmail(Utilities.generateEmailWithDateTimeStamp());
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.confirmPassword(prop.getProperty("validPassword"));
		registerPage.clickPrivacyPolicyBox();
		registerPage.clickOnRegisterAccountButton();
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountSuccessPage.validateDisplayStatusOfAccountSuccessRegisterationMessage());

	}

	@Test(priority = 2, groups="RegisterTest")
	public void verifyRegisterWithAllDetails() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstname"));
		registerPage.enterLastName(dataProp.getProperty("lastname"));
		registerPage.enterEmail(Utilities.generateEmailWithDateTimeStamp());
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.confirmPassword(prop.getProperty("validPassword"));
		registerPage.selectNewsLetterRadioButton();
		registerPage.clickPrivacyPolicyBox();
		registerPage.clickOnRegisterAccountButton();
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountSuccessPage.validateDisplayStatusOfAccountSuccessRegisterationMessage());

	}

	@Test(priority = 3, groups="RegisterTest")
	public void verifyRegisterWithExistingEmail() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstname"));
		registerPage.enterLastName(dataProp.getProperty("lastname"));
		registerPage.enterEmail(prop.getProperty("validEmail"));
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.confirmPassword(prop.getProperty("validPassword"));
		registerPage.selectNewsLetterRadioButton();
		registerPage.clickPrivacyPolicyBox();
		registerPage.clickOnRegisterAccountButton();
		String actualWarningMessage = registerPage.retrieveTextofDuplicateEmail();
		String expectedMessage = dataProp.getProperty("emailExistWarningMessage ");
		Assert.assertTrue(actualWarningMessage.contains(expectedMessage));

	}

	@Test(priority = 4, groups="RegisterTest")
	public void verifyRegisterWithNoDetails() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickOnRegisterAccountButton();

		String actualPrivacyPolicyWarningMessage = registerPage.retrievePrivacyPolicyWarningMessage();
		String expectedPrivacyPolicyWarningMessage = dataProp.getProperty("policyWarningMessage");
		Assert.assertTrue(actualPrivacyPolicyWarningMessage.contains(expectedPrivacyPolicyWarningMessage));

		String actualFirstNameWarningMessage = registerPage.retrievefirstNameWarningMessage();
		String expectedFirstNameWarningMessage = dataProp.getProperty("firstNameWarningMessage");
		Assert.assertTrue(actualFirstNameWarningMessage.contains(expectedFirstNameWarningMessage));

		String actualLastNameWarningMessage = registerPage.retrievelastNameWarningMessage();
		String expectedLastNameWarningMessage = dataProp.getProperty("lastNameWarningMessage");
		Assert.assertTrue(actualLastNameWarningMessage.contains(expectedLastNameWarningMessage));

		String actualEmailWarningMessage = registerPage.retrieveEmailWarningMessage();
		String expectedEmailWarningMessage = dataProp.getProperty("emailWarningMessage");
		Assert.assertTrue(actualEmailWarningMessage.contains(expectedEmailWarningMessage));

		String actualTelephoneWarningMessage = registerPage.retrieveTelephoneWarningMessage();
		String expectedTelephoneWarningMessage = dataProp.getProperty("telephoneWarningMessage");
		Assert.assertTrue(actualTelephoneWarningMessage.contains(expectedTelephoneWarningMessage));

		String actualPasswordWarningMessage = registerPage.retrievePasswordWarningMessage();
		String expectedPasswordWarningMessage = dataProp.getProperty("passwordWarningMessage");
		Assert.assertTrue(actualPasswordWarningMessage.contains(expectedPasswordWarningMessage));

	}

	@AfterMethod
	public void tearDownn() {

		driver.quit();

	}

}
