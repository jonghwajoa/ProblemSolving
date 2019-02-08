package boj;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int buildH = sc.nextInt();
		int curH = sc.nextInt();
		int targetH = sc.nextInt();
		int up = sc.nextInt();
		int down = sc.nextInt();
		// f층으로 이뤄진 건물
		// 스타트링크는 g층
		// 강호는 현재 s층
		// u층 위로
		// d층 아래로 이동

		boolean[] visit = new boolean[buildH + 1];
		int[] move = { up, down * -1 };
		int[] dist = new int[buildH + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(curH);
		visit[curH] = true;

		if (targetH == curH) {
			System.out.println(0);
			return;
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 0; i < 2; i++) {
				int next = cur + move[i];
				if (0 < next && next <= buildH) {
					if (!visit[next]) {
						visit[next] = true;
						q.add(next);
						dist[next] = dist[cur] + 1;
						if (targetH == next) {
							break;
						}
					}
				}
			}
		}

		if (dist[targetH] == 0) {
			System.out.println("use the stairs");
		} else {
			System.out.println(dist[targetH]);
		}
	}
}