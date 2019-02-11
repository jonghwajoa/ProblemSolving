import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int repeat = Integer.parseInt(sc.nextLine());

		while (repeat-- > 0) {
			String[] line = sc.nextLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int target = Integer.parseInt(line[1]);
			Queue<Node> q = new LinkedList<>();

			line = sc.nextLine().split(" ");

			int ans = 0;
			for (int i = 0; i < n; i++) {
				q.add(new Node(i, Integer.parseInt(line[i])));
			}

			while (!q.isEmpty()) {
				Node cur = q.poll();
				int priority = cur.priority;

				boolean isFirst = true;
				for (Node e : q) {
					if (priority < e.priority) {
						isFirst = false;
						break;
					}
				}
				if (isFirst) {
					ans += 1;
					if (cur.index == target) {
						System.out.println(ans);
						break;
					}
				} else {
					q.add(cur);
				}
			}
		}
	}
}

class Node {
	int index;
	int priority;

	public Node(int index, int priority) {
		super();
		this.index = index;
		this.priority = priority;
	}

}