import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split("\\s");
		int repeat = Integer.parseInt(line[0]);
		int standard = Integer.parseInt(line[1]);
		int[] input = new int[repeat];
		int max = 0;

		for (int i = 0; i < repeat; i++) {
			input[i] = Integer.parseInt(br.readLine());
			if (max < input[i]) {
				max = input[i];
			}
		}

		Arrays.sort(input);

		int l = 1;
		int r = max;
		int ans = 0;

		while (l <= r) {
			int mid = (r + l) / 2;
			if (check(input, mid, standard)) {
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

	public static boolean check(int[] input, int distance, int standard) {
		int baseVal = input[0];
		int count = 1;
		for (int i = 1; i < input.length; i++) {
			if (input[i] - baseVal >= distance) {
				count++;
				baseVal = input[i];
			}
		}

		return count == standard;
	}

}