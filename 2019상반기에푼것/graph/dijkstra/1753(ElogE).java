package boj;

import java.io.*;
import java.util.*;

public class Main {
	static int inf = 1000000;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		ArrayList<Graph>[] a = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Graph>();
		}

		for (int i = 0; i < m; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int cost = sc.nextInt();
			a[st].add(new Graph(ed, cost));
		}

		int[] dp = dijkstra(start, n, a);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (dp[i] >= inf) {
				sb.append("INF\n");
			} else {
				sb.append(dp[i] + "\n");
			}
		}
		System.out.println(sb);
	}

	public static int[] dijkstra(int start, int n, ArrayList<Graph>[] a) {
		boolean[] visit = new boolean[n + 1];
		int[] dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dist[i] = inf;
		}

		dist[start] = 0;
		PriorityQueue<Graph> q = new PriorityQueue<Graph>();
		q.add(new Graph(start, 0));

		while (!q.isEmpty()) {
			Graph cur = q.poll();
			if (visit[cur.ed]) {
				continue;
			}

			visit[cur.ed] = true;
			for (Graph next : a[cur.ed]) {
				if (dist[cur.ed] + next.cost < dist[next.ed]) {
					dist[next.ed] = dist[cur.ed] + next.cost;
					q.add(new Graph(next.ed, dist[next.ed]));
				}
			}
		}

		return dist;
	}
}

class Graph implements Comparable<Graph> {
	int ed;
	int cost;

	public Graph(int ed, int cost) {
		this.ed = ed;
		this.cost = cost;
	}

	@Override
	public int compareTo(Graph o) {
		return this.cost - o.cost;
	}

}