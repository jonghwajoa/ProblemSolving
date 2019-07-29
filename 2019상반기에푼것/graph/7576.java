package temp;

import java.util.*;

public class Main {
	static int y;
	static int x;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[] move_x = { 0, 0, 1, -1 };
		int[] move_y = { 1, -1, 0, 0 };
		x = sc.nextInt();
		y = sc.nextInt();
		int[][] dist = new int[y][x];
		int[][] input = new int[y][x];
		boolean[][] isVisit = new boolean[y][x];

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				input[i][j] = sc.nextInt();
			}
		}

		Queue<Pair> q = new LinkedList<Pair>();
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (input[i][j] == 1) {
					q.add(new Pair(j, i));
					isVisit[i][j] = true;
					dist[i][j] = 1;
				}
			}
		}

		while (!q.isEmpty()) {
			Pair point = q.poll();
			int val = dist[point.y][point.x];

			for (int i = 0; i < 4; i++) {
				int dx = point.x + move_x[i];
				int dy = point.y + move_y[i];

				if (0 <= dx && dx < x && 0 <= dy && dy < y) {
					if (!isVisit[dy][dx] && input[dy][dx] != -1) {
						dist[dy][dx] = val + 1;
						q.add(new Pair(dx, dy));
						isVisit[dy][dx] = true;
					}
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (input[i][j] != -1 && dist[i][j] == 0) {
					System.out.println("-1");
					return;
				} else if (ans < dist[i][j]) {
					ans = dist[i][j];
				}
			}
		}
		System.out.println(ans - 1);
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