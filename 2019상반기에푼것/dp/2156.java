import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();
		int [][]dp = new int[repeat][3];
		int []val = new int[repeat];
		for(int i=0; i< repeat; i++) {
			val[i] = sc.nextInt();
		}
		dp[0][1] = val[0];
		dp[0][2] = val[0];
		
		for(int i=1; i<repeat; i++) {
			dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][2], dp[i-1][1]));
			dp[i][1] = dp[i-1][0] + val[i];
			dp[i][2] = dp[i-1][1] + val[i];
		}
		
		System.out.println(Math.max(dp[repeat-1][0], Math.max(dp[repeat-1][1], dp[repeat-1][2])));
	}
}