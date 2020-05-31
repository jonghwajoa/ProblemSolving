package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = atoi(st.nextToken());
		int M = atoi(st.nextToken());
		int K = atoi(st.nextToken());

		long[] inputs = new long[N];
		for (int i = 0; i < N; i++) {
			inputs[i] = atol(br.readLine());
		}

		Sagment sag = new Sagment(inputs);
		StringBuilder ansSB = new StringBuilder();

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int mod = atoi(st.nextToken());

			// b -> c로 바꾼다
			if (mod == 1) {
				int b = atoi(st.nextToken());
				long c = atol(st.nextToken());
				b -= 1;
				long diff = c - inputs[b];
				inputs[b] = c;
				sag.update(1, 0, N - 1, b, diff);
			} else {
				int b = atoi(st.nextToken());
				int c = atoi(st.nextToken());

				long ans = sag.sum(1, 0, N - 1, b - 1, c - 1);
				System.out.println(ans);
			}
		}
	}

	public static int atoi(String str) {
		return Integer.parseInt(str);
	}

	public static long atol(String str) {
		return Long.parseLong(str);
	}
}

class Sagment {
	long[] tree;

	public Sagment(long[] inputs) {
		int N = inputs.length;
		int H = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		int SIZE = (int) Math.pow(2, H);
		this.tree = new long[SIZE];
		init(1, 0, N - 1, inputs);
	}

	private void init(int index, int left, int right, long[] inputs) {
		if (left == right) {
			tree[index] = inputs[left];
			return;
		}
		int mid = (left + right) / 2;
		int lc = index * 2;
		int rc = lc + 1;

		init(lc, left, mid, inputs);
		init(rc, mid + 1, right, inputs);
		tree[index] = tree[lc] + tree[rc];
	}

	public void update(int index, int left, int right, int target, long diff) {
		if (target < left || right < target) {
			return;
		}

		tree[index] += diff;
		if (left != right) {
			int mid = (left + right) / 2;
			int lc = index * 2;
			int rc = lc + 1;

			update(lc, left, mid, target, diff);
			update(rc, mid + 1, right, target, diff);
		}

	}

	public long sum(int node, int left, int right, int findLeft, int findRight) {
		if (right < findLeft || findRight < left) {
			return 0;
		}

		if (findLeft <= left && right <= findRight) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		int lc = node * 2;
		int rc = lc + 1;

		long ls = sum(lc, left, mid, findLeft, findRight);
		long rs = sum(rc, mid + 1, right, findLeft, findRight);
		return ls + rs;
	}
}
