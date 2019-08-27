import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	final static int INF = 2000000000;
	static int B, E, P, N, M;
	static boolean[] isVisit;
	static ArrayList<Integer>[] list;

	public static void main(String[] argv) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		B = atoi(st.nextToken());
		E = atoi(st.nextToken());
		P = atoi(st.nextToken());
		N = atoi(st.nextToken());
		M = atoi(st.nextToken());

		isVisit = new boolean[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = atoi(st.nextToken());
			int e = atoi(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}

		final int bessie = 1;
		final int elsie = 2;

		long[] bessieDist = getDist(bessie);
		long[] elsieDist = getDist(elsie);
		long[] Ndist = getDist(N);

		long min = bessieDist[N] * B + elsieDist[N] * E;
		for (int i = 1; i <= N; i++) {
			min = Math.min(min, bessieDist[i] * B + elsieDist[i] * E + Ndist[i] * P);
		}
		System.out.println(min);
	}

	private static long[] getDist(int start) {
		long[] dist = new long[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		isVisit[start] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int n : list[cur]) {
				if (dist[n] == INF) {
					isVisit[n] = true;
					dist[n] = dist[cur] + 1;
					q.add(n);
				}
			}
		}
		return dist;
	}

	private static int atoi(String string) {
		return Integer.parseInt(string);
	}
}