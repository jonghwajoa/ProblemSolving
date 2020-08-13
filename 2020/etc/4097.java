import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	final static String NEW_LINE = "\n";

	public static void main(String[] args) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {
			int N = atoi(br.readLine());
			if (N == 0) {
				break;
			}

			long sum = 0;
			long ans = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				int v = atoi(br.readLine());
				sum = Math.max(sum + v, v);
				ans = Math.max(ans, sum);
			}
			System.out.println(ans);
		}

	}

	private static int atoi(final String string) {
		return Integer.parseInt(string);
	}

}
