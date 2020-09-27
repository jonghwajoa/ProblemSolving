import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		final int T = atoi(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = atoi(st.nextToken());
			int K = atoi(st.nextToken());

			int[][] inputs = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				inputs[i][0] = atoi(st.nextToken());
				inputs[i][1] = atoi(st.nextToken());
			}

			PriorityQueue<Pair> minPq = new PriorityQueue<>(new MinOrder());
			PriorityQueue<Pair> maxPq = new PriorityQueue<>(new MaxOrder());
			int ansNo = 0;
			int ans = Integer.MAX_VALUE;

			for (int i = 0; i < K - 1; i++) {
				minPq.add(new Pair(inputs[i][0], i));
				maxPq.add(new Pair(inputs[i][1], i));
			}

			for (int i = K - 1; i < N; i++) {
				minPq.add(new Pair(inputs[i][0], i));
				maxPq.add(new Pair(inputs[i][1], i));
				int range = i - K + 1;

				checkPqIndex(minPq, range);
				checkPqIndex(maxPq, range);
				Pair max = maxPq.poll();
				Pair min = minPq.poll();

				checkPqIndex(minPq, range);
				checkPqIndex(maxPq, range);
				Pair max2 = maxPq.peek();
				Pair min2 = minPq.peek();

				if (max.index == min.index) {
					int diff = max2.value - min2.value;
					if (diff < ans) {
						ans = diff;
						ansNo = max.index;
					}
				} else {
					int minDiff = min2.value - min.value;
					int maxDiff = max.value - max2.value;
					if (minDiff == maxDiff) {
						int diff = max2.value - min.value;
						if (diff < ans) {
							ans = diff;
							ansNo = Math.min(min.index, max.index);
						}
					} else if (minDiff > maxDiff) {
						int diff = max.value - min2.value;
						if (diff < ans) {
							ans = diff;
							ansNo = min.index;
						}
					} else if (minDiff < maxDiff) {
						int diff = max2.value - min.value;
						if (diff < ans) {
							ans = diff;
							ansNo = max.index;
						}
					}
				}
			}
			bw.write("#" + tc + " " + ansNo + " " + ans + " " + "\n");
		}

		bw.flush();
		bw.close();
	}

	private static void checkPqIndex(PriorityQueue<Pair> pq, int K) {
		while (!pq.isEmpty() && pq.peek().index < K) {
			pq.poll();
		}
	}

	private static int atoi(String value) {
		return Integer.parseInt(value);
	}
}

class MaxOrder implements Comparator<Pair> {

	@Override
	public int compare(Pair o1, Pair o2) {
		if (o1.value == o2.value) {
			return o1.index - o2.index;
		}
		return o2.value - o1.value;
	}

}

class MinOrder implements Comparator<Pair> {

	@Override
	public int compare(Pair o1, Pair o2) {
		if (o1.value == o2.value) {
			return o1.index - o2.index;
		}
		return o1.value - o2.value;
	}

}

class Pair {
	int value;
	int index;

	public Pair(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}

}