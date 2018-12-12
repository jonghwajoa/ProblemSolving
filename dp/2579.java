import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] val = new int[n];
		int[][] dp = new int[n][3];

		for (int i = 0; i < n; i++) {
			val[i] = sc.nextInt();
		}

		dp[0][1] = val[0];
		dp[1][1] = val[1];
		dp[1][2] = val[0] + val[1];
		
		for (int i = 2; i < n; i++) {
			dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + val[i];
			dp[i][2] = dp[i-1][1] + val[i];
		}

		System.out.println(Math.max(dp[n-1][1], dp[n-1][2]));
	}
}
