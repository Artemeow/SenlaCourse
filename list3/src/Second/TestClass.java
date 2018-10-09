package Second;


public class TestClass {

	public static void main(String[] args)
	{
		NumberGenerator numb = new NumberGenerator();
		int num = numb.generateNumber(100, 999);
		
		int[] arr = NumberMetamorphosis.splittingNumber(num);
		
		
		System.out.println(NumberMetamorphosis.sumOfDigits(arr));
	}
}
