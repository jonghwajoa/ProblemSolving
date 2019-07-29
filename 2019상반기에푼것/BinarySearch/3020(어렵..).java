import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws Exception {
		final Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 짝수
		int H = sc.nextInt();

		final int DIVISION = N / 2;

		int[] top = new int[DIVISION];
		int[] bottom = new int[DIVISION];

		for (int i = 0; i < DIVISION; i++) {
			bottom[i] = sc.nextInt();
			top[i] = H - sc.nextInt();
		}

		int ans = Integer.MAX_VALUE;

//		for (int h = 0; h < H; h++) {
//			int cnt = 0;
//			for (int j = 0; j < DIVISION; j++) {
//				if (h < bottom[j]) {
//					cnt += 1;
//				}
//
//				if (top[j] <= h) {
//					cnt += 1;
//				}
//			}
//
//			if (cnt < ans) {
//				ans = cnt;
//			}
//		}

		System.out.println(ans);
	}
}
