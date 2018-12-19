
import java.util.*;

public class Main {

	static boolean[] isVisit;
	static int[] array;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();
		while (repeat-- > 0) {
			int n = sc.nextInt();
			int ans = 0;
			array = new int[n + 1];
			isVisit = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				array[i] = sc.nextInt();
			}

			for (int i = 1; i <= n; i++) {
				if (!isVisit[i]) {
					//dfs(i);
					bfs(i);
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

	public static void dfs(int x) {
		if (isVisit[x])
			return;
		isVisit[x] = true;
		dfs(array[x]);
	}

	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);

		while (!q.isEmpty()) {
			int x = q.poll();
			isVisit[x] = true;

			if (!isVisit[array[x]]) {
				q.add(array[x]);
			}
		}
	}
}
