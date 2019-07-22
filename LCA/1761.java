package boj;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		List<Pair>[] list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Pair>();
		}

		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			list[a].add(new Pair(b, c));
			list[b].add(new Pair(a, c));
		}

		int[] parent = new int[n + 1];
		int[] depth = new int[n + 1];
		boolean[] check = new boolean[n + 1];
		int[] cost = new int[n + 1];
		int start = 1;

		check[start] = true;
		cost[start] = 0;
		depth[start] = 0;
		parent[start] = 0;

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (Pair y : list[cur]) {
				int v = y.v;
				int c = y.c;
				if (check[v] == false) {
					cost[v] = c;
					depth[v] = depth[cur] + 1;
					check[v] = true;
					parent[v] = cur;
					q.add(v);
				}
			}
		}

		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int ans = 0;

			if (depth[a] < depth[b]) {
				int tmp = a;
				a = b;
				b = tmp;
			}

			while (depth[a] != depth[b]) {
				ans += cost[a];
				a = parent[a];
			}

			while (a != b) {
				ans += cost[a] + cost[b];
				a = parent[a];
				b = parent[b];
			}
			System.out.println(ans);
		}
	}
}

class Pair {
	int v;
	int c;

	public Pair(int v, int c) {
		super();
		this.v = v;
		this.c = c;
	}

}
