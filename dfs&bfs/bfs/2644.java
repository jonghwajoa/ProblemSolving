
    package boj;

import java.io.*;
import java.util.*;

public class Main {
	static int[] moveX = { 1, 0, -1, 0 };
	static int[] moveY = { 0, 1, 0, 0 - 1 };

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p1 = sc.nextInt();
		int p2 = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer>[] a = new ArrayList[n + 1];
		boolean[] visit = new boolean[n+1];
		int[] depth = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			int b = sc.nextInt();
			int c = sc.nextInt();
			a[b].add(c);
			a[c].add(b);
		}

		Queue<Integer> q = new LinkedList();
		q.add(p1);
		visit[p1] = true;
		depth[p1] = 0;
		int ans = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int e : a[cur]) {
				if (!visit[e]) {
					if (e == p2) {
						ans = depth[cur] + 1;
						break;
					}
					visit[e] = true;
					depth[e] = depth[cur] + 1;
					q.add(e);
				}
			}
		}
		if (ans == 0) {
			System.out.println(-1);
		} else {
			System.out.println(ans);

		}
	}
}
