import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Pair> core;
	static boolean[][] isVisit;
	final static int UP = 1;
	final static int RIGHT = 2;
	final static int DOWN = 3;
	final static int LEFT = 4;
	static int n;
	static int totalCoreCount;
	static int ansWireCount;
	static int coreNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int repeat = Integer.parseInt(sc.nextLine());

		for (int z = 1; z <= repeat; z++) {
			ansWireCount = 0;
			totalCoreCount = Integer.MIN_VALUE;

			n = Integer.parseInt(sc.nextLine());
			int[][] map = new int[n][n];
			isVisit = new boolean[n][n];
			core = new ArrayList<Pair>();

			String[] line;
			for (int i = 0; i < n; i++) {
				line = sc.nextLine().split(" ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(line[j]);
					if (map[i][j] == 1) {
						isVisit[i][j] = true;
						if (i != 0 && i != n - 1 && j != 0 && j != n - 1) {
							core.add(new Pair(j, i));
						}
					}
				}
			}

			coreNum = core.size();
			dfs(0, 0, 0);
			System.out.println("#" + z + " " + ansWireCount);
		}
	}

	public static void dfs(int curIndex, int drawCoreCount, int wire) {
		if (curIndex == coreNum) {
			if (totalCoreCount < drawCoreCount) {
				totalCoreCount = drawCoreCount;
				ansWireCount = wire;
			} else if (totalCoreCount == drawCoreCount) {
				if (wire < ansWireCount) {
					ansWireCount = wire;
				}
			}
			return;
		} else {
			for (int i = 1; i < 5; i++) {
				if (checkDrawPossible(i, curIndex)) {
					dfs(curIndex + 1, drawCoreCount + 1, wire + drawLine(i, curIndex, true));
					drawLine(i, curIndex, false); // 백트레킹
				}
			}
			dfs(curIndex + 1, drawCoreCount, wire);
		}

	}

	public static int drawLine(int direction, int curIndex, boolean isWrite) {
		Pair cur = core.get(curIndex);
		int x = cur.x;
		int y = cur.y;
		int count = 0;
		switch (direction) {
		case UP:
			for (int i = y + 1; i < n; i++) {
				isVisit[i][x] = isWrite ? true : false;
				count += 1;
			}
			break;
		case RIGHT:
			for (int i = x + 1; i < n; i++) {
				isVisit[y][i] = isWrite ? true : false;
				count += 1;
			}
			break;
		case DOWN:
			for (int i = 0; i < y; i++) {
				isVisit[i][x] = isWrite ? true : false;
				count += 1;
			}
			break;
		case LEFT:
			for (int i = 0; i < x; i++) {
				isVisit[y][i] = isWrite ? true : false;
				count += 1;
			}
			break;
		}
		return count;
	}

	public static boolean checkDrawPossible(int direction, int curIndex) {
		Pair cur = core.get(curIndex);
		int x = cur.x;
		int y = cur.y;

		boolean check = true;
		switch (direction) {
		case UP:
			for (int i = y + 1; i < n; i++) {
				if (isVisit[i][x]) {
					check = false;
					break;
				}
			}
			break;
		case RIGHT:
			for (int i = x + 1; i < n; i++) {
				if (isVisit[y][i]) {
					check = false;
					break;
				}
			}
			break;
		case DOWN:
			for (int i = 0; i < y; i++) {
				if (isVisit[i][x]) {
					check = false;
					break;
				}
			}
			break;
		case LEFT:
			for (int i = 0; i < x; i++) {
				if (isVisit[y][i]) {
					check = false;
					break;
				}
			}
			break;
		}

		if (check) {
			return true;
		}
		return false;
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
