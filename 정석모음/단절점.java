import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int orderCount;
	static int[] orders;
	static boolean[] isCut;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = atoi(st.nextToken());
		int E = atoi(st.nextToken());

		orderCount = 0;
		orders = new int[V + 1];
		list = new ArrayList[V + 1];
		isCut = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = atoi(st.nextToken());
			int e = atoi(st.nextToken());
			list[e].add(s);
			list[s].add(e);
		}

		for (int i = 1; i <= V; i++) {
			if (orders[i] == 0) {
				dfs(i, true);
			}
		}

		int ans = 0;
		StringBuilder ansSB = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (isCut[i]) {
				ans += 1;
				ansSB.append(i + " ");
			}
		}
		System.out.println(ans);
		System.out.println(ansSB.toString());
	}

	private static int dfs(int index, boolean isRoot) {
		orders[index] = ++orderCount;
		int low = orders[index];

		int childCount = 0;
		for (int i : list[index]) {
			if (orders[i] == 0) {
				int childLow = dfs(i, false);
				low = Math.min(childLow, low);
				childCount += 1;
				if (orders[index] <= childLow) {
					isCut[index] = true;
				}
			} else {
				low = Math.min(low, orders[i]);
			}
		}

		if (isRoot) {
			isCut[index] = childCount >= 2 ? true : false;
		}
		return low;
	}

	private static int atoi(final String value) {
		return Integer.parseInt(value);

	}
}
