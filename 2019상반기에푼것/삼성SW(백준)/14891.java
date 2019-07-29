import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	final static int RIGHT_INDEX = 2, LEFT_INDEX = 6;
	static LinkedList<Integer>[] wheel;

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		wheel = new LinkedList[4];

		for (int i = 0; i < 4; i++) {
			wheel[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < 4; i++) {
			char[] input = sc.nextLine().toCharArray();

			for (int j = 0; j < 8; j++) {
				wheel[i].add(Character.getNumericValue(input[j]));
			}
		}

		final int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			solve(sc.nextInt() - 1, sc.nextInt());
		}

		// S극이 1
		int ans = 0;
		for (int i = 0; i < 4; i++) {
			if (wheel[i].get(0) == 1) {
				ans += (int) Math.pow(2, i);
			}
		}
		System.out.println(ans);
	}

	public static void solve(int index, int direction) {
		int prev_left = wheel[index].get(LEFT_INDEX);
		int prev_right = wheel[index].get(RIGHT_INDEX);

		wheelChange(direction, index);
		int origin_direction = direction;
		direction = reverseDirection(direction);
		// ->>>
		for (int i = index + 1; i < 4; i++) {
			if (wheel[i].get(LEFT_INDEX) == prev_right) {
				break;
			}
			prev_right = wheel[i].get(RIGHT_INDEX);
			wheelChange(direction, i);
			direction = reverseDirection(direction);
		}

		direction = reverseDirection(origin_direction);
		// <<<---
		for (int i = index - 1; 0 <= i; i--) {
			if (wheel[i].get(RIGHT_INDEX) == prev_left) {
				break;
			}
			prev_left = wheel[i].get(LEFT_INDEX);
			wheelChange(direction, i);
			direction = reverseDirection(direction);
		}

	}

	public static void wheelChange(int direction, int index) {
		// 반시계로 돌아야할때
		if (direction == 1) {
			wheel[index].addFirst(wheel[index].removeLast());
		} else {
			wheel[index].addLast(wheel[index].removeFirst());
		}
	}

	public static int reverseDirection(int d) {
		return d == 1 ? -1 : 1;
	}
}
