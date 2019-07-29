package boj;

import java.io.*;
import java.util.*;

public class Main {
	static int[] moveX = { 0, 0, 1, -1 };
	static int[] moveY = { 1, -1, 0, 0 };

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		sc.nextLine();
		boolean[][] map = new boolean[h][w];

		for (int i = 0; i < h; i++) {
			char[] tmp = sc.nextLine().toCharArray();
			for (int j = 0; j < w; j++) {
				if (tmp[j] == 'W') {
					map[i][j] = false;
				} else {
					map[i][j] = true;
				}
			}
		}

		int ans = -1;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j]) {
					int returnVal = bfs(j, i, map, h, w);
					if (ans < returnVal) {
						ans = returnVal;
					}
				}
			}
		}
		System.out.println(ans);
	}

	public static int bfs(int x, int y, boolean[][] input, int h, int w) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visit = new boolean[h][w];
		int max = -1;
		q.add(new Point(x, y, 0));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			int curX = cur.x;
			int curY = cur.y;

			for (int i = 0; i < 4; i++) {
				int nextX = curX + moveX[i];
				int nextY = curY + moveY[i];

				if (0 <= nextX && 0 <= nextY && nextX < w && nextY < h) {
					if (!visit[nextY][nextX] && input[nextY][nextX]) {
						visit[nextY][nextX] = true;
						q.add(new Point(nextX, nextY, cur.c + 1));
						if (max < cur.c + 1) {
							max = cur.c + 1;
						}
					}
				}
			}
		}
		return max;
	}
}

class Point {
	int x;
	int y;
	int c;

	public Point(int x, int y, int c) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
	}

}