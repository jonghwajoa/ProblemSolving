import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		StringBuilder sb = new StringBuilder();
		input = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

		if (next(input)) {
			for (int val : input)
				sb.append(val + " ");
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}

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