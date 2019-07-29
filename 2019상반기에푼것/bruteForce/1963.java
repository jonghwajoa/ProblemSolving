package temp;

import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean[] prime = new boolean[10001];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		for (int i = 2; i <= 10000; i++) {
			if (!prime[i])
				continue;

			for (int j = i * i; j <= 10000; j += i) {
				prime[j] = false;
			}
		}


		int n = sc.nextInt();

		while (n-- > 0) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			boolean[] visit = new boolean[10001];
			int[] dist = new int[10001];

			if (start == end) {
				System.out.println(0);
				continue;
			}

			Queue<Integer> q = new LinkedList<Integer>();
			q.add(start);
			dist[start] = 0;
			visit[start] = true;

			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 10; j++) {
						int next = change(cur, i, j);
						if (next == -1)
							continue;
						if (prime[next] && !visit[next]) {
							dist[next] = dist[cur] + 1;
							visit[next] = true;
							q.add(next);
						}
					}
				}
			}
			System.out.println(dist[end]);
		}
	}

	public static int change(int n, int i, int j) {
		if (i == 0 && j == 0) {
			return -1;
		}
		StringBuilder sb = new StringBuilder(Integer.toString(n));
		sb.setCharAt(i, (char) (j + '0'));
		return Integer.parseInt(sb.toString());
	}
}
