import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static Pair[] lis;

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = atoi(br.readLine());
		Pair[] inputs = new Pair[N];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = atoi(st.nextToken());
			int h = atoi(st.nextToken());
			inputs[i] = new Pair(w, h);
		}

		Arrays.sort(inputs);
		lis = new Pair[N];
		lis[0] = inputs[0];
		int[] counts = new int[N];
		int count = 0;
		counts[0] = count;

		long maxSize = 0;
		for (int i = 1; i < N; i++) {
			if (lis[count].h < inputs[i].h) {
				if (lis[count].w != inputs[i].w) {
					lis[++count] = inputs[i];
					maxSize = getMax(inputs[i]);
				}
				counts[i] = count;
			} else {
				int index = binary(0, count, inputs[i].h);
				lis[index] = inputs[i];
				counts[i] = index;
				if (index == count) {
					maxSize = Math.min(maxSize, getMax(inputs[i]));
				}
			}
		}

		System.out.println(count + 1);
		System.out.println(maxSize);
	}

	private static long getMax(Pair p) {
		return (long) p.w * p.w * p.h;
	}

	private static int binary(int s, int e, int target) {
		while (s <= e) {
			int mid = (s + e) >> 1;
			if (lis[mid].h < target) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return s;
	}

	private static int atoi(String value) {
		return Integer.parseInt(value);
	}
}

class Pair implements Comparable<Pair> {
	int w;
	int h;

	public Pair(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}

	@Override
	public int compareTo(Pair o) {
		if (this.w == o.w) {
			return this.h - o.h;
		}
		return this.w - o.w;
	}

}

/**
8
1 2
2 3
3 4
5 6
18 17
19 20
20 8
21 9


4
2 3
6 4
6 5
7 6

10
2 11
2 3
6 2
6 2
6 6
7 4
18 17
19 20
20 8
21 9
*/