package boj;

import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static ArrayList<Integer> ans;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		ans = new ArrayList<>();
		int acc = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			acc += arr[i];
		}

		findSevenBoy(acc);

		Collections.sort(ans);
		for(int val : ans) {
			System.out.println(val);
		}
	}

	public static void findSevenBoy(int acc) {
		for (int i = 0; i < 9; i++) {
			int tmp = acc - arr[i];
			for (int j = 0; j < 9; j++) {
				if (i == j)
					continue;

				if (tmp - arr[j] == 100) {
					ansPush(i, j);
					return;
				}
			}
		}
	}

	public static void ansPush(int removeOne, int removeTwo) {
		for (int i = 0; i < 9; i++) {
			if (i != removeOne && i != removeTwo) {
				ans.add(arr[i]);
			}
		}
	}

}