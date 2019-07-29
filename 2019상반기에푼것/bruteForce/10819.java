package temp;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int ans = 0;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		Arrays.sort(input);

		do {
			calculate(input);
		} while (next(input));

		System.out.println(ans);

	}

	public static boolean next(int[] input) {
		int i = input.length - 1;

		while (i > 0 && input[i - 1] >= input[i]) {
			i--;
		}

		if (i <= 0) {
			return false;
		}

		int j = input.length - 1;
		while (input[i - 1] >= input[j])
			j--;

		int tmp = input[i - 1];
		input[i - 1] = input[j];
		input[j] = tmp;

		j = input.length - 1;

		while (i < j) {
			tmp = input[j];
			input[j] = input[i];
			input[i] = tmp;
			i++;
			j--;
		}
		return true;
	}

	public static void calculate(int[] input) {
		int acc = 0;
		for (int i = 1; i < input.length; i++) {
			acc += Math.abs(input[i] - input[i - 1]);
		}
		if (acc > ans) {
			ans = acc;
		}

	}
}
