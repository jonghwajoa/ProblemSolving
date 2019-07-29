package temp;

import java.util.*;

public class Main {
	static int[][] point;
	static boolean visit[] = new boolean[26];
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	static int[] moveX = { 1, -1, 0, 0 };
	static int[] moveY = { 0, 0, 1, -1 };
	static int A;
	static int B;
	static int count = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		sc.nextLine();
		point = new int[A][B];

		for (int i = 0; i < A; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < B; j++) {
				point[i][j] = line.charAt(j) - 'A';
			}
		}

		dfs(0, 0, 1);
		System.out.println(count);
	}

	static public int dfs(int x, int y, int score) {
		if (x < 0 || y < 0 || x >= B || y >= A || visit[point[y][x]]) {
			return score - 1;
		}

		visit[point[y][x]] = true;

		for (int i = 0; i < 4; i++) {
			int nextX = x + moveX[i];
			int nextY = y + moveY[i];
			int tmp = dfs(nextX, nextY, score + 1);
			if (count < tmp) {
				count = tmp;
			}
		}
		visit[point[y][x]] = false;
		return score;
	}
}