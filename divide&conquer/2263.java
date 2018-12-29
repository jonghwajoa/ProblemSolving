import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] inOrder;
	static int[] postOrder;
	static int[] position;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		inOrder = new int[100000];
		postOrder = new int[100000];
		position = new int[100001];

		for (int i = 0; i < N; i++) {
			inOrder[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			postOrder[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			position[inOrder[i]] = i;
		}

		solve(0, N - 1, 0, N - 1);
		System.out.println(sb);
	}

	public static void solve(int inStart, int inEnd, int postStart, int postEnd) {
		if (inEnd < inStart || postEnd < postStart) {
			return;
		}

		int root = postOrder[postEnd];

		sb.append(root + " ");
		int rootIdx = position[root];
		int left = rootIdx - inStart;
		solve(inStart, rootIdx - 1, postStart, postStart + left - 1);
		solve(rootIdx + 1, inEnd, postStart + left, postEnd - 1);
	}
}
