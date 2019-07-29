import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = 0;
		int b = 0;
		
		for (int i = 0; i < 4; i++) {
			a += sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			b += sc.nextInt();
		}
		
		System.out.println(Math.max(a, b));

	}
}