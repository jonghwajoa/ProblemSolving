package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Bridge>[] a = (ArrayList<Bridge>[]) new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Bridge>();
		}

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			a[u].add(new Bridge(u, v, c));
			a[v].add(new Bridge(v, u, c));
		}
		boolean[] v = new boolean[n + 1];
		Cmp cmp = new Cmp();

		PriorityQueue<Bridge> q = new PriorityQueue<Bridge>(1, cmp);
		v[1] = true;
		for (Bridge b : a[1]) {
			q.add(b);
		}
		int ans = 0;

		while (!q.isEmpty()) {
			Bridge cur = q.poll();
			if (v[cur.ed] == false) {
				q.add(cur);
				ans += cur.cost;
				v[cur.ed] = true;

				for (Bridge b : a[cur.ed]) {
					q.add(b);
				}
			}
		}

		System.out.println(ans);
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