package Second;

public final class NumberMetamorphosis {

	public static int[] splittingNumber(Integer i)
	{
		String str = i.toString();
		int length = str.length();
		int result[] = new int[length];
		
		for(int a = 0; a < length; a++)
		{
			int c = i%10;
			i = i/10;
			result[a] = c;
		}
		return result;
	}
	
	public static int sumOfDigits(int[] mas)
	{
		int result = 0;
		for(int a: mas)
			result += a;
			
		return result;
	}
}
