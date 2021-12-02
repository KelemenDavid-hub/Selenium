package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage {

	private WebDriver driver;
	private By slider = By.xpath("//input[@type=\"range\"]");
	private By slideValue = By.id("range");
	

	public HorizontalSliderPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnSlider() {
		driver.findElement(slider).click();
	}
	
	public double getSlideValue() {
		return Double.parseDouble(driver.findElement(slideValue).getText());
	}

	public void increaseSlider(int numOfTimes) {
		for(int i=0 ; i<numOfTimes ; i++) {
		driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
	}
	}
	
	public void decreaseSlider(int numOfTimes) {
		for(int i=0 ; i<numOfTimes ; i++) {
		driver.findElement(slider).sendKeys(Keys.ARROW_LEFT);
	}
	}
}
