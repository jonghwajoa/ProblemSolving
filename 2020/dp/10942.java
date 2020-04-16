import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  final static String NEW_LINE = "\n";

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    final int N = atoi(br.readLine());

    st = new StringTokenizer(br.readLine());

    int[] inputs = new int[N];
    boolean[][] dp = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      inputs[i] = atoi(st.nextToken());
      dp[i][i] = true;
    }

    for (int i = 0; i < N - 1; i++) {
      if (inputs[i] == inputs[i + 1]) {
        dp[i][i + 1] = true;
      }
    }

    for (int k = 2; k < N; k++) {
      for (int j = 0; j < N - k; j++) {
        int e = j + k;

        if (inputs[j] == inputs[e] && dp[j + 1][e - 1]) {
          dp[j][e] = true;
        }
      }
    }

    int M = atoi(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int s = atoi(st.nextToken());
      int e = atoi(st.nextToken());

      sb.append(dp[s - 1][e - 1] ? 1 : 0).append(NEW_LINE);
    }

    System.out.println(sb.toString());
  }

  private static int atoi(String string) {
    return Integer.parseInt(string);
  }
}