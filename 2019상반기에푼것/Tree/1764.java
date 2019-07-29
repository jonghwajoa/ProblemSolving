package temp;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<String> set = new HashSet<String>();
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<String> ans = new ArrayList<String>();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			set.add(sc.nextLine());
		}

		for (int i = 0; i < m; i++) {
			String input = sc.nextLine();
			if (set.contains(input)) {
				ans.add(input);
			}
		}

		Collections.sort(ans);

		int len = ans.size();
		StringBuilder sb = new StringBuilder();
		sb.append(len + "\n");
		for (int i = 0; i < len; i++) {
			sb.append(ans.get(i) + "\n");
		}
		System.out.println(sb);
	}
}
