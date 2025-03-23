package InterviewPrep;

import java.util.Arrays;

public class StringNumberBifurcate {

	public static void bifurcateString() {
		String str = "75698463210125!&%ASi,.Pp";

		StringBuilder strRegAlpha = new StringBuilder();
		StringBuilder strNum = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (String.valueOf(c).matches("[A-Za-z!&%,.]")) {
				strRegAlpha.append(c);
			} else if (Character.isDigit(c)) {
				strNum.append(c);
			}
		}

		System.out.println(strRegAlpha);
		System.out.println(strNum);

		char[] strNumArr = new char[strNum.length()];
		strNumArr = strNum.toString().toCharArray();

		Arrays.sort(strNumArr);

		for (char c : strNumArr) {
			System.out.print(c + " ");
		}
		System.out.println();

		StringBuilder result = new StringBuilder();
		result.append(strRegAlpha);

		for (int i = strNumArr.length - 1; i >= 0; i--) {
			result.append(strNumArr[i]);
		}

		System.out.println(result);

	}

	public static void main(String[] args) {
		bifurcateString();
	}
}
