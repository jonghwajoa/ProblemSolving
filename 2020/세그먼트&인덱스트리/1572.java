import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	final static String NEW_LINE = "\n";
	static int[] tree;
	static int NUMBER_MAX = 65537;

	public static void main(String[] args) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int N = atoi(st.nextToken());
		final int K = atoi(st.nextToken());

		int H = (int) Math.ceil(Math.log(NUMBER_MAX) / Math.log(2)) + 1;
		int SIZE = 1 << H;
		tree = new int[SIZE];
		int s = 1;
		int mid = (int) Math.ceil((double) K / 2);
		while (s < NUMBER_MAX) {
			s *= 2;
		}

		int[] inputs = new int[N];
		for (int i = 0; i < N; i++) {
			inputs[i] = atoi(br.readLine());
		}

		for (int i = 0; i < K - 1; i++) {
			tree[s + inputs[i]] += 1;
		}

		for (int i = s - 1; 0 < i; i--) {
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}

		long ans = 0;
		for (int i = K - 1; i < N; i++) {
			int v = inputs[i];
			update(v + s, 1);
			ans += find(mid, s);
			update(s + inputs[i - K + 1], -1);
		}

		System.out.println(ans);
	}

	private static int find(int k, int s) {
		int index = 1;
		while (index < s) {
			if (k <= tree[index * 2]) {
				index *= 2;
			} else {
				k -= tree[index * 2];
				index = index * 2 + 1;
			}
		}
		return index - s;
	}

	private static void update(int index, int diff) {
		while (index != 0) {
			tree[index] += diff;
			index /= 2;
		}
	}

	private static int atoi(final String string) {
		return Integer.parseInt(string);
	}
}
