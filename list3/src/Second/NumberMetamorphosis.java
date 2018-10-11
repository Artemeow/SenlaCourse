package Second;

public final class NumberMetamorphosis {

	public static int[] splittingNumber(Integer number) {
		String str = number.toString();
		int length = str.length();
		int result[] = new int[length];
		
		for(int i = 0; i < length; i++) {
			int c = number%10;
			number = number/10;
			result[i] = c;
		}
		return result;
	}
	
	public static int sumOfDigits(int[] mas) {
		int result = 0;
		for(int i: mas) {
			result += i;
		}
		return result;
	}
}
