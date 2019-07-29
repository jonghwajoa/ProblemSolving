import java.awt.print.PrinterIOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] my = { -1, 0, 0, 1 };
	static int[] mx = { 0, -1, 1, 0 };
	static int N, ans, fishCount;
	static int[][] map;
	static Dolphin dolphin;

	public static void main(String args[]) throws Exception {
		final Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		ans = 0;
		fishCount = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				map[y][x] = sc.nextInt();
				if (map[y][x] == 9) {
					dolphin = new Dolphin(x, y, 2, 0);
					map[y][x] = 0;
				} else if (map[y][x] != 0) {
					fishCount += 1;
				}
			}
		}

		solve();
		System.out.println(ans);
	}

	public static void solve() {
		while (true) {
			if (fishCount <= 0) {
				break;
			}

			Point fishPoint = find();
			if (fishPoint == null) {
				break;
			}

			fishCount -= 1;
			ans += fishPoint.d;
			map[dolphin.y][dolphin.x] = 0;

			dolphin.x = fishPoint.x;
			dolphin.y = fishPoint.y;
			dolphin.acc += 1;
			map[fishPoint.y][fishPoint.x] = 9;

			if (dolphin.acc == dolphin.size) {
				dolphin.size += 1;
				dolphin.acc = 0;
			}

		}
	}

	public static Point find() {
		int x = dolphin.x;
		int y = dolphin.y;
		int size = dolphin.size;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 0));
		boolean[][] visit = new boolean[N][N];
		visit[y][x] = true;
		PriorityQueue<Point> priority = new PriorityQueue<Point>(new BestOrder());
		int minD = Integer.MAX_VALUE;
		boolean flag = false;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + mx[i];
				int nextY = cur.y + my[i];

				if (minD < cur.d + 1) {
					flag = true;
					break;
				}

				if (isSafe(nextX, nextY) && !visit[nextY][nextX]) {
					visit[nextY][nextX] = true;
					if (map[nextY][nextX] <= size) {
						if (map[nextY][nextX] != 0 && map[nextY][nextX] < size) {
							if (cur.d + 1 < minD) {
								minD = cur.d + 1;
							}
							priority.add(new Point(nextX, nextY, cur.d + 1));
						} else {
							q.add(new Point(nextX, nextY, cur.d + 1));
						}
					}
				}
			}
			if (flag) {
				break;
			}
		}
		return priority.poll();
	}

	public static boolean isSafe(int x, int y) {
		if (x < 0 || N <= x || y < 0 || N <= y) {
			return false;
		}
		return true;
	}
}

class BestOrder implements Comparator<Point> {
	public int compare(Point o1, Point o2) {
		if (o1.y == o2.y) {
			return o1.x - o2.x;
		}
		return o1.y - o2.y;
	}

}

class Point {
	int x;
	int y;
	int d;

	public Point(int x, int y, int d) {
		super();
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

class Dolphin {
	int x;
	int y;
	int size;
	int acc;

	public Dolphin(int x, int y, int size, int acc) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
		this.acc = acc;
	}
}