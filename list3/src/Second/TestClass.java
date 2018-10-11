package Second;


public class TestClass {

	public static void main(String[] args) {
		NumberGenerator numb = new NumberGenerator();
		int num = numb.generateThreeDigitNumber();
		int[] arr = NumberMetamorphosis.splittingNumber(num);
		
		System.out.println(num + " = " + NumberMetamorphosis.sumOfDigits(arr));
	}
}
