import java.util.Arrays;

public class bubbleSorting {

	public static void main(String[] args) {
		int[] arr = { 10, 4, 3, 5, 200, 7 };

		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = 1; j < len - i; j++) {
				if (arr[j] < arr[j - 1]) {
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
