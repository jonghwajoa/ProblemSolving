import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int max = 1000000;

		int a = sc.nextInt();
		int b = sc.nextInt();
		boolean[] visit = new boolean[max];
		int[] dist = new int[max];

		if (a == b) {
			System.out.println(0);
			return;
		}

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		visit[a] = true;
		dist[a] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (0 <= cur - 1 && !visit[cur - 1]) {
				visit[cur - 1] = true;
				dist[cur - 1] = dist[cur] + 1;
				q.add(cur - 1);
			}

			if (cur + 1 < max && !visit[cur + 1]) {
				visit[cur + 1] = true;
				dist[cur + 1] = dist[cur] + 1;
				q.add(cur + 1);
			}

			if (cur * 2 < max && !visit[cur * 2]) {
				visit[cur * 2] = true;
				dist[cur * 2] = dist[cur] + 1;
				q.add(cur * 2);
			}
		}
		System.out.println(dist[b]);
	}
}