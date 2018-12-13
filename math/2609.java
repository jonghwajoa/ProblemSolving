import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int gcd = 0, l = 0;
		int max = Math.max(a, b);

		for (int i = max; 0 < i; i--) {
			if (a % i == 0 && b % i == 0) {
				gcd = i;
				l = gcd * (a / i) * (b / i);
				break;
			}
		}

		System.out.println(gcd);
		System.out.println(l);
	}
}