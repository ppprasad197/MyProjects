package InterviewPrep;

import java.util.Scanner;

public class FindPower {

	public static void findPower() {
		Scanner sc = new Scanner(System.in);
		int number1 = sc.nextInt();
		int number2 = sc.nextInt();
		int power = 1;

		for (int i = 0; i < number2; i++) {
			power = power * number1;
		}
		System.out.println(number1 + " raise to " + number2 + " is : " + power);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findPower();
	}

}
