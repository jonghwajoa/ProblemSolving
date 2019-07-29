import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[] input = new String[n + 1];
		sc.nextLine();
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			input[i] = sc.nextLine();
			map.put(input[i], i);
		}

		for (int i = 0; i < m; i++) {
			String find = sc.nextLine();
			try {
				int N = Integer.parseInt(find);
				System.out.println(input[N]);
			} catch (NumberFormatException e) {
				System.out.println(map.get(find));
			}
		}

	}
}
