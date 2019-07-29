package temp;

import java.io.*;

public class Main {
	static int[][] tree;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int repeat = Integer.parseInt(br.readLine());
		tree = new int[repeat + 1][2];
		while (0 < repeat--) {
			String[] input = br.readLine().split("\\s");
			int idx = input[0].charAt(0) - 'A' + 1;
			if (input[1].equals(".")) {
				tree[idx][0] = 0;
			} else {
				tree[idx][0] = input[1].charAt(0) - 'A' + 1;
			}

			if (input[2].equals(".")) {
				tree[idx][1] = 0;
			} else {
				tree[idx][1] = input[2].charAt(0) - 'A' + 1;
			}
		}

		preOrder(1);
		System.out.println();
		inOrder(1);
		System.out.println();
		postOrder(1);
		System.out.println();
	}

	public static void preOrder(int idx) {
		if (idx == 0)
			return;
		System.out.print((char) (idx + 'A' - 1));
		preOrder(tree[idx][0]);
		preOrder(tree[idx][1]);
	}

	public static void inOrder(int idx) {
		if (idx == 0)
			return;
		inOrder(tree[idx][0]);
		System.out.print((char) (idx + 'A' - 1));
		inOrder(tree[idx][1]);
	}

	public static void postOrder(int idx) {
		if (idx == 0)
			return;
		postOrder(tree[idx][0]);
		postOrder(tree[idx][1]);
		System.out.print((char) (idx + 'A' - 1));
	}

}
