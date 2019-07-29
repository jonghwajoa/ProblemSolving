import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		final Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] map = new int[N];
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < N; i++) {
			map[i] = sc.nextInt();
			if (max < map[i]) {
				max = map[i];
				maxIndex = i;
			}
		}

		int cnt = 0;
		int lastIndex = 0;
		for (int i = 0; i < N; i++) {
			if (max == map[i]) {
				cnt += 1;
				lastIndex = i;
			}
		}

		int rc = 0;
		int bc = 0;

		if (cnt == 1) {
			rc = N - 1 - maxIndex;
			bc = N - 1 - rc;
		} else {
			bc = maxIndex;
			rc = N - 1 - lastIndex;
		}

		if (rc > bc) {
			System.out.println("R");
		} else if (rc < bc) {
			System.out.println("B");
		} else {
			System.out.println("X");
		}
	}
}
