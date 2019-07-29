import java.util.*;

public class Main {
	static int[][] d = new int[9][9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				d[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0);

	}

	public static void dfs(int r, int c) {
		if (r >= 9) {
			for (int[] y : d) {
				for (int val : y) {
					System.out.print(val + " ");
				}
				System.out.println();
			}
			System.exit(0);
		} else if (c >= 9) {
			dfs(r + 1, 0);
			return;
		}

		if (d[r][c] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (isPossi(r, c, i)) {
					d[r][c] = i;
					dfs(r, c + 1);
				}
				d[r][c] = 0;
			}
		} else {
			dfs(r, c + 1);
		}
	}

	public static boolean isPossi(int r, int c, int val) {
		int sqareX = (c / 3) * 3;
		int sqareY = (r / 3) * 3;

		for (int i = 0; i < 9; i++) {
			if (d[r][i] == val) {
				return false;
			}

			if (d[i][c] == val) {
				return false;
			}
		}

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				if (d[sqareY + y][sqareX + x] == val) {
					return false;
				}
			}
		}

		return true;
	}
}
