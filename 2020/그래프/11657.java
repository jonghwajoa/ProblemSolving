import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	final static String ENTER = "\n";
	final static long[] dist = new long[501];
	final static long INF = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());

		ArrayList<Bus>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		Arrays.fill(dist, INF);

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[src].add(new Bus(dest, cost));
		}

		int start = 1;
		dist[start] = 0;
		boolean isCycle = false;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dist[j] == INF) {
					continue;
				}

				for (Bus b : list[j]) {
					if (dist[b.ed] > dist[j] + b.cost) {
						dist[b.ed] = dist[j] + b.cost;

						if (i == N) {
							isCycle = true;
							break;
						}
					}

				}
			}
		}

		if (isCycle) {
			System.out.println(-1);
			return;
		}

		StringBuilder ansSB = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			ansSB.append(dist[i] == INF ? -1 : dist[i]).append(ENTER);
		}
		System.out.println(ansSB.toString());
	}

}

class Bus {
	int ed, cost;

	public Bus(int ed, int cost) {
		this.ed = ed;
		this.cost = cost;
	}

}
