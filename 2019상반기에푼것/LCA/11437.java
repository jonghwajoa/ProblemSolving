import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		List<Integer>[] list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			list[a].add(b);
			list[b].add(a);
		}

		int[] depth = new int[n + 1];
		boolean[] check = new boolean[n + 1];
		int[] parent = new int[n + 1];

		int start = 1;
		depth[start] = 0;
		parent[start] = 0;
		check[start] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int y : list[cur]) {
				if (check[y] == false) {
					parent[y] = cur;
					depth[y] = depth[cur] + 1;
					check[y] = true;
					q.add(y);
				}
			}
		}

		int m = sc.nextInt();

		while (m-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			if (depth[x] < depth[y]) {
				int tmp = x;
				x = y;
				y = tmp;
			}

			while (depth[x] != depth[y]) {
				x = parent[x];
			}

			while (x != y) {
				x = parent[x];
				y = parent[y];
			}

			System.out.println(x);
		}
	}
}
