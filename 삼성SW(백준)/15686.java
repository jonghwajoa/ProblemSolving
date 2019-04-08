import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	final static int EMPTY = 0, HOUSE = 1, GOD = 2;
	final static int[] mx = { 0, 1, 0, -1 };
	final static int[] my = { -1, 0, 1, 0 };

	static LinkedList<Point> godQ, houseQ, useGodQ;
	static boolean[][] visit;
	static int[][] map;
	static int N, M, ans;
	static int GOD_SIZE;

	public static void main(String args[]) throws Exception {
		final Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][N];
		visit = new boolean[N][N];
		ans = Integer.MAX_VALUE;
		godQ = new LinkedList<>();
		houseQ = new LinkedList<>();
		useGodQ = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tmp = sc.nextInt();
				if (tmp == HOUSE) {
					houseQ.add(new Point(j, i));
				} else if (tmp == GOD) {
					godQ.add(new Point(j, i));
				}
			}
		}
		GOD_SIZE = godQ.size();

		dfs(0, 0);
		System.out.println(ans);
	}

	public static void dfs(int step, int select) {
		if (select >= M) {
			cal();
			return;
		}

		if (GOD_SIZE <= step) {
			return;
		}

		Point cur = godQ.get(step);
		visit[cur.y][cur.x] = true;

		useGodQ.add(new Point(cur.x, cur.y));
		dfs(step + 1, select + 1);
		useGodQ.removeLast();

		visit[cur.y][cur.x] = false;
		dfs(step + 1, select);
	}

	public static void cal() {
		int len = houseQ.size();
		int acc = 0;
		for (int i = 0; i < len; i++) {
			Point cur = houseQ.get(i);
			acc += findGod(cur.x, cur.y);
		}

		if (acc < ans) {
			ans = acc;
		}
	}

	public static int findGod(int x, int y) {
		boolean[][] visit = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visit[y][x] = true;

		int acc = 0;
		int len = useGodQ.size();

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			Point cur = useGodQ.get(i);
			int abs = Math.abs(x - cur.x) + Math.abs(y - cur.y);
			if (abs < min) {
				min = abs;
			}
		}
		return min;
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}