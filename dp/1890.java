import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split("\\s");
		int N = Integer.parseInt(line[0]);
		int[][] matrix = new int[N + 1][N + 1];
		long[][] dist = new long[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			line = br.readLine().split("\\s");
			for (int j = 1; j <= N; j++) {
				matrix[i][j] = Integer.parseInt(line[j - 1]);
			}
		}

		dist[1][1] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int jump = matrix[i][j];
				if (jump == 0)
					break;
				if (i + jump <= N) {
					dist[i + jump][j] += dist[i][j];
				}

				if (j + jump <= N) {
					dist[i][j + jump] += dist[i][j];
				}
			}
		}
		System.out.println(dist[N][N]);
	}
}