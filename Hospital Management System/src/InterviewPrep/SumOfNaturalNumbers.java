package InterviewPrep;

import java.util.Scanner;

public class SumOfNaturalNumbers {

	public static void sumOfNNaturalNumbers() {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		int sum = number * (number + 1) / 2;
		System.out.println("Sum of first " + number + " natural numbers is : " + sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sumOfNNaturalNumbers();
	}

}
