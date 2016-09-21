package module6.task;

public class SelectionSort {

	// Find the smallest int and put it in the most left index
	// Then find the second smallest int and put it in second most left index
	// Keep on going until we reach the final index of array
	public void selectionSort(int[] a){
		int smallestIndex;
		for (int i = 0; i < a.length; i++) {
			smallestIndex = i;
			for (int j = i+1; j < a.length; j++) {
				if (a[j] < a[i]) {
					smallestIndex = j;
				}
			}
			swap(a, i, smallestIndex);
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
	
	public static void main(String args[]){
		int[] a = {200, 14, 1000, 8, 883, 0, 5, -2};
		SelectionSort s = new SelectionSort();
		s.selectionSort(a);
		s.printArray(a);
	}

}
