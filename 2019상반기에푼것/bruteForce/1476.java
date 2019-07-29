import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

		int E = input[0];
		int S = input[1];
		int M = input[2];
		int e = 1, s = 1, m = 1;

		for (int i = 1;; i++) {
			if (E == e && S == s && M == m) {
				System.out.println(i);
				break;
			}

			e++;
			s++;
			m++;

			if (e == 16)
				e = 1;
			if (s == 29)
				s = 1;
			if (m == 20)
				m = 1;
		}
	}
}