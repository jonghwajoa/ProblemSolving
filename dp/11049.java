import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Pair[] d = new Pair[n];
		int[][] c = new int[n][n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			d[i] = new Pair(x, y);
			Arrays.fill(c[i], -1);
		}

		System.out.println(dfs(d, c, 0, n - 1));
	}

	private static int dfs(Pair[] d, int[][] c, int l, int r) {
		if (c[l][r] != -1) {
			return c[l][r];
		}

		if (l == r) {
			return c[l][r] = 0;
		} else if (l + 1 == r) {
			return c[l][r] = d[l].x * d[l].y * d[r].y;
		}

		for (int i = l; i < r; i++) {
			int leftVal = dfs(d, c, l, i);
			int rightVal = dfs(d, c, i + 1, r);
			int mulVal = d[l].x * d[i].y * d[r].y;

			if (c[l][r] == -1 || c[l][r] > leftVal + rightVal + mulVal) {
				c[l][r] = leftVal + rightVal + mulVal;
			}
		}

		return c[l][r];
	}
}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}