package infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumInfrastructure {
	public static WebDriver driver;
	
	
	public WebDriver launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C://Users/laseckip/Desktop/chromedriver/chromedriver.exe");
	    driver = new ChromeDriver();
	    return driver;
	}
	
	public void openUrl(String url) {
		driver.get(url);
	}
		

}
