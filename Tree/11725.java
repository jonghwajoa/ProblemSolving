import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int repeat = sc.nextInt();
		int[] parent = new int[repeat + 1];
		ArrayList<Integer>[] tree = (ArrayList<Integer>[]) new ArrayList[repeat + 1];

		for (int i = 1; i <= repeat; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < repeat; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			tree[n].add(m);
			tree[m].add(n);
		}

		Queue q = new LinkedList<Integer>();
		parent[1] = 999;
		q.add(1);

		while (!q.isEmpty()) {
			int cur = (int) q.poll();
			for (int val : tree[cur]) {
				if (parent[val] == 0) {
					parent[val] = cur;
					q.add(val);
				}
			}
		}

		for (int i = 2; i <= repeat; i++)
			System.out.println(parent[i]);
	}
}