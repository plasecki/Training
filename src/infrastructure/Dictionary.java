package infrastructure;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
	
	Map<String, String> dictionary = new HashMap<String, String>();
	
	public Dictionary() {
		dictionary.put("URL", "http://automationpractice.com");
		dictionary.put("WELCOME_MESSAGE", "Welcome to your account. Here you can manage all of your personal information and orders.");
	    dictionary.put("EMAIL", "974887134@gmail.com");
	    dictionary.put("PASSWORD", "Katarzyna1");
	    dictionary.put("DETAILS_UPDATE_CONFIRM", "Your personal information has been successfully updated.");
	}
	
	public String getValueForKey(String key) {
		return dictionary.get(key);
	}

}
