package temp;

import java.util.*;

public class Main {
	static int[][] complex;
	static int[][] isLand;
	static int[] point_x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] point_y = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (x == 0 && y == 0)
				break;
			int count = 0;
			isLand = new int[y][x];
			complex = new int[y][x];

			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					isLand[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (complex[i][j] == 0 && isLand[i][j] == 1) {
						dfs(j, i, ++count, x, y);
					}
				}
			}

			System.out.println(count);
		}
	}

	public static void dfs(int x, int y, int count, int max_x, int max_y) {
		complex[y][x] = count;
		for (int i = 0; i < 8; i++) {
			int dx = x + point_x[i];
			int dy = y + point_y[i];

			if (0 <= dx && 0 <= dy && dx < max_x && dy < max_y) {
				if (complex[dy][dx] == 0 && isLand[dy][dx] == 1) {
					dfs(dx, dy, count, max_x, max_y);
				}
			}
		}
	}
}
