import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int first = sc.nextInt();
		int second = sc.nextInt();

		String strFirst = "";
		String strSecond = "";
		for (int i = 0; i < 3; i++) {
			strFirst += first % 10;
			strSecond += second % 10;

			first /= 10;
			second /= 10;
		}

		first = Integer.parseInt(strFirst);
		second = Integer.parseInt(strSecond);

		System.out.println(Math.max(first, second));
	}
}