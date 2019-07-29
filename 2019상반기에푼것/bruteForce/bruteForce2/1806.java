package boj;

import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] input = new int[n + 1];

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		int l = 0, r = 0;
		int acc = input[0];
		int ans = Integer.MAX_VALUE;
		while (l <= r && r < n) {
			if (acc < m) {
				r += 1;
				acc += input[r];
			} else if (acc == m) {
				r += 1;
				acc += input[r];
				ans = Math.min(ans, r - l + 1);
			} else if (acc > m) {
				ans = Math.min(ans, r - l + 1);
				acc -= input[l];
				l++;
				if (r < l && l < n) {
					r = l;
					acc += input[r];
				}
			}
		}
		if (ans >= Integer.MAX_VALUE) {
			ans = 0;
		}
		System.out.println(ans);
	}
}