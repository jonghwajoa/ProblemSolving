import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	final static String NEW_LINE = "\n";
	static ArrayList<Integer>[] list;
	static int[] depth;
	static int[][] parent;

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int N = atoi(br.readLine());
		int K = 0;

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = N; 0 < i; i /= 2) {
			K += 1;
		}

		depth = new int[N + 1];
		parent = new int[K + 1][N + 1];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = atoi(st.nextToken());
			int b = atoi(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		int root = 1;
		fillDepth(root, N);

        for (int k = 1; k <K; k++) {
		    for (int i = 2; i <= N; i++) {
				parent[k][i] = parent[k - 1][parent[k - 1][i]];
			}
		}

		int M = atoi(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = atoi(st.nextToken());
			int b = atoi(st.nextToken());

			int diff = depth[a] - depth[b];
			if (diff < 0) {
				int tmp = a;
				a = b;
				b = tmp;
				diff *= -1;
			}

			for (int j = 0; diff != 0; j++) {
				if (diff % 2 == 1) {
					a = parent[j][a];
				}
				diff /= 2;
			}
			if (a != b) {
				for (int j = K; j >= 0; j--) {
					if (parent[j][a] != 0 && parent[j][a] != parent[j][b]) {
						a = parent[j][a];
						b = parent[j][b];
					}
				}
				a = parent[0][a];
			}

			sb.append(a).append(NEW_LINE);
		}

		System.out.println(sb.toString());
	}

	public static void fillDepth(int root, int N) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(root);
		depth[root] = 0;
		boolean[] isVisit = new boolean[N + 1];
		isVisit[root] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int n : list[cur]) {
				if (!isVisit[n]) {
					isVisit[n] = true;
					depth[n] = depth[cur] + 1;
					parent[0][n] = cur;
					q.add(n);
				}
			}
		}
	}

	public static int atoi(String string) {
		return Integer.parseInt(string);
	}
}
