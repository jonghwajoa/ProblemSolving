package temp;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			String[] line = sc.nextLine().split("\\s");
			int len = line[1].length();
			int repeat = Integer.parseInt(line[0]);

			for (int i = 0; i < len; i++) {
				char alpha = line[1].charAt(i);
				for (int j = 0; j < repeat; j++) {
					sb.append(alpha);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
