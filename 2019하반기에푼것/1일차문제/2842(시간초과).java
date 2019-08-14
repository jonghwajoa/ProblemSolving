import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	final static int[] mx = { -1, 0, 1, -1, 1, -1, 0, 1 };
	final static int[] my = { -1, -1, -1, 0, 0, 1, 1, 1 };
	final static int FIELD = 0, POST = 1, HOUSE = 2;
	final static String SPACE = " ";
	static Point start;
	static int ans = Integer.MAX_VALUE;
	static int N, houseN = 0;
	static boolean[][] isVisit;
	static int[][] value, map;

	public static void main(String[] argv) throws Exception {
		getReadLine();

		final int startFirodo = value[start.y][start.x];
		isVisit = new boolean[N][N];

		dfs(start.x, start.y, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		System.out.println(ans);
	}

	private static void dfs(int curX, int curY, int accCnt, int min, int max) {
		int firodo = value[curY][curX];
		if (ans < max - min) {
			return;
		}

		if (firodo < min) {
			min = firodo;
		}

		if (max < firodo) {
			max = firodo;
		}

		if (map[curY][curX] == HOUSE) {
			accCnt += 1;
		}

		if (houseN <= accCnt) {
			int diff = max - min;
			if (diff < ans) {
				ans = diff;
			}
			return;
		}

		for (int i = 0; i < 8; i++) {
			int nextX = curX + mx[i];
			int nextY = curY + my[i];

			if (isSafePoint(nextX, nextY) && !isVisit[nextY][nextX]) {
				isVisit[nextY][nextX] = true;
				dfs(nextX, nextY, accCnt, min, max);
				isVisit[nextY][nextX] = false;
			}
		}
	}

	private static boolean isSafePoint(int x, int y) {
		return (0 <= x && x < N && 0 <= y && y < N) ? true : false;
	}

	private static void getReadLine() throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		value = new int[N][N];
		map = new int[N][N];

		for (int y = 0; y < N; y++) {
			int x = 0;
			for (char c : br.readLine().toCharArray()) {
				if (c == 'P') {
					start = new Point(x, y);
					map[y][x] = POST;
				} else if (c == 'K') {
					map[y][x] = HOUSE;
					houseN += 1;
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