package boj;

import java.io.*;
import java.util.*;

public class Main {
	static int[] moveX = { 1, -1, 0, 0, 0, 0 };
	static int[] moveY = { 0, 0, -1, 1, 0, 0 };
	static int[] moveH = { 0, 0, 0, 0, 1, -1 };

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		int x = Integer.parseInt(line[0]);
		int y = Integer.parseInt(line[1]);
		int h = Integer.parseInt(line[2]);

		int[][][] box = new int[h][y][x];
		boolean[][][] visit = new boolean[h][y][x];
		Queue<Point> q = new LinkedList<Point>();
		int zeroCount = 0;

		for (int z = 0; z < h; z++) {
			for (int i = 0; i < y; i++) {
				line = sc.nextLine().split(" ");
				for (int j = 0; j < x; j++) {
					int tmp = Integer.parseInt(line[j]);
					box[z][i][j] = tmp;
					if (tmp == 1) {
						q.add(new Point(j, i, z, 0));
						visit[z][i][j] = true;
					} else if (tmp == 0) {
						zeroCount += 1;
					}
				}

			}
		}
		int ans = 0;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			int curX = cur.x;
			int curY = cur.y;
			int curH = cur.h;
			int curD = cur.d;
			ans = curD;
			for (int i = 0; i < 6; i++) {
				int nextX = curX + moveX[i];
				int nextY = curY + moveY[i];
				int nextH = curH + moveH[i];
				if (0 <= nextX && 0 <= nextY && 0 <= nextH && nextX < x && nextY < y && nextH < h) {
					if (box[nextH][nextY][nextX] == 0 && !visit[nextH][nextY][nextX]) {
						visit[nextH][nextY][nextX] = true;
						box[nextH][nextY][nextX] = 1;
						zeroCount -= 1;
						q.add(new Point(nextX, nextY, nextH, curD + 1));
					}
				}
			}

		}

		if (zeroCount >= 1) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}

}

class Point {
	int x;
	int y;
	int h;
	int d;

	public Point(int x, int y, int h, int d) {
		super();
		this.x = x;
		this.y = y;
		this.h = h;
		this.d = d;
	}

}
