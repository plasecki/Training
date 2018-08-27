package infrastructure;

import java.util.Random;

public class RandomGenerator {
	
	public int returnRandomNumber() {
		 Random rnd = new Random();
		 return rnd.nextInt();
	}

}
