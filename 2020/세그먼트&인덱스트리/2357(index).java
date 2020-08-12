import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	final static String NEW_LINE = "\n";
	static Pair[] tree;
	final static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = atoi(st.nextToken());
		int M = atoi(st.nextToken());
		int H = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		int SIZE = (int) Math.pow(2, H);
		tree = new Pair[SIZE];

		for (int i = 0; i < SIZE; i++) {
			tree[i] = new Pair();
		}

		int s = 1;
		while (s < N) {
			s *= 2;
		}

		for (int i = 0; i < N; i++) {
			int v = atoi(br.readLine());
			tree[i + s].min = v;
			tree[i + s].max = v;
		}

		for (int i = s - 1; 0 < i; i--) {
			tree[i].min = Math.min(tree[i * 2].min, tree[i * 2 + 1].min);
			tree[i].max = Math.max(tree[i * 2].max, tree[i * 2 + 1].max);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = atoi(st.nextToken());
			int b = atoi(st.nextToken());

			Pair ans = search(s + a - 1, s + b - 1);
			sb.append(ans.min + " " + ans.max).append(NEW_LINE);
		}
		System.out.println(sb.toString());
	}

	private static Pair search(int s, int e) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		while (s <= e) {
			if (s % 2 == 1) {
				min = Math.min(tree[s].min, min);
				max = Math.max(tree[s].max, max);
			}

			if (e % 2 == 0) {
				min = Math.min(tree[e].min, min);
				max = Math.max(tree[e].max, max);
			}

			s = (s + 1) >> 1;
			e = (e - 1) >> 1;
		}
		return new Pair(min, max);
	}

	private static int atoi(final String string) {
		return Integer.parseInt(string);
	}
}

class Pair {
	int min;
	int max;

	public Pair(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public Pair() {
		this.min = 1000000001;
		this.max = -1;
	}

}
