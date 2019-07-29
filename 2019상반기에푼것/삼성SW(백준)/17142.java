import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N, M, emptyCount, len;
	static int[][] map;
	final static int EMPTY = 0, WALL = 1, VIRUS = 2;
	static LinkedList<Point> list;
	static boolean[] visit;
	static int[] mx = { 0, 1, 0, -1 };
	static int[] my = { -1, 0, 1, 0 };
	static int ans;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		emptyCount = 0;
		list = new LinkedList<>();
		ans = Integer.MAX_VALUE;

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				map[y][x] = sc.nextInt();
				if (map[y][x] == EMPTY) {
					emptyCount += 1;
				} else if (map[y][x] == VIRUS) {
					list.add(new Point(x, y));
				}
			}
		}

		len = list.size();
		visit = new boolean[len];
		dfs(0, 0);

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	public static void dfs(int index, int useCount) {
		if (useCount == M) {
			cal();
			return;
		}

		if (index >= len) {
			return;
		}

		visit[index] = true;
		dfs(index + 1, useCount + 1);
		visit[index] = false;
		dfs(index + 1, useCount);
	}

	public static int[][] copyMap() {
		int[][] copy = new int[N][N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				copy[y][x] = map[y][x];
			}
		}
		return copy;
	}

	public static void cal() {
		int[][] copy = copyMap();
		int copyCount = emptyCount;
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < len; i++) {
			if (visit[i]) {
				Point cur = list.get(i);
				q.add(cur);
				copy[cur.y][cur.x] = WALL;
			}
		}

		int time = 0;
		while (!q.isEmpty() && copyCount > 0) {
			int size = q.size();
			for (int i = 0; i < size; i += 1) {
				Point cur = q.poll();
				for (int j = 0; j < 4; j++) {
					int nextX = cur.x + mx[j];
					int nextY = cur.y + my[j];

					if (0 <= nextY && 0 <= nextX && nextX < N && nextY < N) {
						if (copy[nextY][nextX] != WALL) {
							q.add(new Point(nextX, nextY));
							if (copy[nextY][nextX] == EMPTY) {
								copyCount -= 1;
							}
							copy[nextY][nextX] = WALL;
						}
					}
				}
			}
			time += 1;
		}

		if (copyCount <= 0 && time < ans) {
			ans = time;
		}
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