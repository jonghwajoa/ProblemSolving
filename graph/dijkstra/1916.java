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

		ArrayList<Edge>[] a = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Edge>();
			dist[i] = inf;
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

		for (int i = 1; i <= n; i++) {
			visit[from] = true;
			for (Edge v : a[from]) {
				if (dist[from] + v.cost < dist[v.ed]) {
					dist[v.ed] = dist[from] + v.cost;
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

		System.out.println(dist[to]);

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
