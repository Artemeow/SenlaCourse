package FIrst;

public class Program {
	
	public static void main(String[] args) {

		Text text = new Text("... ����������� �������� ����� � ���� ������ � ������� ������ ����.");
		
		String[] words = text.getText().split(" ");
		
		for(String word : words) {
	    System.out.println(word);
		}
	}
}
