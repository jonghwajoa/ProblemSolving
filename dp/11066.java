package temp;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] input;
	static int[][] d;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();

		while (repeat-- > 0) {

		int n = sc.nextInt();

		input = new int[n];
		d = new int[n][n];

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
			Arrays.fill(d[i], -1);
		}
			System.out.println(dfs(0, n - 1, n));
		}
	}

	public static int dfs(int x, int y, int n) {
		if (x == y) {
			return 0;
		}

		if (d[y][x] != -1) {
			return d[y][x];
		}
		int ans = -1;
		int sum = 0;
		d[y][x] = 0;

		for (int i = x; i <= y; i++) {
			sum += input[i];
		}

		for (int i = x; i < y; i++) {
			int tmp = dfs(x, i, n) + dfs(i + 1, y, n);
			if (ans == -1 || tmp < ans) {
				ans = tmp;
			}
		}

		d[y][x] = ans + sum;

		return d[y][x];
	}
}
