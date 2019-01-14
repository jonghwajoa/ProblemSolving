package temp;

import java.util.*;

public class Main {
	static int[] d = new int[100001];
	static int size = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();

			if (input == 0) {
				if (size == 0) {
					ans.append("0\n");
				} else {
					ans.append(pop() + "\n");
				}
			} else {
				push(input);
			}
		}
		System.out.println(ans);
	}

	public static void push(int x) {
		d[++size] = x;

		for (int i = size; i > 1; i /= 2) {
			if (d[i] > d[i / 2]) {
				int tmp = d[i];
				d[i] = d[i / 2];
				d[i / 2] = tmp;
			} else {
				break;
			}
		}
	}

	public static int pop() {
		int remove = d[1];
		d[1] = d[size];
		d[size--] = 0;
		for (int i = 1; i * 2 <= size;) {
			if (d[i] > d[i * 2] && d[i] > d[i * 2 + 1]) {
				break;
			} else if (d[i * 2] > d[i * 2 + 1]) {
				int tmp = d[i];
				d[i] = d[i * 2];
				d[i * 2] = tmp;
				i = i * 2;
			} else {
				int tmp = d[i];
				d[i] = d[i * 2 + 1];
				d[i * 2 + 1] = tmp;
				i = i * 2 + 1;
			}
		}

		return remove;
	}
}