import java.util.*;

public class Main {
	static int y;
	static int x;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[] move_x = { 0, 0, 1, -1 };
		int[] move_y = { 1, -1, 0, 0 };
		y = sc.nextInt();
		x = sc.nextInt();
		sc.nextLine();
		int[][] d = new int[y][x];
		int[][] input = new int[y][x];
		boolean[][] isVisit = new boolean[y][x];
		for (int i = 0; i < y; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < x; j++) {
				input[i][j] = s.charAt(j) - '0';
			}
		}

		d[0][0] = 1;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0, 0));
		isVisit[0][0] = true;
		while (!q.isEmpty()) {
			Pair point = q.poll();
			int val = d[point.y][point.x];

			for (int i = 0; i < 4; i++) {
				int dx = point.x + move_x[i];
				int dy = point.y + move_y[i];

				if (0 <= dx && dx < x && 0 <= dy && dy < y) {
					if (!isVisit[dy][dx] && input[dy][dx] == 1) {
						d[dy][dx] = val + 1;
						q.add(new Pair(dx, dy));
						isVisit[dy][dx] = true;
					}
				}
			}
		}
		System.out.println(d[y - 1][x - 1]);
	}
}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}