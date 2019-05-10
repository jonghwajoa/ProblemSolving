import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int[][] map;
	static int R, C, K;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt() - 1;
		C = sc.nextInt() - 1;
		K = sc.nextInt();
		map = new int[100][100];

		for (int y = 0; y < 3; y += 1) {
			for (int x = 0; x < 3; x += 1) {
				map[y][x] = sc.nextInt();
			}
		}

		int row = 3;
		int col = 3;
		int repeat = 0;

		while (map[R][C] != K) {
			if (repeat > 100) {
				break;
			}

			if (row >= col) {
				int maxLen = col;
				for (int y = 0; y < row; y++) {
					int[] hit = new int[101];

					for (int x = 0; x < col; x++) {

						hit[map[y][x]] += 1;
					}

					PriorityQueue<Pair> pq = new PriorityQueue<>(new Order());
					for (int i = 1; i < 101; i++) {
						if (hit[i] != 0) {
							pq.add(new Pair(i, hit[i]));
						}
					}

					int index = 0;
					if (pq.size() * 2 > maxLen) {
						maxLen = pq.size() * 2;
					}
					Arrays.fill(map[y], 0);
					while (!pq.isEmpty()) {
						Pair cur = pq.poll();
						map[y][index++] = cur.n;
						map[y][index++] = cur.r;
						if (index >= 100) {
							maxLen = 100;
							break;
						}
					}
				}
				col = maxLen;
			} else {
				int maxLen = row;
				for (int x = 0; x < col; x++) {
					int[] hit = new int[101];

					for (int y = 0; y < row; y++) {
						hit[map[y][x]] += 1;
					}

					PriorityQueue<Pair> pq = new PriorityQueue<>(new Order());
					for (int i = 1; i < 101; i++) {
						if (hit[i] != 0) {
							pq.add(new Pair(i, hit[i]));
						}
					}

					int index = 0;
					if (pq.size() * 2 > maxLen) {
						maxLen = pq.size() * 2;
					}

					for (int y = 0; y < col; y++) {
						map[y][x] = 0;
					}

					while (!pq.isEmpty()) {
						Pair cur = pq.poll();
						map[index++][x] = cur.n;
						map[index++][x] = cur.r;
						if (index >= 100) {
							maxLen = 100;
							break;
						}
					}
				}
				row = maxLen;
			}

			repeat += 1;
		}

		if (repeat > 100) {
			System.out.println(-1);
		} else {
			System.out.println(repeat);
		}
	}
}

class Order implements Comparator<Pair> {
	@Override
	public int compare(Pair o1, Pair o2) {
		if (o1.r == o2.r) {
			return o1.n - o2.n;
		}
		return o1.r - o2.r;
	}
}

class Pair {
	int n;
	int r;

	public Pair(int n, int r) {
		super();
		this.n = n;
		this.r = r;
	}
}