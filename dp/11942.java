package temp;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] input = new int[n];
		int[][] d = new int[n][n];

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
			d[i][i] = 1;
		}

		for (int i = 1; i < n; i++) {
			if (input[i] == input[i - 1]) {
				d[i - 1][i] = 1;
			} else {
				d[i - 1][i] = 0;
			}
		}

		for (int k = 2; k < n; k++) {
			for (int i = 0; i < n - k; i++) {
				int j = k + i;
				if (input[i] == input[j] && d[i + 1][j - 1] == 1) {
					d[i][j] = 1;
				}
			}
		}

		int m = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			int st = sc.nextInt();
			int end = sc.nextInt();
			sb.append(d[st - 1][end - 1] + "\n");
		}
		System.out.println(sb);
	}

	public static int dfs(int[] input, int[][] d, int st, int ed) {
		if (st == ed) {
			return 1;
		} else if (st + 1 == ed) {
			if (input[st] == input[ed]) {
				return 1;
			} else {
				return 0;
			}
		}

		if (d[st][ed] >= 0)
			return d[st][ed];

		if (input[st] != input[ed])
			return d[st][ed] = 0;
		else
			return d[st][ed] = dfs(input, d, st + 1, ed - 1);
	}
}




import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] input = new int[n];
		int[][] d = new int[n][n];

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
			Arrays.fill(d[i], -1);
		}

		int m = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			int st = sc.nextInt();
			int end = sc.nextInt();
			sb.append(dfs(input, d, st - 1, end - 1) + "\n");
		}
		System.out.println(sb);
	}

	public static int dfs(int[] input, int[][] d, int st, int ed) {
		if (st == ed) {
			return 1;
		} else if (st + 1 == ed) {
			if (input[st] == input[ed]) {
				return 1;
			} else {
				return 0;
			}
		}

		if (d[st][ed] >= 0)
			return d[st][ed];

		if (input[st] != input[ed])
			return d[st][ed] = 0;
		else
			return d[st][ed] = dfs(input, d, st + 1, ed - 1);
	}
}