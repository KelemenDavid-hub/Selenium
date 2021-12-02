package tests;

import static org.junit.Assert.assertTrue;
import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DynamicContentPage;

public class DynamicContentTests extends BaseTest {

	@Test
	public void dynamicContentTest() {
		setTimestamp("dynamicContentTest");
		DynamicContentPage dynamicPage = homePage.clickDynamicContentPage("Dynamic Content");
		Reporter.log("DynamicContentPage opened", true);
		String verificationString = dynamicPage.getTextMessage().substring(0, 15);
		dynamicPage.clickHere();
		Reporter.log("Content changed",true);
		assertTrue(verificationString.contentEquals(dynamicPage.getTextMessage().substring(0, 15)) == false);
		Reporter.log("Test duration: " + getDurationInMillisFrom("dynamicContentTest") + " ms", true);
	}
}
