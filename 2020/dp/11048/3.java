import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    final int Y = atoi(st.nextToken());
    final int X = atoi(st.nextToken());

    map = new int[Y + 1][X + 1];
    dp = new int[Y + 1][X + 1];
    for (int y = 0; y < Y; y++) {
      st = new StringTokenizer(br.readLine());

      for (int x = 0; x < X; x++) {
        map[y + 1][x + 1] = atoi(st.nextToken());
        dp[y + 1][x + 1] = -1;
      }
    }

    System.out.println(go(X, Y));
  }

  private static int atoi(String string) {
    return Integer.parseInt(string);
  }

  static int go(int x, int y) {
    if (x < 0 || y < 0) {
      return 0;
    }

    if (x == 1 && y == 1) {
      return map[y][x];
    }
    if (dp[y][x] >= 0) {
      return dp[y][x];
    }

    dp[y][x] = go(x, y - 1) + map[y][x];
    int temp = go(x - 1, y) + map[y][x];
    if (dp[y][x] < temp) {
      dp[y][x] = temp;
    }

    return dp[y][x];
  }
}
