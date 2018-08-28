package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

 
public class PersonalDetails {

   private static final By CUSTOMER_FIRST_NAME = By.id("customer_firstname");	
   private static final By CUSTOMER_LAST_NAME = By.id("customer_lastname");
   private static final By EMAIL = By.name("email");
   private static final By PASSWORD = By.name("passwd");
   private static final By FIRST_NAME = By.id("firstname");
   private static final By LAST_NAME = By.id("lastname");
   private static final By COMPANY = By.id("company");
   private static final By FIRST_ADDRESS = By.name("address1");
   private static final By SECOND_ADDRESS = By.name("address2");
   private static final By CITY = By.name("city");
   private static final By POSTAL_CODE = By.name("postcode");
   private static final By STATE = By.id("id_state");
   private static final By COUNTRY = By.id("id_country");
   private static final By ADDITIONAL_DETAILS = By.id("other");
   private static final By HOME_PHONE = By.name("phone");
   private static final By MOBILE_PHONE = By.name("phone_mobile");
   private static final By ALIAS = By.name("alias");
   private static final By REGISTER_BUTTON = By.id("submitAccount");
   private WebDriver driver;
  

   public PersonalDetails(WebDriver driver) {
      this.driver = driver;
   };

 
   
   public void enterRequiredPersonalDetails(String firstName, String lastName, String password, String address, String city,
		   String state, String country, String postalCode, String mobilePhone, String alias) {
	  
	 
	   this.waitOnElement(CUSTOMER_FIRST_NAME);
	   this.enterCustomerFirstName(firstName);
	   this.enterCustomerLastName(lastName);
	   this.enterPassword(password);
	   this.enterAddress(address);
	   this.enterCity(city);
	   this.enterState(state);
	   this.enterCountry(country);
	   this.enterPostalCode(postalCode);
	   this.enterMobilePhone(mobilePhone);
	   this.enterAlias(alias);   
   }
   
   public void waitOnElement(By element) {
	   WebDriverWait wait = new WebDriverWait(driver, 5);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(element));
   }
   
   public void enterCustomerFirstName(String firstName) {
	   driver.findElement(CUSTOMER_FIRST_NAME).sendKeys(firstName);
	   
	   //WebElement webElement = driver.findElement(By.id("customer_firstname"));
	   //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
   }
   
   public void enterCustomerLastName(String lastName) {
	   driver.findElement(CUSTOMER_LAST_NAME).sendKeys(lastName);
   }
   
   public void enterPassword(String password) {
	   driver.findElement(PASSWORD).sendKeys(password);
   }
   
   public void enterAddress(String address) {
	   driver.findElement(FIRST_ADDRESS).sendKeys(address);
   }
   
   public void enterCity(String city) {
	   driver.findElement(CITY).sendKeys(city);
   }
   
   public void enterState(String state) {
	   Select dropdown = new Select(driver.findElement(STATE));
	   dropdown.selectByVisibleText(state);
   }

   public void enterCountry(String country) {
	   Select dropdown = new Select(driver.findElement(COUNTRY));
	   dropdown.selectByVisibleText(country);
   }
   
   public void enterPostalCode(String code) {
	   driver.findElement(POSTAL_CODE).sendKeys(code);
   }
 
   public void enterMobilePhone(String mobilePhone) {
	   driver.findElement(MOBILE_PHONE).sendKeys(mobilePhone);
   }
   
   public void enterAlias(String alias) {
	   driver.findElement(ALIAS).sendKeys(alias);
   }
 
   
   public ConfirmationPage register() {

      driver.findElement(REGISTER_BUTTON).click();

      return new ConfirmationPage(driver);

   }

}

