package temp;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[] input;
		int[] order;
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = sc.nextInt();

			if (n == 0)
				break;
			sb.setLength(0);
			input = new int[n];
			order = new int[n];

			for (int i = 0; i < n; i++) {
				input[i] = sc.nextInt();
			}

			for (int i = 0; i < n; i++) {
				if (i < 6)
					order[i] = 1;
				else
					order[i] = 2;
			}

			do {
				for (int i = 0; i < n; i++) {
					if (order[i] == 1) {
						sb.append(input[i] + " ");
					}
				}
				sb.append("\n");
			} while (next(order));
			System.out.println(sb);
		}

	}

	public static boolean next(int[] input) {
		int i = input.length - 1;

		while (i > 0 && input[i - 1] >= input[i]) {
			i--;
		}

		if (i <= 0)
			return false;

		int j = input.length - 1;

		while (input[i - 1] >= input[j]) {
			j--;
		}

		int tmp = input[i - 1];
		input[i - 1] = input[j];
		input[j] = tmp;

		j = input.length - 1;

		while (i < j) {
			tmp = input[i];
			input[i] = input[j];
			input[j] = tmp;
			i++;
			j--;
		}
		return true;
	}
}