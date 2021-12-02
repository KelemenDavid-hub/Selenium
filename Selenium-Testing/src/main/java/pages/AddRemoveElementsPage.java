package pages;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AddRemoveElementsPage {

	private WebDriver driver;
	private By addElementButton = By.xpath("//div[@id='content']//button[.='Add Element']");

	public AddRemoveElementsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddElementButton(int numberOfTimes) {
		for (int i = 1; i <= numberOfTimes; i++) {
			driver.findElement(addElementButton).click();
		}
	}

	public void clickDeleteButton() {
		List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button.added-manually"));

		for (WebElement element : deleteButtons) {
			element.click();
			WebDriverWait wait = new WebDriverWait(driver, 1); //wait for 1 second to check if element is still there
			Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(element)), "Element is still visible");
			Reporter.log("Deleted removeButton", true);
		}
	}

}
