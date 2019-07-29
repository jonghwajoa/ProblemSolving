https://www.acmicpc.net/problem/2331

package temp;

import java.util.*;

public class Main {

	static boolean[] isVisit;
	static int[] array;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int n = sc.nextInt();
		int m = sc.nextInt();
		int idx = 0;
		map.put(n, idx++);
		int temp = n;

		while (true) {
			int sum = 0;
			while (temp != 0) {
				int rest = temp % 10;
				sum += pow(rest, m);
				temp /= 10;
			}

			if (map.containsKey(sum)) {
				System.out.println(map.get(sum));
				return;
			}

			map.put(sum, idx++);
			temp = sum;
		}
	}

	public static int pow(int a, int b) {
		int sum = 1;
		for (int i = 0; i < b; i++) {
			sum *= a;
		}
		return sum;
	}
}

