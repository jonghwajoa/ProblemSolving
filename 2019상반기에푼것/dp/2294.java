package temp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] input = new int[n];
		int[] d = new int[m + 1];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		for (int i = 1; i <= m; i++) {
			d[i] = -1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= m; j++) {
				if (j - input[i] >= 0 && d[j - input[i]] != -1) {
					if (d[j] == -1 || d[j - input[i]] + 1 < d[j]) {
						d[j] = d[j - input[i]] + 1;
					}
				}
			}
		}
		System.out.println(d[m]);
	}
}