package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static boolean[][] c;
	static int[] moveX = { 1, -1, 0, 0 };
	static int[] moveY = { 0, 0, -1, 1 };
	static int n;
	static int m;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		c = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			line = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				if (line[j].equals("0")) {
					c[i][j] = true;
				}
			}
		}

		PriorityQueue<Pair> q = new PriorityQueue<Pair>();

		q.add(new Pair(0, 0, 0));

		boolean[][] visit = new boolean[m][n];
		int[][] dist = new int[m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(dist[i], -1);
		}

		dist[0][0] = 0;
		while (!q.isEmpty()) {
			Pair cur = q.poll();

			if (visit[cur.y][cur.x]) {
				return;
			}
			visit[cur.y][cur.x] = true;

			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + moveX[i];
				int nextY = cur.y + moveY[i];

				if (0 <= nextX && 0 <= nextY && nextX < n && nextY < m) {
					if (dist[nextY][nextX] == -1) {
						if (c[nextY][nextX]) { // true면 방임
							dist[nextY][nextX] = dist[cur.y][cur.x];
						} else {
							dist[nextY][nextX] = dist[cur.y][cur.x] + 1;
						}
						q.add(new Pair(nextX, nextY, dist[nextY][nextX]));
					}
				}
			}
		}

		System.out.println(dist[m - 1][n - 1]);
	}
}

class Pair implements Comparable<Pair> {
	int x;
	int y;
	int dist;

	public Pair(int x, int y, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;

	}

	public int compareTo(Pair o) {
		return this.dist - o.dist;

	}
}