import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int repeat = sc.nextInt();
			long ans = 0;
			int[] val = new int[repeat];

			for (int i = 0; i < repeat; i++) {
				val[i] = sc.nextInt();
			}

			for (int i = 0; i < repeat; i++) {
				for (int j = i; j < repeat; j++) {
					if (j == i)
						continue;
					ans += GCD(val[i], val[j]);
				}
			}
			System.out.println(ans);
		}

	}

	public static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}
}