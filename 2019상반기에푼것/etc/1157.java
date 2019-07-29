import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine().toLowerCase();
		int[] count = new int[26];
		int len = line.length();

		for (int i = 0; i < len; i++) {
			count[line.charAt(i) - 'a']++;
		}

		int max = Integer.MIN_VALUE;
		int idx = 0;
		for (int i = 0; i < 26; i++) {
			if (max < count[i]) {
				max = count[i];
				idx = i;
			}
		}

		Arrays.sort(count);

		if (count[25] == count[24]) {
			System.out.println("?");
		} else {
			System.out.println((char) ('A' + idx));
		}

	}
}