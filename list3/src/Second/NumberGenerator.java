package Second;
import java.util.Random;

public class NumberGenerator {
	private  Random rand = new Random();
	
	private final static int DEFAULT_MIN = 100;
	private final static int DEFAULT_MAX = 1000;
	
	public int getMin() {
		return DEFAULT_MIN;
	}

	public int getMax() {
		return DEFAULT_MAX;
	}

	public int generateThreeDigitNumber() {
		return generateNumber(DEFAULT_MIN, DEFAULT_MAX);
	}
	
	public int generateNumber(int min, int max) {
		return rand.nextInt(max - min) + min;
	}
}
