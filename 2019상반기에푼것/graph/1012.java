// bfs

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] moveX = { 0, 0, 1, -1 };
	static int[] moveY = { 1, -1, 0, 0 };
	static int[][] matrix;
	static boolean[][] isVisit;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int repeat = Integer.parseInt(br.readLine());

		while (repeat-- > 0) {
			String[] line = br.readLine().split("\\s");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			int n = Integer.parseInt(line[2]);
			matrix = new int[y][x];
			isVisit = new boolean[y][x];
			int count = 0;

			while (n-- > 0) {
				line = br.readLine().split("\\s");
				matrix[Integer.parseInt(line[1])][Integer.parseInt(line[0])] = 1;
			}
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (!isVisit[i][j] && matrix[i][j] == 1) {
						isVisit[i][j] = true;
						count++;
						bfs(x, y, j, i);
					}
				}
			}
			System.out.println(count);
		}
	}

	public static void bfs(int nX, int nY, int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x, y));

		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int curX = cur.x;
			int curY = cur.y;

			for (int k = 0; k < 4; k++) {
				int nextX = curX + moveX[k];
				int nextY = curY + moveY[k];

				if (0 <= nextX && 0 <= nextY && nextX < nX && nextY < nY) {
					if (!isVisit[nextY][nextX] && matrix[nextY][nextX] == 1) {
						isVisit[nextY][nextX] = true;
						q.add(new Pair(nextX, nextY));
					}
				}
			}
		}
	}
}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


// dfs
package temp;

import java.io.*;

public class Main {
	static int[] moveX = { 0, 0, 1, -1 };
	static int[] moveY = { 1, -1, 0, 0 };
	static int[][] matrix;
	static boolean[][] isVisit;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int repeat = Integer.parseInt(br.readLine());

		while (repeat-- > 0) {
			String[] line = br.readLine().split("\\s");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			int n = Integer.parseInt(line[2]);
			matrix = new int[y][x];
			isVisit = new boolean[y][x];
			int count = 0;

			while (n-- > 0) {
				line = br.readLine().split("\\s");
				matrix[Integer.parseInt(line[1])][Integer.parseInt(line[0])] = 1;
			}
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (!isVisit[i][j] && matrix[i][j] == 1) {
						isVisit[i][j] = true;
						count++;
						dfs(x, y, j, i);
					}
				}
			}
			System.out.println(count);
		}
	}

	public static void dfs(int nX, int nY, int x, int y) {
		for (int i = 0; i < 4; i++) {
			int curX = x + moveX[i];
			int curY = y + moveY[i];

			if (0 <= curX && 0 <= curY && curX < nX && curY < nY) {
				if (!isVisit[curY][curX] && matrix[curY][curX] == 1) {
					isVisit[curY][curX] = true;
					dfs(nX, nY, curX, curY);
				}
			}
		}
	}
}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
