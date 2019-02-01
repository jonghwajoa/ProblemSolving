package boj;

import java.io.*;
import java.util.*;

import org.omg.Messaging.SyncScopeHelper;

public class Main {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		ArrayList<Integer>[] list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}

		int ans = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int returnVal = bfs(i, n, list);
			if (returnVal < min) {
				min = returnVal;
				ans = i;
			}
		}
		System.out.println(ans);
	}

	public static int bfs(int target, int n, ArrayList<Integer>[] list) {
		int ans = 0;
		boolean[] visit = new boolean[n + 1];

		Queue<Friend> q = new LinkedList();

		q.add(new Friend(target, 0));
		visit[target] = true;

		while (!q.isEmpty()) {
			Friend cur = q.poll();

			for (int e : list[cur.x]) {
				if (!visit[e]) {
					q.add(new Friend(e, cur.c + 1));
					visit[e] = true;
					ans += cur.c + 1;
				}
			}
		}
		return ans;
	}
}

class Friend {
	int x;
	int c;

	public Friend(int x, int c) {
		super();
		this.x = x;
		this.c = c;
	}

}
