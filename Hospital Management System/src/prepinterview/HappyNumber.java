package prepinterview;

import java.util.HashSet;
import java.util.Scanner;

public class HappyNumber {

	public static boolean isHappyNumber(int number) {
		// Scanner sc = new Scanner(System.in);
		// System.out.println("Enter number : ");
		// int number = sc.nextInt();
		// int originalNumber = number;

		HashSet<Integer> seenNumbers = new HashSet<>();

		while (number != 1 && !seenNumbers.contains(number)) {
			int sum = 0;
			seenNumbers.add(number);
			while (number != 0) {
				int remainder = number % 10;
				sum = sum + remainder * remainder;
				number = number / 10;
			}
			number = sum;
		}

		return number == 1;
	}

	public static void fibonacciSeries() {
		int num1 = 0;
		int num2 = 1;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how number of series want to print : ");
		int length = sc.nextInt();
		System.out.println("Fibonacci series is : ");
		System.out.print(num1 + " , " + num2);
		for (int i = 2; i < length; i++) {
			int num3 = num1 + num2;
			System.out.print(" , " + num3);
			num1 = num2;
			num2 = num3;
		}
	}

	public static int fibonacciByRecursion(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacciByRecursion(n - 1) + fibonacciByRecursion(n - 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		if (isHappyNumber(19) == true) {
//			System.out.println("Happy number");
//		} else {
//			System.out.println("Not Happy number");
//		}
		// fibonacciSeries();

		int n = 10;
		for (int i = 0; i < n; i++) {
			System.out.print(fibonacciByRecursion(i) + " ");
		}
	}

}
