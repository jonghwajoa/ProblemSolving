import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] val = new int[n];
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			val[i] = sc.nextInt();
		}

		dp[0] = val[0];
		for (int i = 1; i < n; i++) {
			dp[i] = val[i];
			if (dp[i - 1] + val[i] > dp[i]) {
				dp[i] = dp[i - 1] + val[i];
			}
		}

		int ans = dp[0];
		for (int i = 0; i < n; i++) {
			if (ans < dp[i]) {
				ans = dp[i];
			}
		}
		System.out.println(ans);
	}
}