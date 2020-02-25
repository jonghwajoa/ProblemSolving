package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int len = input.length();
		if (len == 0) {
			System.out.println(0);
			return;
		}

		if (Character.getNumericValue(input.charAt(0)) == 0) {
			System.out.println(0);
			return;
		}

		if (len == 1) {
			System.out.println(atoi(input) == 0 ? 0 : 1);
			return;
		}

		int[] dp = new int[len + 1];
		dp[0] = dp[1] = 1;

		boolean flag = false;
		for (int i = 1; i < len; i++) {
			char c = input.charAt(i);
			int num = Character.getNumericValue(c);

			int prev = Integer.parseInt(input.substring(i - 1, i + 1));

			if (num == 0 && (prev <= 0 || prev > 26)) {
				flag = true;
				break;
			}

			if (0 < num) {
				dp[i + 1] = dp[i];
				dp[i + 1] %= 1000000;
			}

			if (10 <= prev && prev <= 26) {
				dp[i + 1] += dp[i - 1];
				dp[i + 1] %= 1000000;
			}

		}

		System.out.println(flag ? 0 : dp[len]);

	}

	private static int atoi(String value) {
		return Integer.parseInt(value);
	}
}