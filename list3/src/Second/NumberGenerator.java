package Second;
import java.util.Random;

public class NumberGenerator {
	private  Random rand = new Random();
	
	private int min;
	private int max;
	private int default_min = 0;
	private int default_max = 1000;
	
	public NumberGenerator() {
		min = default_min;
		max = default_max;
	}

	
	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int generateNumber()
	{
		return generateNumber(min, max);
	}
	
	public int generateNumber(int min, int max)
	{
		this.min = min;
		this.max = max;
		
		int result = rand.nextInt(max - min) + min;
		System.out.println(result);
		return result;
	}
}
