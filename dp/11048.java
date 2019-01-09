package temp;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split("\\s");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int[][] matrix = new int[N][M];
		int[][] dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			line = br.readLine().split("\\s");
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(line[j]);
			}
		}

		dist[0][0] = matrix[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (0 <= i - 1) {
					dist[i][j] = dist[i - 1][j] + matrix[i][j];
				}

				if (0 <= j - 1 && dist[i][j] < dist[i][j - 1] + matrix[i][j]) {
					dist[i][j] = dist[i][j - 1] + matrix[i][j];
				}

				if (0 <= i - 1 && 0 <= j - 1 && dist[i][j] < dist[i - 1][j - 1] + matrix[i][j]) {
					dist[i][j] = dist[i - 1][j - 1] + matrix[i][j];
				}
			}
		}

		System.out.println(dist[N - 1][M - 1]);
	}
}
