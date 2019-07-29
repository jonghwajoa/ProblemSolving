import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] alphbetHit = new int[10];

		char[] input = sc.nextLine().toCharArray();

		int len = input.length;

		for (int i = 0; i < len; i++) {
			int n = Character.getNumericValue(input[i]);

			if (n == 9) {
				alphbetHit[6] += 1;
			} else {
				alphbetHit[n] += 1;
			}
		}

		alphbetHit[6] = (int) Math.ceil(alphbetHit[6] / 2.0);
		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < 10; i++) {
			if (ans < alphbetHit[i]) {
				ans = alphbetHit[i];
			}
		}
		System.out.println(ans);
	}
}
