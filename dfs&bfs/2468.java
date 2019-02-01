package boj;

import java.io.*;
import java.util.*;

public class Main {

	static int[] moveX = { 1, -1, 0, 0 };
	static int[] moveY = { 0, 0, -1, 1 };

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] square = new int[n][n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				square[i][j] = sc.nextInt();

				if (max < square[i][j]) {
					max = square[i][j];
				}
			}
		}

		int ans = 0;
		for (int i = 0; i <= max; i++) {
			int returnVal = bfs(i, n, square);
			if (returnVal > ans) {
				ans = returnVal;
			}
		}
		System.out.println(ans);
	}

	public static int bfs(int stand, int n, int[][] square) {
		boolean[][] visit = new boolean[n][n];

		Queue<Pair> q = new LinkedList<Pair>();
		int count = 0;

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (square[y][x] > stand && !visit[y][x]) {
					q.add(new Pair(x, y));
					visit[y][x] = true;
					count++;
					while (!q.isEmpty()) {
						Pair cur = q.poll();
						int curX = cur.x;
						int curY = cur.y;

						for (int i = 0; i < 4; i++) {
							int nextX = curX + moveX[i];
							int nextY = curY + moveY[i];

							if (0 <= nextX && 0 <= nextY && nextX < n && nextY < n) {
								if (square[nextY][nextX] > stand && !visit[nextY][nextX]) {
									q.add(new Pair(nextX, nextY));
									visit[nextY][nextX] = true;
								}

							}

						}
					}
				}

			}
		}
		return count;
	}
}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}