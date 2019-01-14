import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] d = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			d[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == 0) {
				union(d, b, c);
			} else {
				if (find(d, b) == find(d, c)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}

			}
		}
	}

	public static void union(int[] d, int x, int y) {
		x = find(d, x);
		y = find(d, y);
		d[y] = x;
	}

	public static int find(int[] d, int x) {
		if (x == d[x]) {
			return x;
		}
		return d[x] = find(d, d[x]);
	}
}