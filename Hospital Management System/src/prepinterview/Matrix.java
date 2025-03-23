package prepinterview;

public class Matrix {

	public void sumOfDiagonalElements() {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i][i];
		}
		System.out.println("Sum of diagonal elements if array is : " + sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrix matrix = new Matrix();
		matrix.sumOfDiagonalElements();
	}

}
