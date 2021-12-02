package tests;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;
import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HorizontalSliderPage;

public class HorizontalSliderTests extends BaseTest {

	@Test(groups = "end2end")
	public void sliderIncreaseTest() {
		setTimestamp("sliderIncreaseTest");
		HorizontalSliderPage sliderPage = homePage.clickHorizontalSliderPage("Horizontal Slider");
		Reporter.log("HorizontalSliderPage opened", true);
		sliderPage.clickOnSlider();
		double sliderValue = sliderPage.getSlideValue();
		sliderPage.increaseSlider(3);
		assertTrue("Arrow-Right not working or sliderValueBox is broken", sliderValue != sliderPage.getSlideValue());
		Reporter.log("Slider increase works correctly", true);
		Reporter.log("Test duration: " + getDurationInMillisFrom("sliderIncreaseTest") + " ms", true);

	}

	@Test(groups = "end2end")
	public void sliderDecreaseTest() {
		setTimestamp("sliderDecreaseTest");
		HorizontalSliderPage sliderPage = homePage.clickHorizontalSliderPage("Horizontal Slider");
		Reporter.log("HorizontalSliderPage opened", true);
		sliderPage.clickOnSlider();
		double sliderValue = sliderPage.getSlideValue();
		sliderPage.decreaseSlider(3);
		assertTrue("Arrow-Left not working or sliderValueBox is broken", sliderValue != sliderPage.getSlideValue());
		Reporter.log("Slider increase works correctly", true);
		Reporter.log("Test duration: " + getDurationInMillisFrom("sliderDecreaseTest") + " ms", true);

	}
}
