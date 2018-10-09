package FIrst;

public class Program {
	
	public static void main(String[] args) {
		
		
		Text text = new Text("... Позволяющую получить текст в виде строки и вернуть массив слов.");
		
		StringToArray sta = new StringToArray();
		
		String[] res = sta.getArray(text);
		
		for(String re : res)
	    System.out.println(re);
		
	}

	
	
}
