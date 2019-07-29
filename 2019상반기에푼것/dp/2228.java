package boj;

import java.util.Scanner;

public class Main {
	static int[] acc, input;
	static int min = -32768 * 101;
	static int[][] d;
	static boolean[][] c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		input = new int[n + 1];
		acc = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			input[i] = sc.nextInt();
			acc[i] = acc[i - 1] + input[i];
		}

		d = new int[n + 1][m + 1];
		c = new boolean[n + 1][m + 1];

		System.out.println(dfs(n, m));

	}

	public static int dfs(int n, int m) {
		if (m == 0) {
			return 0;
		}

		if (n <= 0) {
			return min;
		}

		if (c[n][m]) {
			return d[n][m];
		}

		c[n][m] = true;
		d[n][m] = dfs(n - 1, m);

		for (int i = 1; i <= n; i++) {
			int temp = dfs(i - 2, m - 1) + (acc[n] - acc[i - 1]);
			d[n][m] = Math.max(d[n][m], temp);
		}

		return d[n][m];
	}
}