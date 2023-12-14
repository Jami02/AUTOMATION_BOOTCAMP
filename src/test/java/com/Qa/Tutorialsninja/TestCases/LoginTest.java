package com.Qa.Tutorialsninja.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Qa.Tutorialsninja.Pages.AccountPage;
import com.Qa.Tutorialsninja.Pages.LandingPage;
import com.Qa.Tutorialsninja.Pages.LoginPage;
import com.Qa.Tutorialsninja.TestBase.TestBase;
import com.Qa.Tutorialsninja.Utilities.Utilities;

public class LoginTest extends TestBase {

	public LoginTest() throws Exception {
		super();

	}

	public WebDriver driver;

	@BeforeMethod
	public void setUpForLogin() {

		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickMyAccountDropdown();
		landingPage.selectLoginOption();

	}

	@Test(priority = 1, groups="login")
	public void verifyLoginWithValidEmailAndPassowrd() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickLoginButton();
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationLink());

	}

	@Test(priority = 2, groups="login")
	public void verifyLoginWithValidEmailAndInvalidPassword() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickLoginButton();

		String actualWarningMessage = loginPage.retrieveNoMatchForEMailAddressOrPasswordWarningMessageText();
		String expectedWarningMessage = dataProp.getProperty("loginWarningMessage");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));

	}

	@Test(priority = 3, groups="login")
	public void verifyLoginWithInvalidEmailAndValidPassword() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(Utilities.generateEmailWithDateTimeStamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickLoginButton();

		String actualWarningMessage = loginPage.retrieveNoMatchForEMailAddressOrPasswordWarningMessageText();
		String expectedWarningMessage = dataProp.getProperty("loginWarningMessage");

		if (actualWarningMessage.equals(expectedWarningMessage)) {
			System.out.println("Test Passed: Warning message is correct.");

		} else {

			System.out.println("Test Failed: Warning message is incorrect.");
			System.out.println("Expected: " + expectedWarningMessage);
			System.out.println("Actual: " + actualWarningMessage);

		}

	}

	@Test(priority = 4, groups="login")
	public void verifyLoginWithInvalidEmailAndInvalidPassword() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(Utilities.generateEmailWithDateTimeStamp());
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickLoginButton();

		String actualWarningMessage = loginPage.retrieveNoMatchForEMailAddressOrPasswordWarningMessageText();
		String expectedWarningMessage = dataProp.getProperty("loginWarningMessage");

		if (actualWarningMessage.equals(expectedWarningMessage)) {
			System.out.println("Test Passed: Warning message is correct.");

		} else {

			System.out.println("Test Failed: Warning message is incorrect.");
			System.out.println("Expected: " + expectedWarningMessage);
			System.out.println("Actual: " + actualWarningMessage);

		}
	}

	@Test(priority = 5, groups="login")
	public void verifyLoginWithValidEmailAndClickLoginButton() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(prop.getProperty("validEmail"));

		String actualWarningMessage = loginPage.retrieveNoMatchForEMailAddressOrPasswordWarningMessageText();
		String expectedWarningMessage = dataProp.getProperty("loginWarningMessage");

		if (actualWarningMessage.equals(expectedWarningMessage)) {
			System.out.println("Test Passed: Warning message is correct.");

		} else {

			System.out.println("Test Failed: Warning message is incorrect.");
			System.out.println("Expected: " + expectedWarningMessage);
			System.out.println("Actual: " + actualWarningMessage);

		}

	}

	@Test(priority = 6, groups="login")
	public void verifyLoginWithValidPasswordAndClickLoginButton() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickLoginButton();

		String actualWarningMessage = loginPage.retrieveNoMatchForEMailAddressOrPasswordWarningMessageText();
		String expectedWarningMessage = dataProp.getProperty("loginWarningMessage");

		if (actualWarningMessage.equals(expectedWarningMessage)) {
			System.out.println("Test Passed: Warning message is correct.");

		} else {

			System.out.println("Test Failed: Warning message is incorrect.");
			System.out.println("Expected: " + expectedWarningMessage);
			System.out.println("Actual: " + actualWarningMessage);

		}

	}

	@Test(priority = 7, groups="login")
	public void verifyLoginWithNoCredentialsAndClickLoginButton() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginButton();
		String actualWarningMessage = loginPage.retrieveNoMatchForEMailAddressOrPasswordWarningMessageText();
		String expectedWarningMessage = dataProp.getProperty("loginWarningMessage");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}


