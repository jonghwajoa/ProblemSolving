
import java.util.Scanner;

public class Main {
	static boolean[] broken = new boolean[10];

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			broken[sc.nextInt()] = true;
		}

		if (target == 100) {
			System.out.println(0);
			return;
		}

		int ans = Math.abs(target - 100);

		if (N == 10) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < 500000; i++) {
			if (target - i >= 0 && check(target - i)) {
				String strVal = Integer.toString(target - i);
				int len = strVal.length();
				if (i + len < ans) {
					ans = i + len;
					break;
				}
			} else if (check(target + i)) {
				String strVal = Integer.toString(target + i);
				int len = strVal.length();
				if (i + len < ans) {
					ans = i + len;
					break;
				}
			}

			if (i >= ans)
				break;
		}
		System.out.println(ans);
	}

	public static boolean check(int target) {
		if (target == 0) {
			return !broken[0];
		}
		while (target > 0) {
			if (broken[target % 10]) {
				return false;
			}
			target /= 10;
		}
		return true;
	}
}