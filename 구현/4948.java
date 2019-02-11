import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int max = 123457 * 2;
		boolean[] prime = new boolean[max];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i = 2; i * i < max; i++) {
			if (prime[i]) {
				for (int j = i + i; j < max; j += i) {
					prime[j] = false;
				}
			}
		}

		while (true) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			sb.append(betweenPrimeNum(n, prime) + "\n");

		}
		System.out.println(sb);
	}

	public static int betweenPrimeNum(int n, boolean[] prime) {
		int count = 0;
		for (int i = n+1; i <= 2 * n; i++) {
			if (prime[i]) {
				count++;
			}
		}
		return count;
	}
}
