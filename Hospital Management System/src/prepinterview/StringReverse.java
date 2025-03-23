package prepinterview;

import java.util.Scanner;

public class StringReverse {

	public static String reverseByRecursion(String str) {

		if (str.isEmpty()) {
			return str;
		}
		return reverseByRecursion(str.substring(1)) + str.charAt(0);
	}

	public void reverseByArray() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string ");
		String str = sc.next();

		char[] cArr = new char[str.length()];
		cArr = str.toCharArray();
		System.out.println("Reversed String using array is : ");
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(cArr[i]);
		}
	}

	public void reverseByNotUsingAnyFunction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string ");
		String str = sc.next();

		System.out.println("Reversed string not using in built function is : ");
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
	}

	public void reverseStringNotLine() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string ");
		String str = sc.nextLine();

		String[] wordsArr = str.split(" ");

		for (int i = 0; i < wordsArr.length; i++) {
			for (int j = wordsArr[i].length() - 1; j >= 0; j--) {
				System.out.print(wordsArr[i].charAt(j));
			}
			System.out.print(" ");
		}
	}

	public void reverseLineNotWord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string ");
		String str = sc.nextLine().trim();

		if (str.isEmpty()) {
			System.out.println("Input string is empty.");
			return;
		}

		String[] strWords = str.split(" ");

		for (int i = strWords.length - 1; i >= 0; i--) {
			System.out.print(strWords[i]);

			if (i > 0) {
				System.out.print(" ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
//
//		String reversed = reverseByRecursion(str);
//		System.out.println("Original string is : " + str);
//		System.out.println("Reversed string is : " + reversed);

		StringReverse reverse = new StringReverse();
//		reverse.reverseByArray();

		// reverse.reverseByNotUsingAnyFunction();
//		reverse.reverseStringNotLine();

		reverse.reverseLineNotWord();
	}

}
