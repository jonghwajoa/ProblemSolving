import java.util.*;

public class simulation {

	static boolean[][] map = new boolean[100][100];

	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		while (n-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			for (int i = b; i < b + 10; i++) {
				for (int j = a; j < a + 10; j++) {
					if (i < 100 && j < 100) {
						if (!map[i][j]) {
							ans += 1;
							map[i][j] = true;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
