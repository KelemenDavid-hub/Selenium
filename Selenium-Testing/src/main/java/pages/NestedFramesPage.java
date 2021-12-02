package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
	private WebDriver driver;
	private By identifier = By.xpath("//div[@id='content']");
	
	public NestedFramesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getIdentifierText() {
		return driver.findElement(identifier).getText();
	}
}
