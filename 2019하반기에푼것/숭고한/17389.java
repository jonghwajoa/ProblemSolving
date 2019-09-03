import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] argv) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String input = br.readLine();

		int score = 0;
		int acc = 0;
		int index = 1;
		for (char c : input.toCharArray()) {
			if (c == 'X') {
				acc = 0;
			} else {
				score += index + acc;
				acc += 1;
			}

			index += 1;
		}
		System.out.println(score);
	}
}