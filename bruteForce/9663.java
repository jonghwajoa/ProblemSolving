import java.util.*;

public class Main {
	static int[] colum;
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		colum = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			colum[1] = i;
			dfs(1, N);
		}
		System.out.println(ans);

	}

	public static void dfs(int r, int n) {
		if (r == n) {
			++ans;
			return;
		}

		for (int i = 1; i <= n; i++) {
			colum[r + 1] = i;
			if (check(r + 1)) {
				dfs(r + 1, n);
			} else {
				colum[r + 1] = 0;
			}
		}
		colum[r] = 0;

	}

	public static boolean check(int r) {

		for (int i = 1; i < r; i++) {
			if (colum[i] == colum[r]) {
				return false;
			}

			if (Math.abs(i - r) == Math.abs(colum[i] - colum[r])) {
				return false;
			}
		}
		return true;
	}

}