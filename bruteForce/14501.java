package boj;

import java.io.*;
import java.util.*;

public class Main {
	static int[] getMoney;
	static int[] spendTime;
	static int n;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		getMoney = new int[n];
		spendTime = new int[n];

		for (int i = 0; i < n; i++) {
			String[] line = sc.nextLine().split(" ");
			spendTime[i] = Integer.parseInt(line[0]);
			getMoney[i] = Integer.parseInt(line[1]);
		}
		System.out.println(dfs(0, 0));

	}

	public static int dfs(int acc, int i) {
		if (i >= n) {
			return acc;
		}

		int notWork = dfs(acc, i + 1);
		int work = 0;
		if (i + spendTime[i] <= n) {
			work = dfs(acc + getMoney[i], i + spendTime[i]);
		}
		return Math.max(notWork, work);
	}

}