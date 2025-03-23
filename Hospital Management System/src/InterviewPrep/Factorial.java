package InterviewPrep;

import java.util.Scanner;

public class Factorial {
	Scanner sc = new Scanner(System.in);
	int number = sc.nextInt();

	public static void findFactorial() {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println("Factorial of " + number + " is : " + factorial(number));
	}

	public static int factorial(int number) {
		int factorial = 1;

		while (number >= 1) {
			factorial = factorial * number;
			number--;
		}
		return factorial;
	}

	public static void main(String[] args) {
		findFactorial();
	}

}
