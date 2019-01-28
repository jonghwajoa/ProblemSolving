import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		int[] line = { 10, 5, 4, 3, -6, 3 };

		insertionSort(line, 0, line.length - 1);
		System.out.println(Arrays.toString(line));
	}

	public static void insertionSort(int[] a, int left, int right) {
		for (int i = 1; i <= right; i++) {
			for (int j = i; 0 <= j; i--) {
				if (a[j - 1] <= a[j]) {
					return;
				}

				int tmp = a[j - 1];
				a[j - 1] = a[j];
				a[j] = tmp;
			}
		}
	}
}