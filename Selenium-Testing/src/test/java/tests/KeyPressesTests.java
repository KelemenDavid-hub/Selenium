package tests;

import static org.junit.Assert.assertTrue;
import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HorizontalSliderPage;
import pages.KeyPressesPage;

public class KeyPressesTests extends BaseTest {

	@Test(groups = "end2end")
	public void enteringKeyToTextBoxTest() {
		setTimestamp("enteringKeyToTextBoxTest");
		KeyPressesPage keyPressPage = homePage.clickKeyPressesPage("Key Presses");
		Reporter.log("KeyPressesPage opened", true);
		String verificationString = keyPressPage.enterCharacter("a");
		assertTrue(keyPressPage.getResult().contains(verificationString.toUpperCase()));
		Reporter.log("Test duration: " + getDurationInMillisFrom("enteringKeyToTextBoxTest") + " ms", true);

	}
	
	@Test(groups = "end2end")
	public void pressingDeleteTest() {
		setTimestamp("enteringKeyToTextBoxTest");
		KeyPressesPage keyPressPage = homePage.clickKeyPressesPage("Key Presses");
		Reporter.log("KeyPressesPage opened", true);
		String verificationString = keyPressPage.pressDeleteKey();
		assertTrue(keyPressPage.getResult().contains(verificationString));
		Reporter.log("Test duration: " + getDurationInMillisFrom("enteringKeyToTextBoxTest") + " ms", true);

	}

}
