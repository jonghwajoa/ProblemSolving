package temp;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {
		int[] data = { 5, 10, 2, 3, 6};

		quickSort(data, 0, data.length - 1);
		System.out.println(Arrays.toString(data));
	}

	public static void quickSort(int[] data, int l, int r) {
		int left = l;
		int right = r;
		int pivot = data[(l + r) / 2];

		do {
			while (data[left] < pivot)
				left++;
			while (pivot < data[right])
				right--;
			if (left <= right) {
				int tmp = data[right];
				data[right] = data[left];
				data[left] = tmp;
				left++;
				right--;
			}

		} while (left <= right);

		if (l < right)
			quickSort(data, l, right);
		if (r > left)
			quickSort(data, left, r);
	}
}