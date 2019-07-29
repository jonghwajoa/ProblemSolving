package temp;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long m = sc.nextInt();

		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt() % 1000;
			}
		}

		arr = cal(arr, m);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static int[][] cal(int[][] arr, long n) {
		if (n == 1) {
			return arr;
		} else if (n % 2 == 0) {
			arr = cal(arr, n / 2);
			arr = calculate(arr, arr);
			return arr;
		} else {
			int[][] tmp = cal(arr, n - 1);
			arr = calculate(arr, tmp);
			return arr;
		}
	}

	public static int[][] calculate(int[][] arr, int[][] brr) {
		int len = arr.length;
		int[][] c = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				int tmp = 0;
				for (int k = 0; k < len; k++) {
					tmp += arr[i][k] * brr[k][j];
				}
				c[i][j] = tmp % 1000;
			}
		}
		return c;
	}
}