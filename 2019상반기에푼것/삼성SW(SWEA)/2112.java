
// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu&categoryId=AV5V1SYKAaUDFAWu&categoryType=CODE

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int nX, nY, nK;
	static int max = Integer.MAX_VALUE;

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);

		int repeat = sc.nextInt();

		for (int count = 1; count <= repeat; count++) {

			nY = sc.nextInt();
			nX = sc.nextInt();
			nK = sc.nextInt();
			max = Integer.MAX_VALUE;

			int[][] map = new int[nY][nX];

			for (int i = 0; i < nY; i++) {
				for (int j = 0; j < nX; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			dfs(0, map, 0);
			System.out.println("#" + count + " " + max);

		}
	}

	// 약을 안뿌리거나
	// A를뿌리거나 B를뿌리거나
	// 3가지 경우의 수
	public static void dfs(int count, int[][] origin, int useCount) {
		if (check(origin)) {
			if (useCount < max) {
				max = useCount;
			}
			return;
		}
		if (count >= nY || max < useCount) {
			return;
		}

		// 색안칠함
		dfs(count + 1, origin, useCount);

		int[][] copy = makeCopyArr(origin);
		reverseLow(copy[count], 1);
		dfs(count + 1, copy, useCount + 1);
		lowCopy(origin[count], copy[count]);

		reverseLow(copy[count], 0);
		dfs(count + 1, copy, useCount + 1);

	}

	public static int[][] makeCopyArr(int[][] origin) {
		int[][] copy = new int[nY][nX];
		for (int i = 0; i < nY; i++) {
			for (int j = 0; j < nX; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}

	public static void lowCopy(int[] origin, int[] copy) {
		for (int j = 0; j < nX; j++) {
			copy[j] = origin[j];
		}
	}

	public static void reverseLow(int[] arr, int color) {
		for (int i = 0; i < nX; i++) {
			arr[i] = color;
		}
	}

	public static boolean check(int[][] map) {
		for (int i = 0; i < nX; i++) {
			int stand = map[0][i];
			int count = 1;
			boolean flag = false;

			for (int j = 1; j < nY; j++) {
				if (map[j][i] == stand) {
					count += 1;
				} else {
					stand = map[j][i];
					count = 1;
				}
				if (count >= nK) {
					flag = true;
					break;
				}

				if (nY - j + count - 1 < nK) {
					break;
				}
			}
			if (!flag) {
				return false;
			}
		}

		return true;
	}
}
