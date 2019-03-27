import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	static final int[] mx = { 0, 1, 0, -1 };
	static final int[] my = { -1, 0, 1, 0 };
	static final char LeftTurn = 'L';

	static int curDirection = RIGHT;
	static int N;

	public static void main(String[] args) {

		final Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		final boolean[][] APPLE = new boolean[N][N];
		final boolean[][] BAAM = new boolean[N][N];

		int appleCount = sc.nextInt();
		for (int i = 0; i < appleCount; i++) {
			int y = sc.nextInt()-1;
			int x = sc.nextInt()-1;
			APPLE[y][x] = true;
		}

		int possibleShift = sc.nextInt();
		Queue<Pair> q = new LinkedList<>();

		sc.nextLine();
		for (int i = 0; i < possibleShift; i++) {
			String[] input = sc.nextLine().split(" ");
			q.add(new Pair(Integer.parseInt(input[0]), input[1].charAt(0)));
		}

		Pair shiftCur = q.poll();

		Deque<Point> deque = new LinkedList<>();

		deque.add(new Point(0, 0));
		int ans = 0;
		BAAM[0][0] = true;

		int baamNextX;
		int baamNextY;
		while (true) {

			Point cur = deque.peekFirst();
			if (shiftCur != null && shiftCur.time == ans) {
				nextDirection(shiftCur.turn);
				shiftCur = q.poll();
			}

			baamNextX = cur.x + mx[curDirection];
			baamNextY = cur.y + my[curDirection];

			if (baamNextX < 0 || baamNextX >= N || baamNextY < 0 || baamNextY >= N || BAAM[baamNextY][baamNextX]) {
				break;
			}

			if (!APPLE[baamNextY][baamNextX]) {
				Point remove = deque.removeLast();
				BAAM[remove.y][remove.x] = false;
			}else {
				APPLE[baamNextY][baamNextX] = false;
			}

			deque.addFirst(new Point(baamNextX, baamNextY));
			BAAM[baamNextY][baamNextX] = true;
			ans += 1;
		}
		System.out.println(ans + 1);
	}

	public static void nextDirection(char input) {
		curDirection = input == LeftTurn ? curDirection + 3 : curDirection + 1;
		curDirection %= 4;
	}
}

class Pair {
	int time;
	char turn;

	public Pair(int time, char turn) {
		this.time = time;
		this.turn = turn;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}