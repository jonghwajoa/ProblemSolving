import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	final static String NEW_LINE = "\n";

	static int[][] dp;
	static int[] inputs;

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		final int N = atoi(br.readLine());
		st = new StringTokenizer(br.readLine());

		inputs = new int[N];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			inputs[i] = atoi(st.nextToken());
			Arrays.fill(dp[i], -1);
			dp[i][i] = 1;
		}

		int M = atoi(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = atoi(st.nextToken());
			int e = atoi(st.nextToken());

			sb.append(go(s-1,e-1)).append(NEW_LINE);
		}

		System.out.println(sb.toString());
	}

	private static int go(int s, int e) {
		if (s == e) {
			return dp[s][e] = 1;
		}

		if (s + 1 == e) {
			return dp[s][e] = inputs[s] == inputs[e] ? 1 : 0;
		}

		if (dp[s][e] >= 0) {
			return dp[s][e];
		}

		if (inputs[s] != inputs[e]) {
			return dp[s][e] = 0;
		}

		return dp[s][e] = go(s + 1, e - 1);

	}

	private static int atoi(String string) {
		return Integer.parseInt(string);
	}
}
