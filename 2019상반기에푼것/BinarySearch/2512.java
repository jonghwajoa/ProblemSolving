import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n + 1];
		int acc = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
			acc += input[i];
			if (max < input[i]) {
				max = input[i];
			}

		}
		int goal = sc.nextInt();

		if (goal >= acc) {
			System.out.println(max);
			return;
		}

		int l = 1;
		int r = max;
		int ans = 0;
		while (l <= r) {
			int mid = (r + l) / 2;
			if (solve(mid, goal, input)) {
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

	public static boolean solve(int mid, int goal, int[] input) {
		int count = 0;
		int acc = 0;
		for (int e : input) {
			if (e > mid) {
				count++;
			} else {
				acc += e;
			}
		}

		return acc + (mid * count) <= goal;
	}
}
