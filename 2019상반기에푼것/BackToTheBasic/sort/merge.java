package temp;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = { 5, 10, 4, 7, 2, 9 , 300,50,10,-7 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int mid = (left + right) / 2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		if (left >= right)
			return;

		int l = left;
		int r = mid + 1;
		int cur = 0;
		int[] tmp = new int[right - left + 1];

		while (l <= mid && r <= right) {
			if (arr[l] < arr[r]) {
				tmp[cur++] = arr[l++];
			} else {
				tmp[cur++] = arr[r++];
			}
		}

		if (r <= right) {
			for (int i = r; i <= right; i++) {
				tmp[cur++] = arr[i];
			}
		} else {
			for (int i = l; i <= mid; i++) {
				tmp[cur++] = arr[i];
			}
		}

		for (int i = 0; i < tmp.length; i++) {
			arr[i + left] = tmp[i];
		}
	}
}

