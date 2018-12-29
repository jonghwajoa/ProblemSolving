import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] Matrix;
	static int N;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		Matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				Matrix[i][j] = Integer.parseInt(line[j]);
			}
		}

		solve(N, 0, 0);
		System.out.println(sb);
	}

	public static void solve(int n, int x, int y) {
		if (isEquals(n, x, y)) {
			sb.append(Matrix[y][x]);
			return;
		}
		sb.append("(");

		int m = n / 2;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				solve(m, x + j * m, y + i * m);
			}
		}
		sb.append(")");
	}

	public static boolean isEquals(int n, int x, int y) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (Matrix[y][x] != Matrix[y + i][x + j])
					return false;
			}
		}
		return true;
	}
}
