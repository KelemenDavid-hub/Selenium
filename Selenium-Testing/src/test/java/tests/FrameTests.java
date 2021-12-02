package tests;

import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import base.BaseTest;
import pages.FramePage;
import pages.IFramePage;
import pages.NestedFramesPage;

public class FrameTests extends BaseTest {

	@Test(groups = "end2end", priority = 2)
	public void testNestedFrames() {
		setTimestamp("testnestedFrames");
		FramePage framePage = homePage.clickFramePage("Frames");

		NestedFramesPage nestedFramesPage = framePage.clickNestedFrames();
		Reporter.log("NestedFramesPage opened", true);

		
		driver.switchTo().frame("frame-top").switchTo().frame("frame-middle");  //switching from parent frame to child frame
		assertTrue(nestedFramesPage.getIdentifierText().contains("MIDDLE"));
		driver.switchTo().defaultContent();

	}

	@Test(groups = "end2end", priority = 1)
	@Parameters({ "message" })
	public void testIFrame(String message) {
		setTimestamp("testIFrame");
		FramePage framePage = homePage.clickFramePage("Frames");

		IFramePage iFramePage = framePage.clickIFrame();
		Reporter.log("IFramePage opened", true);
		WebDriverWait wait = new WebDriverWait(driver, 3);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));
		iFramePage.clearTextArea();
		driver.switchTo().defaultContent(); // without switching back and forth, the custom message pasted won't be bold
											// -> bold button is not part of the IFrame
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Bold']")));
		iFramePage.clickBoldButton();
		driver.switchTo().frame("mce_0_ifr");
		iFramePage.writeToTextArea(message);
		driver.switchTo().defaultContent();
		assertTrue(iFramePage.getStatusAlert().contains("An iFrame containing the TinyMCE WYSIWYG Editor"));

		Reporter.log("Test duration: " + getDurationInMillisFrom("testIFrame") + " ms", true);
	}
}
