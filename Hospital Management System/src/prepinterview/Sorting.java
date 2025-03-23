package prepinterview;

public class Sorting {

	public void bubbleSort() {
		int[] arr = { 50, 10, 20, 40, 30 };

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("Array after bubble sort : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void selectionSort() {
		int[] arr = { 50, 10, 20, 40, 30 };

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("Array after selection sort : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void insertionSort() {
		int[] arr = { 50, 10, 20, 40, 30 };

		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}

		System.out.println("Array after insertion sort : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public int[] quickSort(int arr[], int start, int end) {

	    int i = start;
	    int j = end;

	    // Pivot selection (choose first element as pivot)
	    int pivot = arr[start];

	    while (i < j) {
	        // Move the left pointer (i) to the right until you find an element greater than or equal to the pivot
	        while (i < end && arr[i] < pivot) {
	            i++;
	        }

	        // Move the right pointer (j) to the left until you find an element smaller than or equal to the pivot
	        while (j > start && arr[j] > pivot) {
	            j--;
	        }

	        // If i and j haven't crossed, swap arr[i] and arr[j]
	        if (i < j) {
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	        }
	    }

	    // Place the pivot element in the correct position
	    arr[start] = arr[j];
	    arr[j] = pivot;

	    // Recursively sort the left and right sub-arrays
	    if (start < j - 1) {
	        quickSort(arr, start, j - 1);  // Sort the left sub-array
	    }
	    if (j + 1 < end) {
	        quickSort(arr, j + 1, end);    // Sort the right sub-array
	    }

	    return arr;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sorting sorting = new Sorting();
		sorting.bubbleSort();
		sorting.selectionSort();
		sorting.insertionSort();

		int[] arr = { 50, 10, 20, 40, 30 };
		int start = 1;
		int end = arr.length - 1;

		int[] resultArr = sorting.quickSort(arr, start, end);

		System.out.println("Array after quick sort : ");
		for (int k : resultArr) {
			System.out.print(k + " ");
		}
		System.out.println();
	}

}
