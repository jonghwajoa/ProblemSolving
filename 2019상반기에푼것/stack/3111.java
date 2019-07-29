import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = sc.nextInt();
			int[] input = new int[n];
			Stack<Integer> stack = new Stack<Integer>();

			long ans = 0;
			if (n == 0)
				break;

			for (int i = 0; i < n; i++) {
				input[i] = sc.nextInt();
			}

			for (int i = 0; i < n; i++) {
				while (!stack.isEmpty() && input[stack.peek()] > input[i]) {
					int val = stack.pop();
					long width = 0;

					if (stack.isEmpty()) {
						width = i;
					} else {
						width = i - stack.peek() - 1;
					}

					if (ans < width * input[val]) {
						ans = width * input[val];
					}
				}
				stack.add(i);
			}

			while (!stack.isEmpty()) {
				int val = stack.pop();
				long width = 0;
				if (stack.isEmpty()) {
					width = n;
				} else {
					width = n - stack.peek() - 1;
				}

				if (ans < width * input[val]) {
					ans = width * input[val];
				}
			}

			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
}
