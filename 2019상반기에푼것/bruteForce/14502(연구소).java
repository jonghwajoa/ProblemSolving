package boj;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int[][] visit;
	static int moveX[] = { 0, 0, -1, 1 };
	static int moveY[] = { 1, -1, 0, 0 };
	static ArrayList<Pair> virus;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		int h = Integer.parseInt(line[0]);
		int w = Integer.parseInt(line[1]);
		map = new int[h][w];

		int wallCount = 0;
		int virusCount = 0;
		int area = w * h;
		virus = new ArrayList<Pair>();

		for (int i = 0; i < h; i++) {
			line = sc.nextLine().split(" ");
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if (map[i][j] == 2) {
					virus.add(new Pair(j, i));
				} else if (map[i][j] == 1) {
					wallCount += 1;
				}
			}
		}
		System.out.println(dfs(h, w, 0, wallCount, 0));

	}

	public static int dfs(int h, int w, int count, int wallCount, int ans) {
		if (count == 3) {
			return findSecurityAreaNum(h, w, wallCount + 3);
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					int security = dfs(h, w, count + 1, wallCount, ans);
					if (security > ans) {
						ans = security;
					}
					map[i][j] = 0;
				}
			}
		}
		return ans;
	}

	public static int findSecurityAreaNum(int h, int w, int wallCount) {
		int[][] tmpMap = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				tmpMap[i][j] = map[i][j];
			}
		}

		Queue<Pair> q = new LinkedList<>();
		int virusCount = virus.size();

		for (int i = 0; i < virusCount; i++) {
			q.add(virus.get(i));
		}

		while (!q.isEmpty()) {
			Pair cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + moveX[i];
				int nextY = cur.y + moveY[i];

				if (0 <= nextX && 0 <= nextY && nextX < w && nextY < h) {
					if (tmpMap[nextY][nextX] == 0) {
						virusCount += 1;
						tmpMap[nextY][nextX] = 3;
						q.add(new Pair(nextX, nextY));
					}
				}
			}
		}

		int areaCount = (w * h) - virusCount - wallCount;
		return areaCount;
	}
}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}