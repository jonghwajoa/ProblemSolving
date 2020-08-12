import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	final static String NEW_LINE = "\n";
	static ArrayList<Bus>[] list;

	public static void main(String[] args) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		final int N = atoi(br.readLine());
		final int M = atoi(br.readLine());

		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = atoi(st.nextToken());
			int e = atoi(st.nextToken());
			int c = atoi(st.nextToken());
			list[s].add(new Bus(e, c));
		}
		st = new StringTokenizer(br.readLine());
		final int start = atoi(st.nextToken());
		final int end = atoi(st.nextToken());
		int min = dijkstra(start, end, N);
		System.out.println(min);
	}

	private static int dijkstra(int s, int e, int N) {
		int[] dist = new int[N + 1];
		boolean[] isVisit = new boolean[N + 1];
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);

		PriorityQueue<Integer> pq = new PriorityQueue<>((b1, b2) -> dist[b1] - dist[b2]);
		dist[s] = 0;
		pq.add(s);

		while (!pq.isEmpty()) {
			int cur = pq.poll();

			if (isVisit[cur]) {
				continue;
			}

			isVisit[cur] = true;
			for (Bus b : list[cur]) {
				if (b.c + dist[cur] < dist[b.e]) {
					dist[b.e] = b.c + dist[cur];
					pq.add(b.e);
				}
			}
		}

		return dist[e];
	}

	private static int atoi(final String string) {
		return Integer.parseInt(string);
	}

}

class Bus {
	int e;
	int c;

	public Bus(int e, int c) {
		this.e = e;
		this.c = c;
	}
}