package tests;

import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.GeoLocationPage;

public class GeoLocationTests extends BaseTest {

	@Test(groups = "end2end", priority = 1)
	
	public void testGeoLocationTests1() {

		setTimestamp("testGeoLocationTests1");
		GeoLocationPage geoPage = homePage.clickGeoLocationPage("Geolocation");

		geoPage.clickButton();
		Reporter.log("Button clicked!",true);
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lat-value")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("long-value")));

		Assert.assertTrue("Maybe you are not from Romania!",(geoPage.getLongitudeText().contains("23.")) ? true : (geoPage.getLatitudeText().contains("46.")));

		Reporter.log("Test duration: " + getDurationInMillisFrom("testGeoLocationTests1") + " ms", true);

	}
	

	@Test(groups = "end2end", priority = 2)
	
	public void testGeoLocationTests2() { //test will fail because of the absence of locators 

		setTimestamp("testGeoLocationTests2");
		GeoLocationPage geoPage = homePage.clickGeoLocationPage("Geolocation");

		geoPage.clickButton();
		Reporter.log("Button clicked!",true);
		Assert.assertTrue("Maybe you are not from Romania!",(geoPage.getLongitudeText().contains("23.")) ? true : (geoPage.getLatitudeText().contains("46.")));
		Reporter.log("Test duration: " + getDurationInMillisFrom("testGeoLocationTests2") + " ms", true);
	}
	
	@Test(groups = "end2end", priority = 3)
	
	public void testGeoLocationTests3() { //test will fail because of incorrect data in the contains() method

		setTimestamp("testGeoLocationTests3");
		GeoLocationPage geoPage = homePage.clickGeoLocationPage("Geolocation");

		geoPage.clickButton();
		Reporter.log("Button clicked!",true);
		Assert.assertTrue("Maybe you are not from Romania!",(geoPage.getLongitudeText().contains("abcd.")) ? true : (geoPage.getLatitudeText().contains("xyz.")));
		Reporter.log("Test duration: " + getDurationInMillisFrom("testGeoLocationTests3") + " ms", true);
	}

}
