
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static boolean[] isVisit;
	static int[] color;
	static ArrayList<Integer>[] a;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();

		while (repeat-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			color = new int[n + 1];
			a = (ArrayList<Integer>[]) new ArrayList[n + 1];

			for (int i = 0; i <= n; i++) {
				a[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < m; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				a[u].add(v);
				a[v].add(u);
			}

			for (int i = 1; i <= n; i++) {
				if (color[i] == 0) {
					bfs(i);
					// dfs(i, 1);
				}
			}

			boolean isBreak = false;
			for (int i = 1; i <= n; i++) {
				for (int x : a[i]) {
					if (color[i] == color[x]) {
						isBreak = true;
						break;
					}
				}
				if (isBreak) {
					break;
				}
			}

			if (isBreak)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}

	public static void dfs(int index, int col) {
		color[index] = col;
		for (int y : a[index]) {
			if (color[y] == 0) {
				dfs(y, 3 - col);
			}
		}
	}

	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		color[start] = 1;

		while (!q.isEmpty()) {
			int x = q.poll();
			for (int y : a[x]) {
				if (color[y] == 0) {
					q.add(y);
					color[y] = 3 - color[x];
				}
			}
		}
	}
}
