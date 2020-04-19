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

    final int N = atoi(st.nextToken());
    final int K = atoi(st.nextToken());

    int[] coins = new int[N];
    for (int i = 0; i < N; i++) {
      coins[i] = atoi(br.readLine());
    }

    int[] dp = new int[K + 1];
    Arrays.fill(dp, -1);
    dp[0] = 0;

    for (int i = 0; i < N; i++) {
      for (int v = coins[i]; v <= K; v++) {
        if (dp[v - coins[i]] != -1) {
          if (dp[v] == -1 || dp[v - coins[i]] + 1 < dp[v]) {
            dp[v] = dp[v - coins[i]] + 1;
          }
        }
      }
    }
    System.out.println(dp[K]);
  }

  private static int atoi(String string) {
    return Integer.parseInt(string);
  }
}
