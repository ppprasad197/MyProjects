package prepinterview;

import java.util.Scanner;

public class SwapTwoNumbers {

	public static void factorialByForLoop() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number : ");
		int number = sc.nextInt();
		int factorial = 1;
		for (int i = number; i > 0; i--) {
			factorial = factorial * i;
		}
		System.out.println("Factorial of " + number + " is : " + factorial);
	}

	public static void factorialByWhile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number : ");
		int number = sc.nextInt();
		int factorial = 1;
		while (number != 1) {
			factorial = factorial * number;
			number--;
		}
		System.out.println("Factorial of " + number + " is : " + factorial);
	}

	public static int factorialByRecursion(int number) {
		if (number == 1) {
			return 1;
		}
		return number * factorialByRecursion(number - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 10;
		int num2 = 20;
		System.out.println("Numbers before num1 = " + num1 + " and num2 = " + num2);

		num2 = num1 + num2;

		num1 = num2 - num1;
		num2 = num2 - num1;

		System.out.println("Numbers after num1 = " + num1 + " and num2 = " + num2);

		factorialByForLoop();
		factorialByWhile();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number : ");
		int number = sc.nextInt();
		
		System.out.println("Factorial of " + number + " is : " + factorialByRecursion(number));
	}

}
