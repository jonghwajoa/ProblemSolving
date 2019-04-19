
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static void makePre(int[] arr, int cur, int end, int acc, ArrayList<Integer> array) {
		if (cur >= end)// 끝까지 다 돌았다면
		{
			array.add(acc);// 추가
			return;
		}

		makePre(arr, cur + 1, end, acc, array);// 현재 인덱스를 포함할 때
		makePre(arr, cur + 1, end, acc + arr[cur], array);// 현재 인덱스를 포함하지 않을 때

	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		ArrayList<Integer> first = new ArrayList<>();
		ArrayList<Integer> second = new ArrayList<>();

		makePre(arr, 0, N / 2, 0, first);

		makePre(arr, N / 2, arr.length, 0, second);

		Collections.sort(first);
		Collections.sort(second);

		int left = 0;
		int right = second.size() - 1;
		int leftSize = first.size();
		long ans = 0;

		while (left < leftSize && right >= 0) {
			long ls = first.get(left);
			long rs = second.get(right);

			if (ls + rs == S) {// S와 일치하면, 각 분할 집합에서 해당 합을 지니는 원소의 개수를 셈
				long lc = 0;
				while (left < leftSize && first.get(left) == ls) {
					lc++;
					left++;
				}

				long rc = 0;
				while (right >= 0 && second.get(right) == rs) {
					rc++;
					right--;
				}

				ans += lc * rc;
			} else if (ls + rs > S) {
				right--;
			} else {
				left++;
			}

		}

		if (S == 0) {
			ans -= 1;
		}

		System.out.println(ans);

	}
}