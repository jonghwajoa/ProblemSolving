package temp;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int len = s.length();
		boolean[][] d = new boolean[len][len];
		int[] ans = new int[len + 1];

		for (int i = 0; i < len; i++) {
			d[i][i] = true;
		}

		for (int i = 1; i < len; i++) {
			d[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
		}

		for (int i = 2; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				int k = j + i;
				d[j][k] = s.charAt(j) == s.charAt(k) && d[j + 1][k - 1];
			}
		}

		for (int i = 1; i <= len; i++) {
			ans[i] = -1;
			for (int j = 1; j <= i; j++) {
				if (d[j - 1][i - 1]) {
					if (ans[i] == -1 || ans[j - 1] + 1 < ans[i]) {
						ans[i] = ans[j - 1] + 1;
					}
				}
			}
		}
		System.out.println(ans[len]);
	}
}
