import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][]dp = new int[n+1][10];
		Arrays.fill(dp[1], 1);
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				for(int k=0; k<=j; k++) {
				dp[i][j] += dp[i-1][k];
				dp[i][j] %= 10007;
				}
			}
		}
		System.out.println(IntStream.of(dp[n]).sum()%10007);
	}
}
