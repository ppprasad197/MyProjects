package prepinterview;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int end = sc.nextInt();

		System.out.println("Prime numbers are : ");
		for (int i = 2; i <= end; i++) {
			boolean isPrime = true;
			for (int divisor = 2; divisor < i; divisor++) {
				if (divisor < i && i % divisor == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				System.out.print(i + " ");
		}

	}

}
