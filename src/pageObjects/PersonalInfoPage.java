package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 
public class PersonalInfoPage {
   private static final By FIRST_NAME = By.id("firstname");
   private static final By LAST_NAME = By.id("lastname");
   private static final By PASSWORD = By.name("old_passwd");
   private static final By CONFIRM_BUTTON = By.name("submitIdentity");
   private static final By CONFIRM_MESSAGE = By.className("alert-success");
   private static final By HOME_BUTTON = By.className("icon-home");
   private WebDriver driver;
   
  

   public PersonalInfoPage(WebDriver driver) {
      this.driver = driver;
   };

  
   public void waitOnElement(By element) {
	   WebDriverWait wait = new WebDriverWait(driver, 5);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(element));
   }
   
   public void changeFirstName(String firstName) {
	   driver.findElement(FIRST_NAME).clear();
	   driver.findElement(FIRST_NAME).sendKeys(firstName);
   }
   
   public void changeLastName(String lastName) {
	   driver.findElement(LAST_NAME).clear();
	   driver.findElement(LAST_NAME).sendKeys(lastName);
   }
   
   public void enterCurrentPassword(String password) {
	   driver.findElement(PASSWORD).sendKeys(password);
   }
      
   public ConfirmationPage confirm() {

      driver.findElement(CONFIRM_BUTTON).click();

      return new ConfirmationPage(driver);

   }
   
   public String getUpdateConfirmationMessage() {
	   return driver.findElement(CONFIRM_MESSAGE).getText();
   }
   
   public MainPage moveToHome() {
		  driver.findElement(HOME_BUTTON).click();
		  
		  return new MainPage(driver);
	  }

}