import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int repeat = Integer.parseInt(br.readLine());
		int[] input = new int[10001];

		while (repeat-- > 0) {
			input[Integer.parseInt(br.readLine())]++;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i < 10001; i++) {
			if (input[i] > 0) {
				while (input[i]-- > 0) {
					bw.write(Integer.toString(i) + "\n");
				}
			}
		}
		br.close();
		bw.close();
	}
}
