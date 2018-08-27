package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.AuthenticationPage;

public class MainPage {
	private static final By SIGN_IN = By.className("login");
	private static final By USER_DETAILS = By.className("account");
	private WebDriver driver;
	
	public MainPage(WebDriver driver) {
	      this.driver = driver;

	}
	
	public AuthenticationPage selectSignIn() {

	      driver.findElement(SIGN_IN).click();

	      return new AuthenticationPage(driver);
	}
	
	public String getUserDetails() {
		   return driver.findElement(USER_DETAILS).getText();
	}
	
    public ConfirmationPage clickUserDetails() {
    	driver.findElement(USER_DETAILS).click();
    	return new ConfirmationPage(driver);
    }
	
}
