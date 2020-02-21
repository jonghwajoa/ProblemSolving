package level1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  final static String NEW_LINE = "\n";

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    final int X = atoi(br.readLine());

    if (X == 1) {
      System.out.println(0);
      return;
    } else if (X <= 3) {
      System.out.println(1);
      return;
    }

    int[] dp = new int[X + 1];
    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 1;

    for (int i = 4; i <= X; i++) {
      dp[i] = dp[i - 1] + 1;

      if (i % 2 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 2] + 1);
      }

      if (i % 3 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 3] + 1);
      }
    }
    System.out.println(dp[X]);
  }

  private static int atoi(String value) {
    return Integer.parseInt(value);
  }

}