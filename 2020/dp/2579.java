package Main;

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
    final int[] inputs = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      inputs[i] = atoi(br.readLine());
    }

    int[][] dp = new int[N + 1][3];

    for (int i = 1; i <= N; i++) {
      if (i > 1) {
        dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + inputs[i];
      } else if (i == 1) {
        dp[i][1] = inputs[i];
      }
      dp[i][2] = dp[i - 1][1] + inputs[i];
    }

    System.out.println(Math.max(dp[N][1], dp[N][2]));
  }

  private static int atoi(String string) {
    return Integer.parseInt(string);
  }
}
