import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		int count = 1;
		while (true) {
			if (Math.abs(a - b) == 1 && Math.abs(a / 2 - b / 2) == 1) {
				break;
			}

			a = a / 2 + a % 2;
			b = b / 2 + b % 2;
			count += 1;
		}
		System.out.println(count);
	}
}

