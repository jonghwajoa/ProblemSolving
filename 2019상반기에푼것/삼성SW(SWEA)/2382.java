import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	final static int UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;
	final static int[] mx = { 0, 0, 0, -1, 1 };
	final static int[] my = { 0, -1, 1, 0, 0 };

	static int N, M, K;
	static int[][] map, direction;

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		final int repeat = sc.nextInt();

		for (int tc = 1; tc <= repeat; tc += 1) {
			N = sc.nextInt();
			M = sc.nextInt(); // 격리시간
			K = sc.nextInt(); // 군집수

			map = new int[N][N];
			direction = new int[N][N];

			for (int i = 0; i < K; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				int n = sc.nextInt();
				int d = sc.nextInt();
				map[y][x] = n;
				direction[y][x] = d;
			}

			solve();
			int ans = 0;
			for (int y = 0; y < N; y += 1) {
				for (int x = 0; x < N; x += 1) {
					ans += map[y][x];
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	public static void solve() {
		int time = 0;
		
		while (time < M) {
			// 움직이고 합친다.
			int[][] nextMap = new int[N][N];
			int[][] nextDirection = new int[N][N];
			int[][] max = new int[N][N];
			for (int y = 0; y < N; y += 1) {
				for (int x = 0; x < N; x += 1) {

					if (map[y][x] != 0) {
						int curD = direction[y][x];
						int nextX = x + mx[curD];
						int nextY = y + my[curD];
						nextMap[nextY][nextX] += map[y][x];

						if (max[nextY][nextX] < map[y][x]) {
							max[nextY][nextX] = map[y][x];
							nextDirection[nextY][nextX] = curD;
						}
					}
				}
			}
			map = nextMap;
			direction = nextDirection;
			
			for (int y = 0; y < N; y += 1) {

				if (y == 0 || y == N - 1) {
					for (int x = 0; x < N; x += 1) {
						if (map[y][x] != 0) {
							map[y][x] = (int) (map[y][x] / 2);
							direction[y][x] = reverseDirection(direction[y][x]);
						}
					}
				} else {
					if (map[y][0] != 0) {
						map[y][0] = (int) (map[y][0] / 2);
						direction[y][0] = reverseDirection(direction[y][0]);
					}
					if (map[y][N - 1] != 0) {
						map[y][N - 1] = (int) (map[y][N - 1] / 2);
						direction[y][N-1] = reverseDirection(direction[y][N - 1]);
					}
				}
			}
			time += 1;
		}
	}

	public static int reverseDirection(int d) {
		int nextD = d;
		switch (d) {
		case 1:
			nextD = 2;
			break;
		case 2:
			nextD = 1;
			break;
		case 3:
			nextD = 4;
			break;
		case 4:
			nextD = 3;
			break;
		}
		return nextD;
	}
}
