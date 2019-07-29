import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[][] complex;
	static int[][] home;
	static int[] point_x = { 0, 0, 1, -1 };
	static int[] point_y = { 1, -1, 0, 0 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		home = new int[N][N];
		complex = new int[N][N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				home[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (complex[i][j] == 0 && home[i][j] == 1)
					dfs(i, j, ++count);
			}
		}

		int[] ans = new int[count];

		for (int[] low : complex) {
			for (int col : low) {
				if (col == 0)
					continue;
				ans[col-1]++;
			}
		}

		Arrays.sort(ans);
		System.out.println(count);
		for(int v : ans) {
			System.out.println(v);
		}
	}

	public static void dfs(int x, int y, int count) {
		complex[x][y] = count;
		for (int i = 0; i < 4; i++) {
			int px = x + point_x[i];
			int py = y + point_y[i];

			if (0 <= px && 0 <= py && px < N && py < N) {
				if (complex[px][py] == 0 && home[px][py] == 1) {
					dfs(px, py, count);
				}
			}
		}
	}
}


### bfs

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class Main {
	static int N;
	static int[][] complex;
	static int[][] home;
	static int[] point_x = { 0, 0, 1, -1 };
	static int[] point_y = { 1, -1, 0, 0 };

	public static void bfs(int x, int y, int count) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x, y));

		while (!q.isEmpty()) {
			Pair p = q.poll();
			complex[p.x][p.y] = count;

			for (int i = 0; i < 4; i++) {
				int dx = p.x + point_x[i];
				int dy = p.y + point_y[i];

				if (0 <= dx && 0 <= dy && dx < N && dy < N) {
					if (complex[dx][dy] == 0 && home[dx][dy] == 1) {
						q.add(new Pair(dx, dy));
					}
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		home = new int[N][N];
		complex = new int[N][N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				home[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (complex[i][j] == 0 && home[i][j] == 1)
					bfs(i, j, ++count);
			}
		}

		int[] ans = new int[count];

		for (int[] low : complex) {
			for (int col : low) {
				if (col == 0)
					continue;
				ans[col - 1]++;
			}
		}

		Arrays.sort(ans);
		System.out.println(count);
		for (int v : ans) {
			System.out.println(v);
		}
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