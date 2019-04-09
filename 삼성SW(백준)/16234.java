import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	final static int[] mx = { 0, 1, 0, -1 };
	final static int[] my = { -1, 0, 1, 0 };

	static int N, L, R;
	static int[][] map;
	static Point next;

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int ans = 0;
		while (solve()) {
			ans += 1;

		}
		System.out.println(ans);
	}

	public static boolean solve() {
		boolean[][] visit = new boolean[N][N];
		boolean flag = false;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (!visit[y][x]) {
					Queue<Point> q = new LinkedList<>();
					LinkedList<Point> store = new LinkedList<>();
					q.add(new Point(x, y));
					store.add(new Point(x, y));
					visit[y][x] = true;

					while (!q.isEmpty()) {
						Point cur = q.poll();
						int curX = cur.x;
						int curY = cur.y;

						for (int i = 0; i < 4; i++) {
							int nextX = curX + mx[i];
							int nextY = curY + my[i];
							if (isSafe(nextX, nextY) && !visit[nextY][nextX]) {
								int abs = Math.abs(map[curY][curX] - map[nextY][nextX]);
								if (L <= abs && abs <= R) {
									visit[nextY][nextX] = true;
									q.add(new Point(nextX, nextY));
									store.add(new Point(nextX, nextY));
								}
							}
						}
					}

					if (store.size() > 1) {
						flag = true;
						cal(store);
					} else {
						visit[y][x] = false;
					}
				}
			}
		}
		return flag;
	}

	public static void cal(LinkedList<Point> q) {
		int len = q.size();
		int acc = 0;
		for (int i = 0; i < len; i++) {
			Point cur = q.get(i);
			acc += map[cur.y][cur.x];
		}

		int avg = (int) (acc / len);
		for (int i = 0; i < len; i++) {
			Point cur = q.get(i);
			map[cur.y][cur.x] = avg;
		}
		q.clear();
	}

	public static boolean isSafe(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}