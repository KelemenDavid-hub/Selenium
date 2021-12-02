package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePage {
	
	private WebDriver driver;
	private By boldButton = By.xpath("//*[@title='Bold']");
	private By textArea = By.id("tinymce");
	private By statusAlert = By.id("content");
	
	public IFramePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickBoldButton() {
		
		driver.findElement(boldButton).click();
	}
	
	public void writeToTextArea(String text) {
		  
		driver.findElement(textArea).sendKeys(text);
	}
	
	public void clearTextArea() {
		driver.findElement(textArea).clear();
	}
	
	public String getStatusAlert() {
		return driver.findElement(statusAlert).getText();
	}
	

}
