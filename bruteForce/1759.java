import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.nextLine();
		String[] alpha = sc.nextLine().split("\\s");

		Arrays.sort(alpha);
		solve(A, alpha, "", 0);
	}

	public static void solve(int n, String[] alpha, String pass, int i) {
		if (n == pass.length()) {
			if (check(pass)) {
				System.out.println(pass);
			}
			return;
		}

		if (i >= alpha.length)
			return;

		solve(n, alpha, pass + alpha[i], ++i);
		solve(n, alpha, pass, i);
	}

	public static boolean check(String pass) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < pass.length(); i++) {
			char temp = pass.charAt(i);

			if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
				b++;
			} else {
				a++;
			}
		}

		return a >= 2 && b >= 1;
	}
}
