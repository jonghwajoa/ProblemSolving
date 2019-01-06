import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
			sb.append(input[i] + " ");
		}
		sb.append("\n");

		while (next(input)) {
			for (int i = 0; i < N; i++) {
				sb.append(input[i] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static boolean next(int[] input) {
		int i = input.length - 1;

		while (i > 0 && input[i] < input[i - 1]) {
			i--;
		}

		if (i <= 0) {
			return false;
		}

		int j = input.length - 1;

		while (input[j] <= input[i - 1]) {
			j -= 1;
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
