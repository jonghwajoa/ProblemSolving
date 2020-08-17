import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = atoi(st.nextToken());
		int K = atoi(st.nextToken());

		int[] inputs = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputs[i] = atoi(st.nextToken());
		}

		quick(inputs, 0, N - 1);
		System.out.println(inputs[K - 1]);
	}

	private static void quick(int[] arr, int left, int right) {
		int mid = (left + right) >> 1;
		int pivot = arr[mid];
		int l = left;
		int r = right;

		while (l < r) {
			while (arr[l] < pivot) {
				l++;
			}

			while (pivot < arr[r]) {
				r--;
			}

			if (l <= r) {
				int tmp = arr[l];
				arr[l] = arr[r];
				arr[r] = tmp;
				l++;
				r--;
			}
		}

		if (left < r) {
			quick(arr, left, r);
		}

		if (l < right) {
			quick(arr, l, right);
		}

	}

	private static int atoi(String string) {
		return Integer.parseInt(string);
	}
}