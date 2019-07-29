import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Set<String> set = new HashSet<>();
		sc.nextLine();

		for (int i = 0; i < n; ++i) {
			String line[] = sc.nextLine().split("\\s");

			if (line[1].equals("leave") && set.contains(line[0])) {
				set.remove(line[0]);
			} else {
				set.add(line[0]);
			}
		}

		String[] ans = set.toArray(new String[set.size()]);
		Arrays.sort(ans);
		StringBuilder sb = new StringBuilder();
		for (int i = ans.length - 1; i >= 0; i--) {
			sb.append(ans[i] + "\n");
		}

		System.out.println(sb);
	}
}
