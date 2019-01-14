package temp;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n + 1];
		int m = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			d[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(d, a, b);
		}

		int ans = 0;
		int root = find(d, 1);
		for (int i = 2; i <= n; i++) {
			if (find(d, i) == root)
				ans++;
		}
		System.out.println(ans);

		System.out.println(Arrays.toString(d));
	}

	public static void union(int[] d, int x, int y) {
		x = find(d, x);
		y = find(d, y);
		if (x != y) {
			d[y] = x;
		}
	}

	public static int find(int[] d, int x) {
		if (d[x] == x) {
			return x;
		}
		return d[x] = find(d, d[x]);
	}
}