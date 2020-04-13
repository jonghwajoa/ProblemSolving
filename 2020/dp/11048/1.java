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

		int[][] map = new int[Y][X];
		int[][] dp = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());

			for (int x = 0; x < X; x++) {
				map[y][x] = atoi(st.nextToken());
			}
		}

		dp[0][0] = map[0][0];
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {

				if (y == Y - 1 && x == X - 1) {
					break;
				}

				if (x != X - 1) {
					dp[y][x + 1] = Math.max(dp[y][x + 1], dp[y][x] + map[y][x + 1]);
				}

				if (y != Y - 1) {
					dp[y + 1][x] = Math.max(dp[y + 1][x], dp[y][x] + map[y + 1][x]);
				}
			}
		}

		System.out.println(dp[Y - 1][X - 1]);
	}

	private static int atoi(String string) {
		return Integer.parseInt(string);
	}
}
