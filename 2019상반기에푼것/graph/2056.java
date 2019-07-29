package boj;

import java.util.*;

public class Main {
	static ArrayList<Integer>[] d;
	static int[] indegree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		d = (ArrayList<Integer>[]) new ArrayList[n + 1];
		indegree = new int[n + 1];
		int[] time = new int[n + 1];
		int[] work = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			d[i] = new ArrayList<Integer>();
		}

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			int a = sc.nextInt(); // 노동시간
			int b = sc.nextInt(); // 연관갯수
			indegree[i] = b;
			work[i] = a;

			if (b == 0) {
				q.add(i);
				time[i] = a;
			}

			for (int j = 0; j < b; j++) {
				d[sc.nextInt()].add(i);
			}
		}

		int ans = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int val : d[cur]) {
				indegree[val]--;
				if (time[val] < work[val] + time[cur]) {
					time[val] = time[cur] + work[val];
				}
				if (indegree[val] == 0) {
					q.add(val);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (ans < time[i]) {
				ans = time[i];
			}
		}
		System.out.println(ans);
	}
}