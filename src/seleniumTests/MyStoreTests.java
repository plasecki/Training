package seleniumTests;
 
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import infrastructure.SeleniumInfrastructure;
import pageObjects.MainPage;
import pageObjects.PersonalDetails;
import pageObjects.AuthenticationPage;
import pageObjects.ConfirmationPage;
import pageObjects.PersonalInfoPage;
import infrastructure.RandomGenerator;
import infrastructure.Dictionary;
 
public class MyStoreTests {
	private static WebDriver driver;
	private Dictionary dict;
	

	@Before 
	public void before() throws Exception {
	  dict = new Dictionary();

	  SeleniumInfrastructure myStore = new SeleniumInfrastructure();
	  driver = myStore.launchBrowser();
	  
	  System.out.println("url:" + dict.getValueForKey("URL"));
	  myStore.openUrl(dict.getValueForKey("URL"));
	}


	
	@Test
	public void CreateNewAccount()
	{   
		RandomGenerator randomInt = new RandomGenerator();
		String firstName = "Piotr";
		String lastName = "Lasecki";
		String email = randomInt.returnRandomNumber() + "@gmail.com"; 
		String password = "Katarzyna1";
		String address = "Krakowska Street";
		String city = "Krakow";
		String state = "New York";
		String country = "United States";
		String postalCode = "00000";
		String mobilePhone = "664332111";
		String alias = "My account";
		
		String welcome = dict.getValueForKey("WELCOME_MESSAGE");
		System.out.println("Email used for registration:" + email);
					
		MainPage main = new MainPage(driver);
		AuthenticationPage authentication = main.selectSignIn();
		PersonalDetails personalDetails = authentication.createAccount(email);
		personalDetails.enterRequiredPersonalDetails(firstName, lastName, password, 
				address, city, state, country, postalCode, mobilePhone, alias);
		ConfirmationPage confirmationPage = personalDetails.register();
		assertEquals(confirmationPage.getWelcomeText(), welcome);
		authentication = confirmationPage.signOut();
		main = authentication.moveToHome();
	} 
	
	@Test
	public void LoginAndAuthorise()
	{   	
		String welcome = dict.getValueForKey("WELCOME_MESSAGE");			
		String emailToSignIn = dict.getValueForKey("EMAIL");
		String passwordToSignIn = dict.getValueForKey("PASSWORD");
		
		ConfirmationPage confirmationPage = this.BasicSignIn();
		
		AuthenticationPage authentication = confirmationPage.signOut();
		MainPage main = authentication.moveToHome();
	} 
	
	@Test
	public void UpdatePersonalDetails()
	{   	
		String welcome = dict.getValueForKey("WELCOME_MESSAGE");
		String updateConfirmation = dict.getValueForKey("DETAILS_UPDATE_CONFIRM");
		String emailToSignIn = dict.getValueForKey("EMAIL");
		String passwordToSignIn = dict.getValueForKey("PASSWORD");
		String firstName = "Piotr";
		String lastName = "Lasecki";
		String newFirstName = "Andrew";
		String newLastName = "Norris";
		
		ConfirmationPage confirmationPage = this.BasicSignIn();
		PersonalInfoPage personalInfo = confirmationPage.moveToMyPersonalInfo();
		personalInfo.changeFirstName("Andrew");
		personalInfo.changeLastName("Norris");
		personalInfo.enterCurrentPassword(passwordToSignIn);
		personalInfo.confirm();
		assertEquals(personalInfo.getUpdateConfirmationMessage(), updateConfirmation);
		MainPage main = personalInfo.moveToHome();
		assertEquals(main.getUserDetails(), newFirstName + " " + newLastName);
		
		//Change back
		confirmationPage = main.clickUserDetails();
		personalInfo = confirmationPage.moveToMyPersonalInfo();
		personalInfo.changeFirstName(firstName);
		personalInfo.changeLastName(lastName);
		personalInfo.enterCurrentPassword(passwordToSignIn);
		personalInfo.confirm();
		assertEquals(personalInfo.getUpdateConfirmationMessage(), updateConfirmation);
		
	}
	

	public ConfirmationPage BasicSignIn()
	{   	
		String welcome = dict.getValueForKey("WELCOME_MESSAGE");
		String emailToSignIn = dict.getValueForKey("EMAIL");
		String passwordToSignIn = dict.getValueForKey("PASSWORD");
		
		
		MainPage main = new MainPage(driver);
		AuthenticationPage authentication = main.selectSignIn();
		ConfirmationPage confirmationPage = authentication.signIn(emailToSignIn, passwordToSignIn);
		assertEquals(confirmationPage.getWelcomeText(), welcome);
		
		return confirmationPage;
	}
	
	@After
	public void after() throws Exception {
		driver.quit(); 
	}


}
