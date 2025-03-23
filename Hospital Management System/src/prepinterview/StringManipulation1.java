package prepinterview;

import java.util.Arrays;

public class StringManipulation1 {

	public static void printString() {
		String str = "alhfeqw[vnlkj$@#%^!&843179526";
		char[] charArr = new char[str.length()];
		charArr = str.toCharArray();

		char[] nCharArr = new char[str.length()];
		int[] numArr = new int[str.length()];
		char[] regexArr = new char[str.length()];

		int i = 0;
		int j = 0;
		int k = 0;

		for (char c : charArr) {
			if (Character.isAlphabetic(c)) {
				nCharArr[i] = c;
				i++;
			} else if (Character.isDigit(c)) {
				numArr[j] = Character.getNumericValue(c);
				j++;
			} else {
				regexArr[k] = c;
				k++;
			}
		}
		Arrays.sort(numArr, 0, j);

		for (int p = 0; p < i; p++) {
			System.out.print(nCharArr[p]);
		}

		for (int p = 0; p < k; p++) {
			System.out.print(regexArr[p]);
		}

		for (int p = j - 1; p >= 0; p--) {
			System.out.print(numArr[p]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printString();
	}

}
