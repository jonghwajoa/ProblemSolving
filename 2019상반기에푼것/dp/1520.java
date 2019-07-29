import java.util.Scanner;

public class Main {
	static int[] moveX = { 0, 0, 1, -1 };
	static int[] moveY = { 1, -1, 0, 0 };
	static int[][] input;
	static int[][] d;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		input = new int[n][m];
		d = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				input[i][j] = sc.nextInt();
				d[i][j] = -1;
			}
		}

		System.out.println(dfs(0, 0, m, n));
	}

	public static int dfs(int x, int y, int m, int n) {

		if (x == m - 1 && y == n - 1) {
			return 1;
		}

		if (d[y][x] >= 0) {
			return d[y][x];
		}

		d[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			int nextX = x + moveX[i];
			int nextY = y + moveY[i];

			if (0 <= nextX && 0 <= nextY && nextX < m && nextY < n) {
				if (input[nextY][nextX] < input[y][x]) {
					d[y][x] += dfs(nextX, nextY, m, n);
				}
			}
		}

		return d[y][x];
	}
}
