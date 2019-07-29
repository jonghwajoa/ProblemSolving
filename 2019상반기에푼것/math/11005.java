import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int r = n % b;
			if(r >= 10) {
				sb.append((char)(r + 'A' - 10));

			}else {
				sb.append((char)((char)r+'0'));
			}
			n /= b;
		}
		System.out.println(sb.reverse());

	}

}
