package boj;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int up = sc.nextInt();
		int down = sc.nextInt();
		int goal = sc.nextInt();

		int r = goal / (up - down) + 1;
		int l = 0;
		int ans = Integer.MAX_VALUE;
		while (l <= r) {
			int mid = (r + l) / 2;
			if (solve(up, down, mid, goal)) {
				r = mid - 1;
				if (mid < ans) {
					ans = mid;
				}
			} else {
				l = mid + 1;
			}

		}
		System.out.println(ans);
	}

	public static boolean solve(int up, int down, int mid, int goal) {
		int diff = up - down;
		return (mid - 1) * diff + up >= goal;
	}
}