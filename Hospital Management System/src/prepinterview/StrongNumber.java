package prepinterview;

import java.util.Scanner;

public class StrongNumber {

	public static void isStrongNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number : ");
		int number = sc.nextInt();

		int originalNumber = number;
		int sum = 0;
		while (number != 0) {
			int remainder = number % 10;
			sum = sum + factorial(remainder);
			number = number / 10;
		}
		if (originalNumber == sum) {
			System.out.println(originalNumber + " is strong number");
		}
	}

	public static int factorial(int number) {
		int factNum = 1;
		while (number != 1) {
			factNum = factNum * number;
			number--;
		}
		return factNum;
	}

	public static void findFactorial() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number : ");
		int number = sc.nextInt();

		int factorial = 1;

		for (int i = number; i > 0; i--) {
			factorial = factorial * i;
		}
		System.out.println("Factorial of " + number + " is : " + factorial);
	}

	public static void isArmstrongNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number : ");
		int number = sc.nextInt();

		int numberOfDigits = String.valueOf(number).length();

		System.out.println("Number of digits in number : " + numberOfDigits);

		int originalNumber = number;

		int sum = 0;
		int multiplication = 1;
		while (number != 0) {
			int remainder = number % 10;

			for (int i = 0; i < numberOfDigits; i++) {
				multiplication = multiplication * remainder;
			}
			sum = sum + multiplication;
			multiplication = 1;
			number = number / 10;

		}
		if (originalNumber == sum) {
			System.out.println(originalNumber + " is armstrong number");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// isStrongNumber();
		// findFactorial();
		// isArmstrongNumber();

	}

}
