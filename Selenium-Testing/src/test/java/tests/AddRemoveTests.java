package tests;

import static org.testng.Assert.assertTrue;
import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddRemoveElementsPage;

public class AddRemoveTests extends BaseTest {

	@Test(groups = "end2end", priority = 1)
	
	public void testAddRemove1() {

		setTimestamp("testAddRemove1");
		AddRemoveElementsPage page = homePage.clickAddRemove("Add/Remove Elements");
		page.clickAddElementButton(10);
		page.clickDeleteButton();

		Reporter.log("Test duration: " + getDurationInMillisFrom("testAddRemove1") + " ms", true);
		long maxDuration = 2000L;
		assertTrue(maxDuration >= getDurationInMillisFrom("testAddRemove1"), "Exceeded maximum time duration");
	}

	@Test(groups = "end2end", priority = 2)
	
	public void testAddRemove2() {  //Exceeding maximum time duration

		setTimestamp("testAddRemove2");
		AddRemoveElementsPage page = homePage.clickAddRemove("Add/Remove Elements");
		page.clickAddElementButton(10);
		page.clickDeleteButton();

		Reporter.log("Test duration: " + getDurationInMillisFrom("testAddRemove2") + " ms", true);
		long maxDuration = 500L;
		assertTrue(maxDuration >= getDurationInMillisFrom("testAddRemove2"), "Exceeded maximum time duration");
	}

}
