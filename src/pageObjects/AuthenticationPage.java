package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.PersonalDetails;
import pageObjects.ConfirmationPage;


public class AuthenticationPage {
	private static final By CREATE_ACCOUNT_EMAIL = By.name("email_create");
	private static final By CREATE_ACCOUNT_BUTTON = By.name("SubmitCreate");
	private static final By SIGN_IN_EMAIL_FIELD = By.name("email");
	private static final By SIGN_IN_PASSWORD = By.name("passwd");
	private static final By SIGN_IN_BUTTON = By.id("SubmitLogin");
	private static final By HOME_BUTTON = By.className("icon-home");
	
	private WebDriver driver;
	
	public AuthenticationPage(WebDriver driver) {
	      this.driver = driver;

	   }
	
	public PersonalDetails createAccount(String email) {

	      driver.findElement(CREATE_ACCOUNT_EMAIL).sendKeys(email);
	      driver.findElement(CREATE_ACCOUNT_BUTTON).click();
	      

	      return new PersonalDetails(driver);
	  }
	
	  public ConfirmationPage signIn(String email, String password) {

	      driver.findElement(SIGN_IN_EMAIL_FIELD).sendKeys(email);
	      driver.findElement(SIGN_IN_PASSWORD).sendKeys(password);
	      driver.findElement(SIGN_IN_BUTTON).click();
	      

	      return new ConfirmationPage(driver);
	  }
	  
	  public MainPage moveToHome() {
		  driver.findElement(HOME_BUTTON).click();
		  
		  return new MainPage(driver);
	  }

}
