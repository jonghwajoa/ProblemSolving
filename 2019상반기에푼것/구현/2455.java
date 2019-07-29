import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int acc = 0;
		int ans = 0;
		while (true) {
			int getOff = sc.nextInt();
			int getOn = sc.nextInt();

			if (getOn == 0) {
				break;
			}

			acc = acc + getOn - getOff;

			if (ans < acc) {
				ans = acc;
			}
		}
		System.out.println(ans);
	}
}