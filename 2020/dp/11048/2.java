import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    final int Y = atoi(st.nextToken());
    final int X = atoi(st.nextToken());

    int[][] map = new int[Y + 1][X + 1];
    int[][] dp = new int[Y + 1][X + 1];
    for (int y = 0; y < Y; y++) {
      st = new StringTokenizer(br.readLine());

      for (int x = 0; x < X; x++) {
        map[y + 1][x + 1] = atoi(st.nextToken());
      }
    }

    for (int y = 1; y <= Y; y++) {
      for (int x = 1; x <= X; x++) {
        int v = Math.max(dp[y][x - 1], dp[y - 1][x]);
        dp[y][x] = Math.max(v, dp[y - 1][x - 1]) + map[y][x];
      }
    }

    System.out.println(dp[Y][X]);
  }

  private static int atoi(String string) {
    return Integer.parseInt(string);
  }
}
