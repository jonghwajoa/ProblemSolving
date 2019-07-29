package boj;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] time = new int[n + 1];
		ArrayList<Edge> a = new ArrayList<Edge>();
		int infinity = 100000000;
		for (int i = 1; i <= n; i++) {
			time[i] = infinity;
		}

		for (int i = 0; i < m; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int cost = sc.nextInt();
			a.add(new Edge(st, ed, cost));
		}

		time[1] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				Edge cur = a.get(j);
				if (time[cur.st] != infinity && time[cur.st] + cur.cost < time[cur.ed]) {
					time[cur.ed] = time[cur.st] + cur.cost;
					if (n == i) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			if (time[i] >= infinity) {
				System.out.println(-1);
			} else {
				System.out.println(time[i]);
			}
		}

	}
}

class Edge {
	int st;
	int ed;
	int cost;

	public Edge(int st, int ed, int cost) {
		super();
		this.st = st;
		this.ed = ed;
		this.cost = cost;
	}

}
