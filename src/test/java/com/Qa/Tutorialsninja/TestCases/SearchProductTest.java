package com.Qa.Tutorialsninja.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Qa.Tutorialsninja.Pages.LandingPage;
import com.Qa.Tutorialsninja.Pages.SearchPage;
import com.Qa.Tutorialsninja.TestBase.TestBase;

public class SearchProductTest extends TestBase {

	public SearchProductTest() throws Exception {
		super();

	}

	public WebDriver driver;

	@BeforeMethod
	public void searchProductSetup() {

		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));

	}

	@Test(priority = 1, groups = "SearchProductTest")
	public void testSearchValidProduct() {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.enterProductDetailsInSearchBoxField(dataProp.getProperty("validProduct"));
		landingPage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		Assert.assertTrue(searchPage.displayValidProductStatus());

	}

	@Test(priority = 5, groups = "SearchProductTest")
	public void testSearchInvalidProduct() {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.enterProductDetailsInSearchBoxField(dataProp.getProperty("invalidProduct"));
		landingPage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		searchPage.displayInvalidOrNoProductStatus();
		Assert.assertTrue(searchPage.displayInvalidOrNoProductStatus());

	}

	@Test(priority = 3, groups = "SearchProductTest")
	public void testSearchNoProduct() {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		Assert.assertTrue(searchPage.displayInvalidOrNoProductStatus());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
