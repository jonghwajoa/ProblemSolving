import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	final static int[] mx = { -1, 0, 1, -1, 1, -1, 0, 1 };
	final static int[] my = { -1, -1, -1, 0, 0, 1, 1, 1 };
	final static int POST = 1, HOUSE = 2, FIELD = 3;
	final static ArrayList<Point> houseList = new ArrayList<>();
	final static String SPACE = " ";
	static Point start;
	static int N, stepMin;
	static boolean[][] isVisit;
	static int targetX, targetY, startFirodo;
	static int minest;
	static int[][] value;

	public static void main(String[] argv) throws Exception {
		getReadLine();
		final int startFirodo = value[start.y][start.x];

		int len = houseList.size();
		int ans = Integer.MIN_VALUE;
		minest = startFirodo;
		for (int i = 0; i < len; i++) {
			Point target = houseList.get(i);
			isVisit = new boolean[N][N];
			isVisit[start.y][start.x] = true;
			targetX = target.x;
			targetY = target.y;
			stepMin = Integer.MAX_VALUE;
			dfs(start.x, start.y, minest, startFirodo);

			if (ans < stepMin) {
				ans = stepMin;
			}
		}
		System.out.println(ans);
	}

	private static void dfs(int curX, int curY, int min, int max) {
		if (curX == targetX && curY == targetY) {
			int diff = max - min;
			if (diff < stepMin) {
				stepMin = diff;
			}

			if (min < minest) {
				minest = min;
			}
			return;
		}

		for (int i = 0; i < 8; i++) {
			int nextX = curX + mx[i];
			int nextY = curY + my[i];

			if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
				if (!isVisit[nextY][nextX]) {
					isVisit[nextY][nextX] = true;
					int nextFirodo = value[nextY][nextX];
					int nextMax = max < nextFirodo ? nextFirodo : max;
					int nextMin = nextFirodo < min ? nextFirodo : min;
					dfs(nextX, nextY, nextMin, nextMax);
					isVisit[nextY][nextX] = false;
				}
			}
		}
	}

	private static void getReadLine() throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		value = new int[N][N];

		for (int y = 0; y < N; y++) {
			int x = 0;
			for (char c : br.readLine().toCharArray()) {
				if (c == 'P') {
					start = new Point(x, y);
				} else if (c == 'K') {
					houseList.add(new Point(x, y));
				}
				x += 1;
			}
		}

		for (int y = 0; y < N; y++) {
			String[] input = br.readLine().split(SPACE);
			for (int x = 0; x < N; x++) {
				value[y][x] = Integer.parseInt(input[x]);
			}
		}
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