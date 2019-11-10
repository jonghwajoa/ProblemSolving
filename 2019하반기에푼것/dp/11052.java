import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] inputs = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i] = inputs[i];
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (dp[i] < dp[i - j] + inputs[j]) {
					dp[i] = dp[i - j] + inputs[j];
				}
			}
		}
		System.out.println(dp[N]);
	}
}
