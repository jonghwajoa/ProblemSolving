import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	final static String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final StringTokenizer st = new StringTokenizer(br.readLine());

		final int N = atoi(st.nextToken());
		final int K = atoi(st.nextToken());
		int[][] dp = new int[N + 1][K + 1];

		for (int k = 1; k <= K; k++) {
			for (int i = 0; i <= N; i++) {
				dp[i][1] = 1;
				for (int l = 0; l <= i; l++) {
					dp[i][k] += dp[i - l][k - 1];
					dp[i][k] %= 1000000000;
				}
			}
		}

		System.out.println(dp[N][K]);
	}

	private static int atoi(String value) {
		return Integer.parseInt(value);
	}

}