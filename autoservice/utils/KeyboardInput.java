package by.azhulpa.task4.autoservice.utils;

import java.util.Scanner;

public class KeyboardInput {

	private static Scanner scanner = new Scanner(System.in);
	
	public static String input() {
		
		String result = scanner.nextLine();
		return result;
	}
}
