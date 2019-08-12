import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] map, dpMin, dpMax;
	static int n;

	public static void main(String[] argv) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][3];
		dpMin = new int[n][3];
		dpMax = new int[n][3];

		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
		}

		dpMax[0] = dpMin[0] = map[0];
		for (int i = 1; i < n; i++) {
			dpMin[i][0] = Math.min(dpMin[i - 1][0], dpMin[i - 1][1]) + map[i][0];
			dpMin[i][1] = Math.min(dpMin[i - 1][0], Math.min(dpMin[i - 1][1], dpMin[i - 1][2])) + map[i][1];
			dpMin[i][2] = Math.min(dpMin[i - 1][1], dpMin[i - 1][2]) + map[i][2];

			dpMax[i][0] = Math.max(dpMax[i - 1][0], dpMax[i - 1][1]) + map[i][0];
			dpMax[i][1] = Math.max(dpMax[i - 1][0], Math.max(dpMax[i - 1][1], dpMax[i - 1][2])) + map[i][1];
			dpMax[i][2] = Math.max(dpMax[i - 1][1], dpMax[i - 1][2]) + map[i][2];

		}

		int min = Math.min(dpMin[n - 1][0], Math.min(dpMin[n - 1][1], dpMin[n - 1][2]));
		int max = Math.max(dpMax[n - 1][0], Math.max(dpMax[n - 1][1], dpMax[n - 1][2]));
		System.out.println(max + " " + min);

	}
}
