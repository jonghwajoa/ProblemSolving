package temp;

import java.util.*;

public class Main {
	static boolean[] prime;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		int dif = (int) (max - min) + 1;
		prime = new boolean[dif];

		for (long i = 2; i * i <= max; i++) {
			long tmp = i * i - min % (i * i);

			if (tmp == i * i) {
				tmp = 0;
			}

			while (tmp <= max - min) {
				prime[(int) tmp] = true;
				tmp += i * i;
			}
		}
		int ans = 0;
		for (int i = 0; i <= max - min; i++) {
			if (prime[i] == false) {
				ans += 1;
			}
		}
		System.out.println(ans);
	}
}
