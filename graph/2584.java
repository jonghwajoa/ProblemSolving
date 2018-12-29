package temp;

import java.io.*;
import java.util.*;

public class Main {
	static int[] moveX = { 0, 0, 1, -1 };
	static int[] moveY = { 1, -1, 0, 0 };
	static boolean[][] matrix;
	static boolean[][] isVisit;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split("\\s");
		int Y = Integer.parseInt(line[0]);
		int X = Integer.parseInt(line[1]);
		int N = Integer.parseInt(line[2]);
		matrix = new boolean[Y][X];
		isVisit = new boolean[Y][X];
		int count = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();

		while (N-- > 0) {
			line = br.readLine().split("\\s");
			int lx = Integer.parseInt(line[0]);
			int ly = Integer.parseInt(line[1]);
			int rx = Integer.parseInt(line[2]);
			int ry = Integer.parseInt(line[3]);

			for (int i = ly; i < ry; i++) {
				for (int j = lx; j < rx; j++) {
					matrix[i][j] = true;
				}
			}
		}

		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (!isVisit[i][j] && !matrix[i][j]) {
					isVisit[i][j] = true;
					ans.add(bfs(X, Y, j, i));
					count++;
				}
			}
		}
		System.out.println(count);
		Collections.sort(ans);
		for (int val : ans) {
			System.out.print(val + " ");
		}

	}

	public static int bfs(int nX, int nY, int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x, y));
		int count = 1;

		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int curX = cur.x;
			int curY = cur.y;

			for (int i = 0; i < 4; i++) {
				int nextX = curX + moveX[i];
				int nextY = curY + moveY[i];

				if (0 <= nextX && 0 <= nextY && nextX < nX && nextY < nY) {
					if (!isVisit[nextY][nextX] && !matrix[nextY][nextX]) {
						isVisit[nextY][nextX] = true;
						q.add(new Pair(nextX, nextY));
						count++;
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
		this.x = x;
		this.y = y;
	}
}
