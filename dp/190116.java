import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] input = new int[n];
		int[][] d = new int[n][n];

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
			Arrays.fill(d[i], -1);
		}

		int m = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			int st = sc.nextInt();
			int end = sc.nextInt();
			sb.append(dfs(input, d, st - 1, end - 1) + "\n");
		}
		System.out.println(sb);
	}

	public static int dfs(int[] input, int[][] d, int st, int ed) {
		if (st == ed) {
			return 1;
		} else if (st + 1 == ed) {
			if (input[st] == input[ed]) {
				return 1;
			} else {
				return 0;
			}
		}

		if (d[st][ed] >= 0)
			return d[st][ed];

		if (input[st] != input[ed])
			return d[st][ed] = 0;
		else
			return d[st][ed] = dfs(input, d, st + 1, ed - 1);
	}
}
