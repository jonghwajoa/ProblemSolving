package boj;

import java.io.*;
import java.util.*;

public class Main {
	static int[] moveX = { 1, -1, 0, 0 };
	static int[] moveY = { 0, 0, -1, 1 };
	final static int BLUE = 0;
	final static int GREEN = 1;
	final static int RED = 2;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] weakness = new int[n][n];
		int[][] normality = new int[n][n];
		sc.nextLine();
		for (int i = 0; i < n; i += 1) {
			String line = sc.nextLine();

			for (int j = 0; j < n; j += 1) {
				char tmp = line.charAt(j);
				if (tmp == 'B') {
					normality[i][j] = BLUE;
					weakness[i][j] = BLUE;
				} else if (tmp == 'R') {
					normality[i][j] = RED;
					weakness[i][j] = GREEN;
				} else {
					normality[i][j] = GREEN;
					weakness[i][j] = GREEN;
				}
			}
		}
		System.out.println(bfs(n, normality) + " " + bfs(n, weakness));
	}

	public static int bfs(int n, int[][] input) {
		int ans = 0;
		boolean[][] visit = new boolean[n][n];

		for (int i = 0; i < n; i += 1) {
			for (int j = 0; j < n; j += 1) {
				if (!visit[i][j]) {
					Queue<Pair> q = new LinkedList<Pair>();
					q.add(new Pair(j, i, input[i][j]));
					visit[i][j] = true;
					ans++;
					while (!q.isEmpty()) {
						Pair cur = q.poll();
						int curX = cur.x;
						int curY = cur.y;
						int curColor = cur.color;

						for (int z = 0; z < 4; z++) {
							int nextX = curX + moveX[z];
							int nextY = curY + moveY[z];

							if (0 <= nextX && 0 <= nextY && nextX < n && nextY < n) {
								if (input[nextY][nextX] == curColor && !visit[nextY][nextX]) {
									q.add(new Pair(nextX, nextY, curColor));
									visit[nextY][nextX] = true;
									
								}
							}
						}
					}
				}
			}
		}

		return ans;
	}
}

class Pair {
	int x;
	int y;
	int color;

	public Pair(int x, int y, int color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}

}
