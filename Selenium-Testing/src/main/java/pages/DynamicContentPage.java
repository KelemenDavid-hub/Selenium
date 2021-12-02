package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicContentPage {
	
	private WebDriver driver;
	private By textMessage = By.xpath("/html//div[@id='content']/div/div[@class='row']/div[@id='content']/div[3]/div[2]");
	private By linkText = By.linkText("click here");
	public DynamicContentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickHere() {
		
		driver.findElement(linkText).click();
	}
	
	public String getTextMessage() {
		return driver.findElement(textMessage).getText();
	}

}
