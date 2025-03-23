package InterviewPrep;

public class TwoDArr {

	public static void printArr() {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printDiagonalElement() {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printArr();
		printDiagonalElement();
	}

}
