package FIrst;

public class Program {
	
	public static void main(String[] args) {

		Text text = new Text("... Позволяющую получить текст в виде строки и вернуть массив слов.");
		
		String[] words = text.getText().split(" ");
		
		for(String word : words) {
	    System.out.println(word);
		}
	}
}
