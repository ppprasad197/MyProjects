package prepinterview;

import java.util.Scanner;

public class CountHi {

	public static void printNumOfHi() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string");
		String str = sc.next();

		System.out.println(str.replaceAll("xhi", " "));

		int count = 0;

		if (str.length() != 0) {
			for (int i = 1; i < str.length() - 1; i++) {
				if (str.charAt(i - 1) != 'x' && str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') {
					count++;
				}
			}
		}
		System.out.println("Number of hi in string " + str + " are :" + count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printNumOfHi();
	}

}
