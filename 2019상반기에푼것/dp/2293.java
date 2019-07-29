import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] input = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			input[i] = sc.nextInt();
		}
		int[] d = new int[m + 1];
		d[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (j - input[i] >= 0) {
					d[j] += d[j - input[i]];
				}
			}
		}
		System.out.println(d[m]);
	}
}