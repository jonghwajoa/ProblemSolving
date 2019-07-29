package boj;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int inf = 100000001;
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] visit = new boolean[n + 1];
		int[] dist = new int[n + 1];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int[] path = new int[n + 1];

		ArrayList<Edge>[] a = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Edge>();
			dist[i] = inf;
			path[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			a[from].add(new Edge(to, cost));
		}

		int from = sc.nextInt();
		int to = sc.nextInt();
		dist[from] = 0;
		int inputFrom = from;
		for (int i = 1; i <= n; i++) {
			visit[from] = true;
			for (Edge v : a[from]) {
				if (dist[from] + v.cost < dist[v.ed]) {
					dist[v.ed] = dist[from] + v.cost;
					path[v.ed] = from;
				}
			}

			int next = inf;
			for (int j = 1; j <= n; j++) {
				if (!visit[j] && dist[j] < inf) {
					if (dist[j] < next) {
						next = dist[j];
						from = j;
					}
				}
			}
		}

		Stack<Integer> s = new Stack<Integer>();
		int x = to;
		for (int i = to; i >= 1; i--) {
			s.push(x);
			if (x == inputFrom) {
				break;
			}
			x = path[x];

		}
		System.out.println(dist[to]);
		System.out.println(s.size());

		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}
}

class Edge {
	int ed;
	int cost;

	public Edge(int ed, int cost) {
		this.ed = ed;
		this.cost = cost;
	}

}
