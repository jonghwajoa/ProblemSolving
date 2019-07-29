import java.util.Arrays;

public class selectionSorting {

	public static void main(String[] args) {
		int[] line = { 10, 5, 4, 3, -6, 3 };

		selectionSort(line);
		System.out.println(Arrays.toString(line));
	}

	public static void selectionSort(int[] a) {

		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			int tmp = a[min];
			a[min] = a[i];
			a[i] = tmp;
		}
	}
}
