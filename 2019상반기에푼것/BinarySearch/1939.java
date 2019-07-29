import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Bridge>[] list;
	static int[] isVisit;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split("\\s");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int[] volume = new int[M];
		list = (ArrayList<Bridge>[]) new ArrayList[N + 1];
		isVisit = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Bridge>();
		}

		for (int i = 0; i < M; i++) {
			line = br.readLine().split("\\s");
			int A = Integer.parseInt(line[0]);
			int B = Integer.parseInt(line[1]);
			int C = Integer.parseInt(line[2]);
			list[A].add(new Bridge(B, C));
			list[B].add(new Bridge(A, C));
			volume[i] = C;

		}
		Arrays.sort(volume);

		line = br.readLine().split("\\s");
		int start = Integer.parseInt(line[0]);
		int end = Integer.parseInt(line[1]);
		int l = 0;
		int r = M - 1;
		int ans = 0;
		int visitCount = 1;

		while (l <= r) {
			int mid = (l + r) / 2;
			int base = volume[mid];

			if (bfs(base, start, end, visitCount)) {
				if (ans < base) {
					ans = base;
				}
				l = mid + 1;
			} else {
				r = mid - 1;
			}
			visitCount++;
		}
		System.out.println(ans);
	}

	public static boolean bfs(int baseVal, int start, int end, int count) {
		Queue<Bridge> q = new LinkedList<Bridge>();
		q.add(new Bridge(start, baseVal));
		isVisit[start] = count;

		while (!q.isEmpty()) {
			Bridge cur = q.poll();
			if (cur.v == end)
				return true;
			for (Bridge val : list[cur.v]) {
				if (isVisit[val.v] != count && baseVal <= val.e) {
					q.add(new Bridge(val.v, val.e));
					isVisit[val.v] = count;
				}
			}
		}
		return false;
	}
}

class Bridge {
	int v;
	int e;

	public Bridge(int v, int e) {
		this.v = v;
		this.e = e;
	}
}