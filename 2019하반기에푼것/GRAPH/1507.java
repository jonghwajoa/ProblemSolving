import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int N = Integer.parseInt(br.readLine());
		int[][] path = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				path[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean isPossible = true;
		boolean[][] notEssen = new boolean[N + 1][N + 1];
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k) {
					continue;
				}
				for (int j = 1; j <= N; j++) {
					if (j == i || j == k) {
						continue;
					}

					if (path[i][k] + path[k][j] == path[i][j]) {
						notEssen[i][j] = true;
					}

					if (path[i][k] + path[k][j] < path[i][j]) {
						isPossible = false;
						k = N + 1;
						i = N + 1;
						break;
					}
				}
			}
		}

		if (!isPossible) {
			System.out.println(-1);
		} else {
			int total = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!notEssen[i][j]) {
						total += path[i][j];
					}
				}
			}
			System.out.println(total / 2);
		}
	}
}
