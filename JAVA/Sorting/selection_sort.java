package Sorting;
import java.util.Scanner;

public class selection_sort {
	public static void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int small = i;
			for (int j = i + 1; j < a.length; j++){
				if (a[j] < a[small]) {
					small = j;
				}
			}
			int s = a[small];
			a[small] = a[i];
			a[i] = s;
		}
	}

	public static void main(String[]args) {
		int n=10;
		int[] a = new int[n];
		System.out.println("--------------------Selection Sort--------------------");
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		System.out.print("Before Sorting : ");
		for (int i:a) {
			System.out.print(i+" ");
		}
		sort(a);
		System.out.println("");
		System.out.print("After Sorting : ");
		for (int i:a) {
			System.out.print(i+" ");
		}
	}
}
