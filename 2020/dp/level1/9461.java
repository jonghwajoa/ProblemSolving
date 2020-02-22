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
    final int T = atoi(br.readLine());

    long[] dp = new long[101];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 1;

    for (int i = 3; i <= 100; i++) {
      dp[i] = dp[i - 2] + dp[i - 3];
    }

    for (int i = 0; i < T; i++) {
      System.out.println(dp[atoi(br.readLine()) - 1]);
    }
  }

  private static int atoi(String value) {
    return Integer.parseInt(value);
  }

}