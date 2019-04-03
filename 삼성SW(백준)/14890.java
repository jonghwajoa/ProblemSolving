import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		final int N = sc.nextInt();
		final int L = sc.nextInt();

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int ans = 0;
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			int prev = map[i][0];
			boolean[] visit = new boolean[N];
			flag = true;

			for (int j = 1; j < N; j++) {
				int next = map[i][j];
				int abs = Math.abs(next - prev);

				if (abs > 1) {
					flag = false;
					break;
				} else if (abs == 0) {
					continue;
				}

				if (next < prev) {
					visit[j] = true;
					for (int z = j + 1; z < j + L; z++) {
						if (z >= N || next != map[i][z]) {
							flag = false;
							break;
						}
						visit[z] = true;
					}
					j = j + L - 1;

				} else {
					for (int z = j - 1; j - L <= z; z--) {
						if (z < 0 || visit[z] || prev != map[i][z]) {
							flag = false;
							break;
						}
						visit[z] = true;
					}
				}

				if (!flag) {
					break;
				}
				prev = next;

			}

			if (flag) {
				ans += 1;
			}
		}

		for (int i = 0; i < N; i++) {
			int prev = map[0][i];
			boolean[] visit = new boolean[N];
			flag = true;

			for (int j = 1; j < N; j++) {
				int next = map[j][i];
				int abs = Math.abs(next - prev);

				if (abs > 1) {
					flag = false;
					break;
				} else if (abs == 0) {
					continue;
				}

				if (next < prev) {
					visit[j] = true;
					for (int z = j + 1; z < j + L; z++) {
						if (z >= N || next != map[z][i]) {
							flag = false;
							break;
						}
						visit[z] = true;
					}
					j = j + L - 1;

				} else {
					for (int z = j - 1; j - L <= z; z--) {
						if (z < 0 || visit[z] || prev != map[z][i]) {
							flag = false;
							break;
						}
						visit[z] = true;
					}
				}

				if (!flag) {
					break;
				}
				prev = next;

			}

			if (flag) {
				ans += 1;
			}
		}

		System.out.println(ans);
	}
}