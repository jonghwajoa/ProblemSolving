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

		for (int i = 0; i < n; i++) {
			dp[i] = val[i];
			for (int j = 0; j < i; j++) {
				if (val[i] > val[j] && dp[i] < dp[j] + val[i]) {
					dp[i] = dp[j] + val[i] ;
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}