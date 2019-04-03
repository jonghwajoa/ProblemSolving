import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		final Scanner sc = new Scanner(System.in);
		final int ROOM_N = sc.nextInt();
		final int[] input = new int[ROOM_N];

		for (int i = 0; i < ROOM_N; i++) {
			input[i] = sc.nextInt();
		}

		int main = sc.nextInt();
		int sub = sc.nextInt();

		Long ans = (long) ROOM_N;

		for (int cur : input) {
			cur -= main;
			if(cur <= 0) continue;
			cur = (int) Math.ceil(cur / (double) sub);
			ans += (long) cur;
		}

		System.out.println(ans);
	}
}
