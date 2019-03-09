import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		int b = sc.nextInt();
		int c = sc.nextInt();

		int possible = (int) Math.sqrt((double) (b * b + c * c));

		while (a-- > 0) {
			if (possible >= sc.nextInt()) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		}

	}
}
