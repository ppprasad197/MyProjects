package prepinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringManipulation {

	public static void printStr() {
		String str = "alhfeqw[vnlkj$@#%^!&843179526";

		StringBuilder alphaStr = new StringBuilder();
		StringBuilder regexStr = new StringBuilder();
		int[] intArr = new int[str.length()];
		List<Integer> numbers = new ArrayList<>();

		for (char ch : str.toCharArray()) {

			if (Character.isAlphabetic(ch)) {
				alphaStr.append(ch);
			} else if (Character.isDigit(ch)) {
				numbers.add(Character.getNumericValue(ch));
			} else {
				regexStr.append(ch);
			}
		}

		System.out.print(alphaStr);
		System.out.print(regexStr);
		Collections.sort(numbers);
		Collections.reverse(numbers);
		for (int i : numbers) {
			System.out.print(i);
		}
	}

	public static void isPalindrome() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two strings");
		String str1 = sc.next();
		String str2 = sc.next();

		char[] cArr1 = str1.toCharArray();
		char[] cArr2 = new char[str2.length()];

//		Arrays.sort(cArr1);
//		Arrays.sort(cArr2);

		if (str1.length() == str2.length()) {
			int j = str2.length() - 1;
			for (int i = 0; i < str1.length(); i++) {
				cArr2[i] = str2.charAt(j);
				j--;
			}
			if (Arrays.equals(cArr1, cArr2)) {
				System.out.println(str1 + " and " + str2 + " are palindrome to each other");
			} else {
				System.out.println("Strings are not palindrome");
			}
		}
	}

	public static void isNumberPalindrome() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int palindromeNum = 0;

		if (String.valueOf(num1).length() == String.valueOf(num2).length()) {
			while (num2 != 0) {
				int remainder = num2 % 10;
				palindromeNum = 10 * palindromeNum + remainder;
				num2 = num2 / 10;
			}
			if (num1 == palindromeNum) {
				System.err.println(num1 + " and " + palindromeNum + " are palindrome to each other");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printStr();
		// isPalindrome();
		isNumberPalindrome();
	}

}
