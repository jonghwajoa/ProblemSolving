import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] val = new int[2][n];
			{
				String[] line = br.readLine().split(" ");
				for (int i = 0; i < n; i++) {
					val[0][i] = Integer.parseInt(line[i]);
				}
			}
			{
				String[] line = br.readLine().split(" ");
				for (int i = 0; i < n; i++) {
					val[1][i] = Integer.parseInt(line[i]);
				}
			}

			int[][] dp = new int[2][n];
			dp[0][0] = val[0][0];
			dp[1][0] = val[1][0];

			for (int i = 1; i < n; i++) {
				if (i == 1) {
					dp[0][i] = dp[1][i - 1] + val[0][i];
					dp[1][i] = dp[0][i - 1] + val[1][i];
				} else {
					int max = Math.max(dp[0][i - 2], dp[1][i - 2]);
					dp[0][i] = Math.max(dp[1][i - 1], max) + val[0][i];
					dp[1][i] = Math.max(dp[0][i - 1], max) + val[1][i];
				}
			}
			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
		}
	}
}