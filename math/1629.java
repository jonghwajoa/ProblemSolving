import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();

		System.out.println(calculate(a, b, c));

	}

	public static long calculate(long a, long b, long c) {
		if (b == 0) {
			return 1L;
		} else if (b == 1) {
			return a % c;
		} else if (b % 2 == 0) {
			long tmp = calculate(a, b / 2, c);
			return (tmp * tmp) % c;
		} else {
			return (calculate(a, b - 1, c) * a) % c;
		}
	}
}
