import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split("\\s");
		int repeat = Integer.parseInt(line[0]);
		int goal = Integer.parseInt(line[1]);
		long max = 0;
		long[] val = new long[repeat];

		line = br.readLine().split("\\s");
		for (int i = 0; i < repeat; i++) {
			val[i] = Long.parseLong(line[i]);
			if (max < val[i]) {
				max = val[i];
			}
		}

		long l = 1, r = max;
		long ans = 0;
		while (l <= r) {
			long mid = (l + r) / 2;

			if (isCheck(mid, val, goal)) {
				if (ans < mid) {
					ans = mid;
				}
				l = mid + 1;
			} else {
				r = mid - 1;
			}

		}
		System.out.println(ans);
	}

	public static boolean isCheck(long n, long[] val, int count) {
		long acc = 0;
		for (int i = 0; i < val.length; i++) {
			if (val[i] > n) {
				acc += val[i] - n;
			}
		}
		return acc >= count;
	}
}