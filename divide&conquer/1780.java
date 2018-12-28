import java.io.*;

public class Main {
	static int[][] matrix;
	static int[] count = new int[3];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.valueOf(input[j]);
			}
		}

		solve(0, 0, N);

		for (int val : count) {
			System.out.println(val);
		}
	}

	public static void solve(int x, int y, int n) {
		if (isEqual(x, y, n)) {
			count[matrix[y][x] + 1]++;
			return;
		}

		int m = n / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				solve(x + j * m, y + i * m, m);
			}
		}

	}

	public static boolean isEqual(int x, int y, int n) {
		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if (matrix[y][x] != matrix[i][j])
					return false;
			}
		}
		return true;
	}
}