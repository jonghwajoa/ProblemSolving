import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	final static String NEW_LINE = "\n";
	static int[] depth;
	static int[][] parent;
	static int K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = atoi(br.readLine());
		K = 0;
		for (int i = N; 0 < i; i /= 2) {
			K += 1;
		}

		parent = new int[K + 1][N + 1];
		depth = new int[N + 1];
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = atoi(st.nextToken());
			int b = atoi(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		Arrays.fill(depth, -1);
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		depth[1] = 0;

		while (!q.isEmpty()) {
			int n = q.poll();
			for (int v : list[n]) {
				if (depth[v] == -1) {
					depth[v] = depth[n] + 1;
					q.add(v);
					parent[0][v] = n;
				}
			}
		}

		for (int k = 1; k < K; k++) {
			for (int v = 2; v <= N; v++) {
				parent[k][v] = parent[k - 1][parent[k - 1][v]];
			}
		}

		int M = atoi(br.readLine());

		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = atoi(st.nextToken());
			int b = atoi(st.nextToken());
			ans.append(getLCA(a, b)).append(NEW_LINE);
		}
		System.out.println(ans.toString());
	}

	private static int getLCA(int a, int b) {
		if (depth[b] < depth[a]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		int sub = depth[b] - depth[a];

		for (int i = 0; sub != 0; i++) {
			if (sub % 2 == 1) {
				b = parent[i][b];
			}
			sub /= 2;
		}

		if (a != b) {
			for (int i = K; 0 <= i; i--) {
				if (parent[i][a] != parent[i][b]) {
					a = parent[i][a];
					b = parent[i][b];
				}
			}

			a = parent[0][a];
		}
		return a;

	}

	private static int atoi(String string) {
		return Integer.parseInt(string);
	}
}
