package prepinterview;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

	public static void isAnagram() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter both strings : ");
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		char[] str1Arr = str1.toCharArray();
		char[] str2Arr = str2.toCharArray();

		Arrays.sort(str1Arr);
		Arrays.sort(str2Arr);

		if (Arrays.equals(str1Arr, str2Arr)) {
			System.out.println(str1 + " and " + str2 + " are anagram to each others");
		} else {
			System.out.println(str1 + " and " + str2 + " are not anagram to each others");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isAnagram();
	}

}
