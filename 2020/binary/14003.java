import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	final static String NEW_LINE = "\n";

	public static void main(String[] args) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		StringBuilder ansSB = new StringBuilder();

		int N = atoi(br.readLine());

		int[] inputs = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputs[i] = atoi(st.nextToken());
		}

		int count = 0;
		int[] lis = new int[N];
		int[] indexes = new int[N];

		lis[0] = inputs[0];
		indexes[0] = 0;

		for (int i = 1; i < N; i++) {
			if (lis[count] < inputs[i]) {
				lis[++count] = inputs[i];
				indexes[i] = count;
			} else {
				int index = binary(0, count, inputs[i], lis);
				lis[index] = inputs[i];
				indexes[i] = index;
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (indexes[i] == count) {
				ans += 1;
			}
		}
		bw.write((count + 1) + " " + ans);
		bw.flush();
	}

	private static int binary(int s, int e, int v, int[] arr) {
		while (s <= e) {
			int mid = (s + e) >> 1;
			if (arr[mid] < v) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return s;
	}

	private static int atoi(String string) {
		return Integer.parseInt(string);
	}
}
