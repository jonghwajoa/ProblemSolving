import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
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
		for (int i = 0; i < N; i++) {
			int v = atoi(br.readLine());
			update(1, i, v, 0, N - 1);
		}

		StringBuilder ansSB = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = atoi(st.nextToken());
			int e = atoi(st.nextToken());
			int ans = search(1, s, e, 1, N);
			ansSB.append(ans).append(NEW_LINE);
		}
		System.out.println(ansSB.toString());
	}

	private static void update(int index, int target, int value, int left, int right) {
		if (target < left || right < target) {
			return;
		}

		tree[index] = Math.min(tree[index], value);
		if (left == right) {
			return;
		}

		int mid = (left + right) >> 1;
		int root = index << 1;
		update(root, target, value, left, mid);
		update(root + 1, target, value, mid + 1, right);
	}

	private static int search(int index, int findLeft, int findRight, int left, int right) {
		if (right < findLeft || findRight < left) {
			return INF;
		}

		if (findLeft <= left && right <= findRight) {
			return tree[index];
		}

		int root = index << 1;
		int mid = (left + right) >> 1;
		return Math.min(search(root, findLeft, findRight, left, mid),
				search(root + 1, findLeft, findRight, mid + 1, right));

	}

	private static int atoi(final String string) {
		return Integer.parseInt(string);
	}
}
