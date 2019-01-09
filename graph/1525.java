import java.beans.Customizer;
import java.util.*;

public class Main {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 3;
		int start = 0;
		int[] d = new int[9];

		for (int i = 0; i < 9; i++) {
			int n = sc.nextInt();
			if (n == 0)
				n = 9;
			d[i] = n;
			start = start * 10 + n;
		}
		if (start == 123456789) {
			System.out.println(0);
			return;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		map.put(start, 0);
		q.add(start);

		while (!q.isEmpty()) {
			int curNum = q.poll();
			String curString = Integer.toString(curNum);
			int idx = curString.indexOf('9');
			int curX = idx % 3;
			int curY = idx / 3;

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				if (0 <= nextX && 0 <= nextY && nextX < 3 && nextY < 3) {
					StringBuilder sb = new StringBuilder(curString);
					char temp = sb.charAt(curY * 3 + curX);
					sb.setCharAt(curY * 3 + curX, sb.charAt(nextY * 3 + nextX));
					sb.setCharAt(nextY * 3 + nextX, temp);
					int nextInt = Integer.parseInt(sb.toString());
					if (!map.containsKey(nextInt)) {
						map.put(nextInt, map.get(curNum) + 1);
						q.add(nextInt);
					}
				}
			}
		}

		if (map.containsKey(123456789)) {
			System.out.println(map.get(123456789));
		} else {
			System.out.println(-1);
		}
	}
}
