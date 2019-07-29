import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 여학생
		int M = sc.nextInt(); // 남학생
		int K = sc.nextInt(); // 인턴십
		int ans = 0;
		// 조건 2N + M = 1TEAM

		while (N >= 2 && M >= 1 && M + N >= K + 3) {
			ans += 1;
			N -= 2;
			M -= 1;
		}
		System.out.println(ans);
	}
}