package boj;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] time = new int[n + 1];
		int[] completeTime = new int[n + 1];
		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
		int[] indegree = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= n; i++) {
			time[i] = sc.nextInt();
			int next;
			while (true) {
				next = sc.nextInt();
				if (next == -1) {
					break;
				}
				a[next].add(i);
				indegree[i]++;
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				completeTime[i] = time[i];
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int val : a[cur]) {
				indegree[val]--;

				if (completeTime[val] < completeTime[cur] + time[val]) {
					completeTime[val] = completeTime[cur] + time[val];
				}

				if (indegree[val] == 0) {
					q.add(val);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.println(completeTime[i]);
		}
	}
}