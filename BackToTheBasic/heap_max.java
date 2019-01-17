package temp;

import java.util.*;

public class Main {
	static int[] heap = new int[10];
	static int size = 0;

	public static void main(String[] args) {
		push(heap, 5);
		push(heap, 25);
		push(heap, 15);
		push(heap, 53);
		push(heap, 52);
		push(heap, 51);

		int len = size;
		for (int i = 0; i < len; i++) {
			System.out.println(pop(heap));
		}
	}



	public static void push(int[] arr, int x) {
		arr[++size] = x;

		for (int i = size; i > 1; i /= 2) {
			if (arr[i] > arr[i / 2]) {
				int tmp = arr[i];
				arr[i] = arr[i / 2];
				arr[i / 2] = tmp;
			} else {
				break;
			}
		}
	}

	public static int pop(int[] arr) {
		int remove = arr[1];
		arr[1] = arr[size];
		arr[size--] = Integer.MIN_VALUE;

		for (int i = 1; i * 2 <= size;) {
			if (arr[i] > arr[i * 2] && arr[i] > arr[i * 2 + 1]) {
				break;
			} else if (arr[i * 2] < arr[i * 2 + 1]) {
				int tmp = arr[i];
				arr[i] = arr[i * 2 + 1];
				arr[i * 2 + 1] = tmp;
				i = i * 2 + 1;
			} else {
				int tmp = arr[i * 2];
				arr[i * 2] = arr[i];
				arr[i] = tmp;
				i = i * 2;
			}
		}

		return remove;
	}
}
