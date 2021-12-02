package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
	private By formAuthenticationLink;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public AddRemoveElementsPage clickAddRemove(String formLink) {
		formAuthenticationLink = By.linkText(formLink);
		driver.findElement(formAuthenticationLink).click();
		return new AddRemoveElementsPage(driver);
	}

	public LoginPage clickFormAuthentication(String formLink) {
		formAuthenticationLink = By.linkText(formLink);
		driver.findElement(formAuthenticationLink).click();
		return new LoginPage(driver);

	}

	public ContextMenuPage clickContextMenuPage(String formLink) {
		formAuthenticationLink = By.linkText(formLink);
		driver.findElement(formAuthenticationLink).click();
		return new ContextMenuPage(driver);
	}

	public GeoLocationPage clickGeoLocationPage(String formLink) {
		formAuthenticationLink = By.linkText(formLink);
		driver.findElement(formAuthenticationLink).click();
		return new GeoLocationPage(driver);
	}

	public FramePage clickFramePage(String formLink) {
		formAuthenticationLink = By.linkText(formLink);
		driver.findElement(formAuthenticationLink).click();
		return new FramePage(driver);
	}
	
	public HorizontalSliderPage clickHorizontalSliderPage(String formLink) {
		formAuthenticationLink = By.linkText(formLink);
		driver.findElement(formAuthenticationLink).click();
		return new HorizontalSliderPage(driver);
	}
	
	public KeyPressesPage clickKeyPressesPage(String formLink) {
		formAuthenticationLink = By.linkText(formLink);
		driver.findElement(formAuthenticationLink).click();
		return new KeyPressesPage(driver);
	}
	
	public DynamicContentPage clickDynamicContentPage(String formLink) {
		formAuthenticationLink = By.linkText(formLink);
		driver.findElement(formAuthenticationLink).click();
		return new DynamicContentPage(driver);
	}

}
