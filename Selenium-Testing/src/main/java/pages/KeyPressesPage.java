package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyPressesPage {
	private WebDriver driver;
	private By textBox = By.id("target");
	private By resultBox = By.id("result");
	
	public KeyPressesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getResult() {
		return driver.findElement(resultBox).getText();
	}
	
	public String enterCharacter(String character) {
		driver.findElement(textBox).sendKeys(character);
		return character;
	}
	
	public String pressDeleteKey() {
		 driver.findElement(textBox).sendKeys(Keys.DELETE);
		return "DELETE";
	}
}
