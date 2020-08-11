import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	final static String NEW_LINE = "\n";
	static int[] orders;
	static int order;
	static ArrayList<Integer>[] list;

	static ArrayList<Pair> ans;

	public static void main(String[] args) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int V = atoi(st.nextToken());
		final int E = atoi(st.nextToken());
		orders = new int[V + 1];
		order = 0;

		list = new ArrayList[V + 1];
		ans = new ArrayList<>();

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			final int s = atoi(st.nextToken());
			final int e = atoi(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}

		for (int i = 1; i <= V; i++) {
			if (orders[i] == 0) {
				dfs(i, 0);
			}
		}

		StringBuilder ansSB = new StringBuilder();
		Collections.sort(ans);
		ansSB.append(ans.size()).append(NEW_LINE);

		for (Pair p : ans) {
			ansSB.append(p.x + " " + p.y).append(NEW_LINE);
		}
		System.out.println(ansSB.toString());
	}

	private static int dfs(int index, int parent) {
		orders[index] = ++order;
		int low = orders[index];

		for (int v : list[index]) {
			if (v == parent) {
				continue;
			}

			if (orders[v] == 0) {
				int childLow = dfs(v, index);
				low = Math.min(low, childLow);
				if (orders[index] < childLow) {
					int a = v;
					int b = index;
					if (a > b) {
						int tmp = a;
						a = b;
						b = tmp;
					}
					ans.add(new Pair(a, b));
				}
			} else {
				low = Math.min(low, orders[v]);
			}
		}

		return low;
	}

	private static int atoi(final String string) {
		return Integer.parseInt(string);
	}
}

class Pair implements Comparable<Pair> {
	int x;
	int y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pair o) {
		if (this.x == o.x) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}

}