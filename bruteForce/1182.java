package temp;

import java.util.*;

public class Main {
	static int count = 0;
	static int target;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		target = sc.nextInt();
		int[] d = new int[n];

		for (int i = 0; i < n; i++) {
			d[i] = sc.nextInt();
		}

		dfs(d, 0, 0, 0);
		System.out.println(count);
	}

	public static void dfs(int[] d, int x, int acc, int addCount) {
		if (x == d.length) {
			if (acc == target && addCount != 0) {
				count++;
			}
			return;
		}

		dfs(d, x + 1, acc + d[x], addCount + 1);
		dfs(d, x + 1, acc, addCount);
	}
}
