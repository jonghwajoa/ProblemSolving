import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	final static String ENTER = "\n";
	final static int INF = 987654321;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		final int T = atoi(br.readLine());

		for (int tc = 1; tc <= T; tc += 1) {
			st = new StringTokenizer(br.readLine());
			int N = atoi(st.nextToken());
			int M = atoi(st.nextToken());
			int W = atoi(st.nextToken());

			ArrayList<Street> list = new ArrayList<>();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = atoi(st.nextToken());
				int end = atoi(st.nextToken());
				int cost = atoi(st.nextToken());

				list.add(new Street(start, end, cost));
				list.add(new Street(end, start, cost));
			}

			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int start = atoi(st.nextToken());
				int end = atoi(st.nextToken());
				int cost = atoi(st.nextToken());
				list.add(new Street(start, end, cost * -1));
			}
			dist = new int[N + 1];
			Arrays.fill(dist, INF);
			dist[1] = 0;

			boolean isCycle = false;
			for (int i = 1; i <= N; i++) {
				for (Street street : list) {
					if (dist[street.src] + street.cost < dist[street.dest]) {
						dist[street.dest] = dist[street.src] + street.cost;
						if (i == N) {
							isCycle = true;
							break;
						}
					}
				}
			}

			System.out.println(isCycle ? "YES" : "NO");
		}
	}

	private static int atoi(String string) {
		return Integer.parseInt(string);
	}

}

class Street {
	int src;
	int dest;
	int cost;

	public Street(int src, int dest, int cost) {
		this.src = src;
		this.dest = dest;
		this.cost = cost;
	}

}