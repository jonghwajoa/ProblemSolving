import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  final static String NEW_LINE = "\n";
  static int[] mx = { 0, 1, 0, -1 };
  static int[] my = { -1, 0, 1, 0 };
  static int Y, X;
  static int[][] dp, inputs;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    Y = atoi(st.nextToken());
    X = atoi(st.nextToken());

    dp = new int[Y][X];
    inputs = new int[Y][X];

    for (int i = 0; i < Y; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < X; j++) {
        inputs[i][j] = atoi(st.nextToken());
        dp[i][j] = -1;
      }
    }

    System.out.println(dfs(0, 0));
  }

  private static int dfs(int x, int y) {
    if (x == X - 1 && y == Y - 1) {
      return 1;
    }

    if (dp[y][x] >= 0) {
      return dp[y][x];
    }

    dp[y][x] = 0;
    for (int i = 0; i < 4; i++) {
      int nextX = x + mx[i];
      int nextY = y + my[i];

      if (0 <= nextX && 0 <= nextY && nextX < X && nextY < Y) {
        if (inputs[nextY][nextX] < inputs[y][x]) {
          dp[y][x] += dfs(nextX, nextY);
        }
      }
    }

    return dp[y][x];
  }

  private static int atoi(String string) {
    return Integer.parseInt(string);
  }
}
