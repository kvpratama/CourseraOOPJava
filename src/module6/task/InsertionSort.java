package module6.task;

public class InsertionSort {
	
	// Insertion Sort Algorithm
	// This algorithm find the relative position of an element to index -1
	// Ex: 4 7 2 10 1 8
	// 4 7 2 10 1 8
	// 2 4 7 10 1 8
	// 2 4 7 10 1 8
	// 1 2 4 7 10 8
	// 1 2 4 7 8 10
	public void insertionSort(int[] arr){
		int currInd;
		
		for (int i = 1; i < arr.length; i++) {
			currInd = i;
			while (currInd > 0 && arr[currInd] < arr[currInd-1]) {
				swap(arr, currInd, currInd-1);
				currInd--;
			}
		}
	}
	
	// Swap position of firstIndex with secondIndex in array
	private void swap(int[] a, int firstIndex, int secondIndex){
		int temp = a[firstIndex];
		a[firstIndex] = a[secondIndex];
		a[secondIndex] = temp;
	}
	
	private void printArray(int[] a){
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = {200, 14, 1000, 8, 883, 0, 5, -2};
		InsertionSort is = new InsertionSort();
		is.insertionSort(a);
		is.printArray(a);

	}

}
