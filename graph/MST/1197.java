package boj;

import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		parent = new int[n + 1];
		ArrayList<Bridge> a = new ArrayList<Bridge>();

		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= m; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int cost = sc.nextInt();
			a.add(new Bridge(st, ed, cost));
		}
		Cmp cmp = new Cmp();
		Collections.sort(a, cmp);

		int ans = 0;
		for (int i = 0; i < m; i++) {
			Bridge cur = a.get(i);
			int x = find(cur.st);
			int y = find(cur.ed);
			if (x != y) {
				union(x, y);
				ans += cur.cost;
			}
		}
		System.out.println(ans);
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parent[x] = y;
	}
}

class Cmp implements Comparator<Bridge> {
	@Override
	public int compare(Bridge o1, Bridge o2) {
		return o1.cost - o2.cost;
	}
}

class Bridge {
	int st;
	int ed;
	int cost;

	public Bridge(int st, int ed, int cost) {
		this.st = st;
		this.ed = ed;
		this.cost = cost;
	}
}