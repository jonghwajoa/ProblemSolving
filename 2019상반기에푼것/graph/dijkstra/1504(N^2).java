package boj;

import java.io.*;
import java.util.*;

public class Main {
	static int inf = 1000000;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Graph>[] a = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Graph>();
		}

		for (int i = 0; i < m; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int cost = sc.nextInt();
			a[st].add(new Graph(ed, cost));
			a[ed].add(new Graph(st, cost));
		}

		int e1 = sc.nextInt();
		int e2 = sc.nextInt();

		int[] oneStart = dijkstra(1, n, a);
		int[] e1Start = dijkstra(e1, n, a);
		int[] e2Start = dijkstra(e2, n, a);

		int path1 = oneStart[e1] + e1Start[e2] + e2Start[n];
		int path2 = oneStart[e2] + e2Start[e1] + e1Start[n];
		int ans = Math.min(path1, path2);
		ans = ans > inf ? -1 : ans;

		System.out.println(ans);

	}

	public static int[] dijkstra(int start, int n, ArrayList<Graph>[] a) {
		boolean[] visit = new boolean[n + 1];
		int[] dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dist[i] = inf;
		}

		dist[start] = 0;
		for (int i = 1; i < n; i++) {
			int max = inf + 1;
			int x = -1;
			for (int j = 1; j <= n; j++) {
				if (!visit[j] && dist[j] < max) {
					x = j;
					max = dist[j];
				}
			}
			visit[x] = true;

			for (Graph g : a[x]) {
				if (dist[x] + g.cost < dist[g.ed]) {
					dist[g.ed] = dist[x] + g.cost;
				}
			}
		}
		return dist;
	}
}

class Graph {
	int ed;
	int cost;

	public Graph(int ed, int cost) {
		this.ed = ed;
		this.cost = cost;
	}

}