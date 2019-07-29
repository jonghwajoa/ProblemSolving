import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] isPrime = new boolean[m + 1];
		isPrime[0] = isPrime[1] = true;

		for (int i = 2; i * i <= m; i++) {
			if (isPrime[i]) {
				continue;
			}

			for (int j = i + i; j <= m; j += i) {
				isPrime[j] = true;
			}
		}

		for (int i = n; i <= m; i++) {
			if (!isPrime[i])
				System.out.println(i);

		}

	}

}