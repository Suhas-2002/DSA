package Sorting;
import java.util.Scanner;

public class bubble_sort{

	public static void sort(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-i-1; j++) {
				if (a[j] > a[j + 1]) {
					int t = a[j];
					a[j] = a[j + 1];
					a[j + 1] = t;
				}
			}
		}
	}

	public static void main(String[]args) {
		int n=10;
		int[] a = new int[n];
		System.out.println("--------------------Bubble Sort--------------------");
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
