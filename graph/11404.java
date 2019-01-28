package boj;

import java.util.*;

public class Main {
	static int max = 100000000;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] d = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], max);
			d[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int cost = sc.nextInt();
			d[st][ed] = Math.min(d[st][ed], cost);
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {

					if (d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (d[i][j] < max) {
					System.out.print(d[i][j] + " ");
				} else {
					System.out.print(0);
				}
			}
			System.out.println();
		}
	}
}