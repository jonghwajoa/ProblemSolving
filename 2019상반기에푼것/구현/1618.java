import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int max = 0;

		int[] input = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
			if (max < input[i]) {
				max = input[i];
			}
		}

		boolean flag = true;
		for (int i = 1; i <= max; i++) {
			flag = true;
			for (int j = 0; j < n; j++) {
				if (input[j] % i != 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println(i);
			}
		}
	}
}
