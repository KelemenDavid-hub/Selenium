package tests;

import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContextMenuPage;

public class ContextMenuTests extends BaseTest {

	@Test(groups = "end2end", priority = 1)

	public void testContextMenuTests1() {

		setTimestamp("testContextMenuTests1");
		ContextMenuPage page = homePage.clickContextMenuPage("Context Menu");

		page.boxRightClick();
		Reporter.log("Box right clicked...", true);
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains("You selected a context menu"));
		alert.accept();
		Reporter.log("Alert accepted!", true);
		Reporter.log("Test duration: " + getDurationInMillisFrom("testContextMenuTests1") + " ms", true);

	}

	@Test(groups = "end2end", priority = 2)
	
	public void testContextMenuTests2() { // its going to fail

		setTimestamp("testContextMenuTests2");
		ContextMenuPage page = homePage.clickContextMenuPage("Context Menu");

		page.boxLeftClick();
		Reporter.log("Box left clicked...", true);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());

	}

}
