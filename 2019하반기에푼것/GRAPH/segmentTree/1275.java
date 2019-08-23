import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	final static String ENTER = "\n";

	public static void main(String[] argv) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = stoi(st.nextToken());
		final int Q = stoi(st.nextToken());

		final long[] input = new long[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			input[i] = stol(st.nextToken());
		}

		StringBuilder ansSB = new StringBuilder();
		SegmentTree seg = new SegmentTree(input);

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			// x~y까지의 합,, a번쨰 수를 b로 바꾸어라.. update;
			int x = stoi(st.nextToken()) - 1;
			int y = stoi(st.nextToken()) - 1;
			int a = stoi(st.nextToken()) - 1;
			int b = stoi(st.nextToken());
			if (y < x) {
				int tmp = x;
				x = y;
				y = tmp;
			}

			long res = seg.query(1, 0, N - 1, x, y);
			ansSB.append(res).append(ENTER);
			long diff = b - input[a];
			seg.update(1, 0, N - 1, a, diff);
			input[a] = b;
		}
		System.out.println(ansSB);
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static long stol(String s) {
		return Long.parseLong(s);
	}
}

class SegmentTree {
	long[] input;
	long[] tree;

	public SegmentTree(long[] input) {
		this.input = input;
		int len = input.length;
		int depth = (int) Math.ceil(Math.log(len) / Math.log(2));
		int height = depth + 1;
		int MAX_TREE_LEN = (int) Math.pow(2, height);
		this.tree = new long[MAX_TREE_LEN];
		this.makeSeg(1, 0, len - 1);
	}

	private void makeSeg(int root, int left, int right) {
		if (left == right) {
			tree[root] = input[left];
			return;
		}

		int childLeft = root * 2;
		int childRgiht = childLeft + 1;
		int mid = (left + right) / 2;
		makeSeg(childLeft, left, mid);
		makeSeg(childRgiht, mid + 1, right);
		tree[root] = tree[childLeft] + tree[childRgiht];
	}

	public long query(int root, int left, int right, int findLeft, int findRight) {
		if (findRight < left || right < findLeft) {
			return 0;
		}

		if (findLeft <= left && right <= findRight) {
			return tree[root];
		}

		int childLeft = root * 2;
		int childRight = childLeft + 1;
		int mid = (left + right) / 2;
		long sum = query(childLeft, left, mid, findLeft, findRight);
		return sum + query(childRight, mid + 1, right, findLeft, findRight);
	}

	public void update(int root, int left, int right, int target, long diff) {
		if (target < left || right < target) {
			return;
		}
		tree[root] += diff;
		if (left != right) {
			int mid = (left + right) / 2;
			int childLeft = root * 2;
			int childRight = childLeft + 1;
			update(childLeft, left, mid, target, diff);
			update(childRight, mid + 1, right, target, diff);
		}
	}

	public void print() {
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(tree));
	}
}