import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	final static String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = atoi(st.nextToken());
		int M = atoi(st.nextToken());

		boolean[][] dp = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dp[a][b] = true;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dp[i][k] && dp[k][j])
						dp[i][j] = true;
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			int count = 0;

			for (int j = 1; j <= N; j++) {
				if (i == j) {
					continue;
				}
				if (dp[i][j] || dp[j][i]) {
					count += 1;
				}
			}
			if (count == N - 1) {
				ans += 1;
			}
		}
		System.out.println(ans);
	}

	private static int atoi(String value) {
		return Integer.parseInt(value);
	}
}
