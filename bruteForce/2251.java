package temp;

import java.util.*;

public class Main {
	static boolean[] ans = new boolean[201];
	static boolean[][] isVisit = new boolean[201][201];
	static int A, B, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();

		dfs(0, 0, C);

		for (int i = 0; i < 201; i++) {
			if (ans[i])
				System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void dfs(int a, int b, int c) {
		if (isVisit[a][b])
			return;

		isVisit[a][b] = true;

		if (a == 0) {
			ans[c] = true;
		}

		// a -> b
		if (b + a <= B) {
			dfs(0, a + b, c);
		} else {
			dfs((a + b) - B, B, c);
		}

		// b-> a
		if (a + b <= A) {
			dfs(a + b, 0, c);
		} else {
			dfs(A, (b + a) - A, c);
		}

		// c- > a
		if (c + a <= A) {
			dfs(c + a, b, 0);
		} else {
			dfs(A, b, (c + a) - A);
		}

		// c- > b

		if (c + b <= B) {
			dfs(a, c + b, 0);
		} else {
			dfs(a, B, (c + b) - B);
		}

		/*
		 * else 의 상황이 존재하지 않음 // b-> c if (b + c <= C) { dfs(a, 0, b + c); } else {
		 * dfs(a, (b + c) - C, C); }
		 * 
		 * // a -> c if (a + c <= C) { dfs(0, b, c + a); } else { dfs((a + b) - C, b,
		 * C); }
		 */

		dfs(a, 0, b + c);
		dfs(0, b, c + a);
	}
}
