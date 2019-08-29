import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] argv) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = atoi(br.readLine());

		final Person[] persons = new Person[N];
		for (int i = 0; i < N; i++) {
			persons[i] = new Person(i, atoi(br.readLine()));
		}
		Arrays.sort(persons);

		int[] order = new int[N];
		for (int i = 0; i < N; i++) {
			order[persons[i].index] = i;
		}

		StringBuilder ansSB = new StringBuilder();
		SegmentTree seg = new SegmentTree(N);
		for (int i = 0; i < N; i++) {
			ansSB.append(seg.query(1, 0, N - 1, 0, order[i]) + 1).append("\n");
			seg.update(1, 0, N - 1, order[i]);
		}
		System.out.println(ansSB);
	}

	private static int atoi(String string) {
		return Integer.parseInt(string);
	}
}

class SegmentTree {
	int[] tree;

	// 3<= N <= 500,000 , maxSize : 524,288
	public SegmentTree(int n) {
		int height = (int) Math.ceil((Math.log(n) / Math.log(2)));
		int size = (int) Math.pow(2, height + 1);
		tree = new int[size];
	}

	public void update(int root, int left, int right, int target) {
		if (target < left || right < target) {
			return;
		}
		tree[root] += 1;
		if (left != right) {
			int mid = (left + right) / 2;
			int childLeft = root * 2;
			int childRight = childLeft + 1;
			update(childLeft, left, mid, target);
			update(childRight, mid + 1, right, target);
		}
	}

	public int query(int idx, int left, int right, int findLeft, int findRight) {
		if (findRight < left || right < findLeft) {
			return 0;
		}

		if (findLeft <= left && right <= findRight) {
			return tree[idx];
		}

		int leftChild = idx * 2;
		int rightChild = leftChild + 1;
		int mid = (left + right) / 2;
		int sum = query(leftChild, left, mid, findLeft, findRight);
		return sum + query(rightChild, mid + 1, right, findLeft, findRight);
	}
}

class Person implements Comparable<Person> {
	int index;
	int speed;

	public Person(int index, int speed) {
		this.index = index;
		this.speed = speed;
	}

	@Override
	public int compareTo(Person o) {
		return o.speed - this.speed;
	}

}