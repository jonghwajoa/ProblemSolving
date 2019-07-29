public class Main {
	final static int[] mx = { 1, 0, -1, 0 };
	final static int[] my = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		int[][] input1 = { { 1, 2, 3, }, { 8, 9, 4 }, { 7, 6, 5 } };
		solve(input1);
	}

	public static void solve(int[][] input) {
		int y = input.length;
		int x = input[0].length;

		boolean[][] isVisit = new boolean[y][x];

		int curX = 0;
		int curY = 0;
		int curD = 0;
		int count = 1;
		int max = y * x;
		isVisit[curY][curX] = true;
		StringBuilder sb = new StringBuilder();
		sb.append(input[curY][curX]);
		while (count < max) {
			int nextX = curX + mx[curD];
			int nextY = curY + my[curD];

			if (0 <= nextX && nextX < x && 0 <= nextY && nextY < y) {
				if (!isVisit[nextY][nextX]) {
					isVisit[nextY][nextX] = true;
					curX = nextX;
					curY = nextY;
					count += 1;
					sb.append(", " + input[curY][curX]);
				} else {
					curD = (curD + 1) % 4;
				}
			} else {
				curD = (curD + 1) % 4;
			}
		}
		System.out.println(sb.toString());
	}
}
