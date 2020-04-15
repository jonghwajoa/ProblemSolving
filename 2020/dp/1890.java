import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    final int N = atoi(br.readLine());

    long[][] dp = new long[N][N];

    dp[0][0] = 1;
    for (int y = 0; y < N; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < N; x++) {
        int v = atoi(st.nextToken());
        if (v == 0) {
          break;
        }
        if (dp[y][x] == 0) {
          continue;
        }

        if (y + v < N) {
          dp[y + v][x] += dp[y][x];
        }

        if (x + v < N) {
          dp[y][x + v] += dp[y][x];
        }

      }
    }

    System.out.println(dp[N - 1][N - 1]);
  }

  private static int atoi(String string) {
    return Integer.parseInt(string);
  }
}
