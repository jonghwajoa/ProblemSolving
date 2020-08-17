import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		char[] word1 = ("0" + br.readLine()).toCharArray();
		char[] word2 = ("0" + br.readLine()).toCharArray();

		int N1 = word1.length;
		int N2 = word2.length;
		int[][] lcs = new int[N1][N2];

		for (int i = 1; i < N1; i++) {
			for (int j = 1; j < N2; j++) {
				if (word1[i] == word2[j]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}

		System.out.println(lcs[N1 - 1][N2 - 1]);
	}

	private static int atoi(String string) {
		return Integer.parseInt(string);
	}
}