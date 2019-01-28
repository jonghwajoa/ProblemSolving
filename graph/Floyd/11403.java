package boj;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] d = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				d[i][j] = sc.nextInt();
			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (d[i][k] == 1 && d[k][j] == 1) {
						d[i][j] = 1;
					}
				}
			}
		}

		for (int[] y : d) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
}


package boj;

import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] input = new int[n][n];
		int[][] d = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				input[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(i);
			boolean[] visit = new boolean[n];

			while (!q.isEmpty()) {
				int cur = q.poll();

				for (int j = 0; j < n; j++) {
					if (input[cur][j] == 1 && !visit[j]) {
						visit[j] = true;
						d[i][j] = 1;
						q.add(j);
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}
}