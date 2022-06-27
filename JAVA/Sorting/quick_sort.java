package Sorting;

public class quick_sort {
	public static int partition(int arr[], int low, int high) {
		int pivot = arr[high];//Pivot - Last element
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	public static void sort(int arr[], int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] a = {23,13,35,108,44,56,15};
		System.out.println("Before Sorting");
		for(int i:a){
			System.out.print(i+" ");
		}
		System.out.println();
		sort(a,0,a.length-1);
		System.out.println("After Quick Sort");
		for(int i:a){
			System.out.print(i+" ");
		}
	}
}

