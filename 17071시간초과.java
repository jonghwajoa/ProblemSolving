import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	final static int INF = 500001;
	static int[] visit = new int[INF];
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] argv) {
		final Scanner sc = new Scanner(System.in);
		int me = sc.nextInt();
		int brother = sc.nextInt();
		Arrays.fill(visit, -1);

		if (brother == me) {
			System.out.println(0);
			return;
		}

		visit[me] = 0;

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(me);
		int acc = 1;
		while (true) {
			int len = q.size();
			for (int i = 0; i < len; i += 1) {
				int cur = q.poll();

				if (cur * 2 < INF) {
					visit[cur * 2] = acc;
					q.add(cur * 2);
				}

				if (cur + 1 < INF) {
					visit[cur + 1] = acc;
					q.add(cur + 1);
				}

				if (0 <= cur - 1) {
					visit[cur - 1] = acc;
					q.add(cur - 1);
				}
			}

			brother += acc;
			if (brother >= INF) {
				ans = -1;
				break;
			}

			if (acc % 2 == 0) {
				if (visit[brother] != -1 && visit[brother] % 2 == 0) {
					ans = visit[brother];
					if (acc != visit[brother]) {
						ans += 2;
					}
					break;
				}
			} else {
				if (visit[brother] != -1 && visit[brother] % 2 == 1) {
					ans = visit[brother];
					if (acc != visit[brother]) {
						ans += 2;
					}
					break;
				}
			}
			acc += 1;
		}
		System.out.println(ans);
	}
}
