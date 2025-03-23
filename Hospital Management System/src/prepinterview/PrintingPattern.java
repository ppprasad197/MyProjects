package prepinterview;

import java.util.Scanner;

public class PrintingPattern {

	public static void printSquare() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter side : ");
		int side = sc.nextInt();

		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				if (i == 0 || i == (side - 1)) {
					System.out.print("* ");
				} else if (j == 0 || j == (side - 1)) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	public static void printTriangle() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter base : ");
		int base = sc.nextInt();

		if (base % 2 != 0) {
			for (int i = base / 2; i >= 0; i--) {
				for (int j = 0; j < base; j++) {
					if (j == i || j == base - 1 - i) {
						System.out.print("* ");
					} else if (i == 0) {
						System.out.print("* ");
					} else {
						System.out.print("  ");
					}
				}
				System.out.println();
			}
		} else {
			System.out.println("Please enter odd number");
		}
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printSquare();
		printTriangle();
	}

}
