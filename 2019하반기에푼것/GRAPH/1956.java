import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		final int INF = 400 * 10000 + 1;
		int[][] path = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(path[i], INF);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (path[s][e] == INF) {
				path[s][e] = c;
			} else if (c < path[s][e]) {
				path[s][e] = c;
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (path[i][k] + path[k][j] < path[i][j]) {
						path[i][j] = path[i][k] + path[k][j];
					}
				}
			}
		}

		int ans = -1;
		for (int i = 1; i <= N; i++) {
			if (path[i][i] != INF) {
				if (ans == -1 || path[i][i] < ans) {
					ans = path[i][i];
				}
			}
		}

		System.out.println(ans);
	}
}
