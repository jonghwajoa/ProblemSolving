package boj;

import java.util.*;

public class Main {
	static ArrayList<Integer>[] d;
	static int[] c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		d = (ArrayList<Integer>[]) new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			d[i] = new ArrayList<Integer>();
		}
		c = new int[n + 1];

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			d[a].add(b);
			c[b]++;
		}

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			if (c[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for (int val : d[cur]) {
				c[val]--;
				if (c[val] == 0) {
					q.add(val);
				}
			}
		}
		System.out.println();
	}
}