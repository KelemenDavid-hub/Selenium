package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeoLocationPage {
	private WebDriver driver;

	private By latitudeText = By.id("lat-value");
	private By longitudeText = By.id("long-value");

	private By button = By.xpath("//div[@id='content']//button[.='Where am I?']");

	public GeoLocationPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLatitudeText() {
		return driver.findElement(latitudeText).getText();
	}

	public String getLongitudeText() {
		return driver.findElement(longitudeText).getText();
	}

	public void clickButton() {
		driver.findElement(button).click();
	}
}
