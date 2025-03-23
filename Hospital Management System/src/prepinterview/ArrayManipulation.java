package prepinterview;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayManipulation {

	public void minAndMax() {
		int[] arr = { 50, 20, 40, 80, 60, 70, 30, 10, 100, 90 };

		Arrays.sort(arr);

		System.out.println("Minimun in Array = " + arr[0] + ", Maximum in array = " + arr[arr.length - 1]);
	}

	public void minAndMaxWithoutInBuiltFun() {
		int[] arr = { 50, 20, 40, 80, 60, 70, 30, 10, 100, 90 };
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {

			if (min > arr[i]) {
				min = arr[i];
				arr[i] = min;
			}
		}
		System.out.println("Minimum in array is : " + min);
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {

			if (max < arr[i]) {
				max = arr[i];
				arr[i] = max;
			}
		}
		System.out.println("Maximum in array is : " + max);
	}

	public void occurenceOfInteger() {
		int[] arr = { 10, 20, 30, 40, 50, 10, 20, 30, 40, 50 };

		HashSet<Integer> seenNumbers = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			int count = 0;

			if (!seenNumbers.contains(num)) {
				seenNumbers.add(num);

				for (int j = 0; j < arr.length; j++) {

					if (num == arr[j]) {
						count++;
					}

				}
				System.out.println(num + " occured in array " + count + " times");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayManipulation arrayManipulation = new ArrayManipulation();
		// arrayManipulation.minAndMax();
		// arrayManipulation.minAndMaxWithoutInBuiltFun();

		arrayManipulation.occurenceOfInteger();
	}

}
