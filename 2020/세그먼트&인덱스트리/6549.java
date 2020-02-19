package histogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	final static String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = atoi(st.nextToken());
			if (N == 0) {
				break;
			}

			int[] inputs = new int[N];
			for (int i = 0; i < N; i++) {
				inputs[i] = atoi(st.nextToken());
			}

			Stack<Integer> stack = new Stack<>();

			long max = 0l;

			for (int i = 0; i < N; i++) {
				int height = inputs[i];

				while (!stack.isEmpty() && height < inputs[stack.peek()]) {
					int popIndex = stack.pop();
					int popHeight = inputs[popIndex];
					long width = stack.isEmpty() ? i : i - 1 - stack.peek();
					max = Math.max(max, width * inputs[popIndex]);
				}
				stack.push(i);
			}

			while (!stack.isEmpty()) {
				int popIndex = stack.pop();
				int popHeight = inputs[popIndex];
				long width = stack.isEmpty() ? N : N - 1 - stack.peek();
				max = Math.max(max, width * inputs[popIndex]);
			}

			System.out.println(max);
		}
	}

	private static int atoi(String value) {
		return Integer.parseInt(value);
	}

}
