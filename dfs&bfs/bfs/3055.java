package boj;

import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Main {
	static int[] moveX = { 0, 0, -1, 1 };
	static int[] moveY = { 1, -1, 0, 0 };

	final static int stone = 0;
	final static int water = 1;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		sc.nextLine();

		// . 비어있는곳
		// * 물이 차있는 곳
		// x 돌
		// D 비버의 돌
		// 고슴도치위치 S
		// 물은 매분마다 확장된다.

		char[][] map = new char[h][w];
		Queue<Point> water = new LinkedList<>();
		Queue<Point> hedgehog = new LinkedList<>();

		for (int i = 0; i < h; i++) {
			char[] tmp = sc.nextLine().toCharArray();
			for (int j = 0; j < w; j++) {
				map[i][j] = tmp[j];
				if (tmp[j] == '*') {
					water.add(new Point(j, i));
				}

				if (tmp[j] == 'S') {
					hedgehog.add(new Point(j, i));
				}
			}
		}

		int ans = 0;
		while (!hedgehog.isEmpty()) {
			ans++;
			if (hedgehogBfs(map, hedgehog, h, w)) {
				System.out.println(ans);
				return;
			} else {
				waterBfs(map, water, h, w);
			}
		}
		System.out.println("KAKTUS");
	}

	public static void waterBfs(char[][] map, Queue<Point> water, int h, int w) {
		int len = water.size();
		for (int i = 0; i < len; i++) {
			Point cur = water.poll();
			int x = cur.x;
			int y = cur.y;

			for (int j = 0; j < 4; j++) {
				int nextX = x + moveX[j];
				int nextY = y + moveY[j];
				if (0 <= nextX && 0 <= nextY && nextX < w && nextY < h) {
					if (map[nextY][nextX] == '.' || map[nextY][nextX] == 'S') {
						map[nextY][nextX] = '*';
						water.add(new Point(nextX, nextY));
					}
				}
			}
		}
	}

	public static boolean hedgehogBfs(char[][] map, Queue<Point> hedgehog, int h, int w) {

		int len = hedgehog.size();
		for (int i = 0; i < len; i++) {
			Point cur = hedgehog.poll();
			int x = cur.x;
			int y = cur.y;
			if (map[y][x] == '*') {
				continue;
			}

			for (int j = 0; j < 4; j++) {
				int nextX = x + moveX[j];
				int nextY = y + moveY[j];
				if (0 <= nextX && 0 <= nextY && nextX < w && nextY < h) {
					if (map[nextY][nextX] == '.') {
						map[nextY][nextX] = 'S';
						hedgehog.add(new Point(nextX, nextY));
					} else if (map[nextY][nextX] == 'D') {
						return true;
					}
				}
			}
		}
		return false;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
