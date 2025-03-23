//*
//***
//*****
//*******
//1   
//12
//123
//1234
//1
//2 3
//4 5 6
//7 8 9 10
//11 12 13 14 
//*
// *
//  *
//   *
//A 
//A B 
//A B C 
//A B C D
//A B C D E
//A B C D E F
package InterviewPrep;

import java.util.Scanner;

public class Pattern1 {

	public void hollowSquare(int numberOfLines) {
		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j < numberOfLines; j++) {
				if (i == 0 || i == numberOfLines - 1) {
					System.out.print("* ");
				} else if (j == 0 || j == numberOfLines - 1) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();

		}
	}

	public void hollowSquareAndDiagonal(int numberOfLines) {
		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j < numberOfLines; j++) {
				if (i == 0 || i == numberOfLines - 1 || j == 0 || j == numberOfLines - 1 || i == j
						|| j == numberOfLines - i - 1) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	public void oneByOnePrintSquare(int numberOfLines) {

		Scanner sc = new Scanner(System.in);
		System.out.println("For Even pattern press 2 and for Odd pattern press 1 : ");
		int type = sc.nextInt();

		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j < numberOfLines; j++) {
				if (type == 1) {
					if ((j + 1) % 2 != 0) {
						System.out.print("* ");
					} else {
						System.out.print("  ");
					}
				} else if (type == 2) {
					if ((j + 1) % 2 == 0) {
						System.out.print("* ");
					} else {
						System.out.print("  ");
					}
				}
			}
			System.out.println();
		}

	}

	public void printAtEvenOrOddPlaceOfSquare(int numberOfLines) {
		Scanner sc = new Scanner(System.in);
		System.out.println("For Even postions press 2 and for Odd positions press 1 : ");
		int position = sc.nextInt();

		int count = 1;

		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j < numberOfLines; j++) {
				if (position == 1) {
					if (count % 2 != 0) {
						System.out.print("* ");
						count++;
					} else {
						System.out.print("  ");
						count++;
					}
				}

				if (position == 2) {
					if (count % 2 == 0) {
						System.out.print("* ");
						count++;
					} else {
						System.out.print("  ");
						count++;
					}
				}
			}
			System.out.println();
		}
	}

	public void printCross(int numberOfLines) {
		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j < numberOfLines; j++) {
				if (i == j || j == numberOfLines - i - 1) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	public void hollowTriangle(int numberOfLines) {
		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i || i == numberOfLines - 1) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numberOfLines = sc.nextInt();

		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j < (i * 2 + 1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(j + 1);
			}
			System.out.println();
		}

		int count = 1;
		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(count + " ");
				count++;
			}
			System.out.println();
		}

		for (int i = 0; i < numberOfLines; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		for (int i = 0; i < numberOfLines; i++) {
			char ch = 'A';
			for (int j = 0; j <= i; j++) {
				System.out.print(ch + " ");
				ch++;
			}
			System.out.println();
		}

		Pattern1 pattern1 = new Pattern1();
//		pattern1.hollowSquare(numberOfLines);
//		pattern1.hollowSquareAndDiagonal(numberOfLines);
//		pattern1.oneByOnePrintSquare(numberOfLines);
//		pattern1.printAtEvenOrOddPlaceOfSquare(numberOfLines);
//		pattern1.printCross(numberOfLines);
		pattern1.hollowTriangle(numberOfLines);
	}

}
