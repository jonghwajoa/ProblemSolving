import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int p = sc.nextInt();
		int cal = m * p;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 5; i++) {
			sb.append(sc.nextInt() - cal + " ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
