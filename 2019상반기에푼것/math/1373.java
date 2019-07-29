import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringBuilder sb = new StringBuilder(s);
		if (s.length() % 3 == 1) {
			sb.insert(0, "00");
		} else if (s.length() % 3 == 2) {
			sb.insert(0, "0");
		}

		int repeat = sb.length() / 3;
		for (int i = 0; i < repeat; i++) {
			System.out.print(
					(sb.charAt(i * 3) - '0') * 4 + (sb.charAt(i * 3 + 1) - '0') * 2 + (sb.charAt(i * 3 + 2) - '0'));
		}
		System.out.println();
	}
}