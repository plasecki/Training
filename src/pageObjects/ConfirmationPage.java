package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.AuthenticationPage;
import pageObjects.PersonalInfoPage;

public class ConfirmationPage {
	private static final By WELCOME_TEXT = By.className("info-account");
	private static final By PERSONAL_INFO_BUTTON = By.className("icon-user");
	private static final By SIGN_OUT = By.className("logout");
	
	private WebDriver driver;
	
	  public ConfirmationPage(WebDriver driver) {
	      this.driver = driver;

	   }
	
	public String getWelcomeText() {

	   return driver.findElement(WELCOME_TEXT).getText();
	}
	
	public PersonalInfoPage moveToMyPersonalInfo() {
		driver.findElement(PERSONAL_INFO_BUTTON).click();
		
		return new PersonalInfoPage(driver);
		
	}

	public AuthenticationPage signOut() {
		driver.findElement(SIGN_OUT).click();
		
		return new AuthenticationPage(driver);
		
	}
}
