import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int count = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		solve(N, 1, 3, 2);
		System.out.println(count);
		System.out.println(sb);
	}

	public static void solve(int N, int from, int to, int by) {
		if (N == 1) {
			move(from, to);
			return;
		}
		solve(N - 1, from, by, to);
		move(from, to);
		solve(N - 1, by, to, from);
	}

	public static void move(int from, int to) {
		sb.append(from + " " + to + "\n");
		count++;
	}
}