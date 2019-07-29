package boj;

import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		boolean[] prime = new boolean[n + 1];
		ArrayList<Integer> p = new ArrayList<Integer>();
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;

		for (int i = 2; i <= n; i++) {
			if (prime[i] == false) {
				continue;
			}

			p.add(i);
			for (int j = i + i; j <= n; j += i) {
				prime[j] = false;
			}
		}

		int l = 0;
		int r = 0;
		int size = p.size();
		int acc = size == 0 ? 0 : p.get(0);
		int ans = 0;

		while (l <= r && r < size) {
			if (acc <= n) {
				if (acc == n) {
					ans += 1;
				}
				r += 1;
				if (r < size) {
					acc += p.get(r);
				}
			} else if (acc > n) {
				acc -= p.get(l);
				l += 1;
			}
		}
		System.out.println(ans);
	}
}