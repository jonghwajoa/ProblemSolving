import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	final static String NEW_LINE = "\n";
	static int[] tree;
	final static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = atoi(st.nextToken());
		int M = atoi(st.nextToken());
		int H = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		int SIZE = (int) Math.pow(2, H);
		tree = new int[SIZE];
		Arrays.fill(tree, INF);
		int s = 1;
		while (s < N) {
			s *= 2;
		}

		for (int i = s; i < s + N; i++) {
			tree[i] = atoi(br.readLine());
		}

		for (int i = s - 1; 0 < i; i--) {
			tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
		}

		StringBuilder ansSB = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = atoi(st.nextToken());
			int end = atoi(st.nextToken());
			int ans = search(s + start - 1, s + end - 1);
			ansSB.append(ans).append(NEW_LINE);
		}
		System.out.println(ansSB.toString());
	}

	private static int search(int s, int e) {
		int min = Integer.MAX_VALUE;

		while (s <= e) {
			if (s % 2 == 1) {
				min = Math.min(min, tree[s]);
			}

			if (e % 2 == 0) {
				min = Math.min(min, tree[e]);
			}

			s = (s + 1) >> 1;
			e = (e - 1) >> 1;
		}

		return min;
	}

	private static int atoi(final String string) {
		return Integer.parseInt(string);
	}
}
