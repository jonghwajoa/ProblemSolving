package temp;

import java.util.*;

public class Main {
	static final int[] move_x = { 0, 0, 1, -1 };
	static final int[] move_y = { 1, -1, 0, 0 };

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] input = new int[n][n];
		int[][] dist = new int[n][n];
		boolean[][] isVisit = new boolean[n][n];
		int[][] group = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				input[i][j] = sc.nextInt();
			}
		}

		Queue<Pair> q = new LinkedList<Pair>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (group[i][j] == 0 && input[i][j] == 1) {
					q.add(new Pair(j, i));
					group[i][j] = ++count;

					while (!q.isEmpty()) {
						Pair cur = q.poll();
						for (int k = 0; k < 4; k++) {
							int x = cur.x + move_x[k];
							int y = cur.y + move_y[k];
							if (0 <= x && 0 <= y && x < n && y < n) {
								if (group[y][x] == 0 && input[y][x] == 1) {
									q.add(new Pair(x, y));
									group[y][x] = count;
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (input[i][j] != 1) {
					dist[i][j] = -1;
				} else {
					q.add(new Pair(j, i));
				}
			}
		}

		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			for (int i = 0; i < 4; i++) {
				int dx = x + move_x[i];
				int dy = y + move_y[i];

				if (0 <= dx && 0 <= dy && dx < n && dy < n) {
					if (dist[dy][dx] == -1) {
						dist[dy][dx] = dist[y][x] + 1;
						group[dy][dx] = group[y][x];
						q.add(new Pair(dx, dy));
					}
				}
			}
		}

		int ans = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 4; k++) {
					int dx = j + move_x[k];
					int dy = i + move_y[k];
					if (0 <= dx && dx < n && 0 <= dy && dy < n) {
						if (group[dy][dx] != group[i][j]) {
							if (ans == -1 || ans > dist[dy][dx] + dist[i][j]) {
								ans = dist[dy][dx] + dist[i][j];
							}
						}
					}
				}
			}
		}

		System.out.println(ans);

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