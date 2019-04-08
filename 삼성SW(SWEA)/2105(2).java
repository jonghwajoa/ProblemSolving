import java.util.Scanner;

class Solution {
    final static int RIGHT = 0, UP = 1, LEFT = 2, DOWN = 3;
    final static int[] mx = { 1, -1, -1, 1 };
    final static int[] my = { 1, 1, -1, -1 };
    static int N, ans;
    static int[][] map;
    static int[] count;
    static boolean[] visit;

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        final int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc += 1) {
            N = sc.nextInt();
            map = new int[N][N];
            visit = new boolean[101];
            count = new int[4];
            ans = -1;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    map[y][x] = sc.nextInt();
                }
            }

            for (int y = 0; y < N - 2; y++) {
                for (int x = 1; x < N - 1; x++) {
                    solve(x, y, 0);
                }

            }
            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void solve(int x, int y, int step) {
        if (x < 0 || N <= x || y < 0 || N <= y) {
            return;
        }

        if (step >= 4) {
            cal();
            return;
        }

        if (visit[map[y][x]]) {
            return;
        }

        visit[map[y][x]] = true;
        count[step] += 1;

        int nextX = x + mx[step];
        int nextY = y + my[step];

        if (step < 2) {
            solve(nextX, nextY, step + 1);
        } else {
            if (count[step] == count[(step + 2) % 4]) {
                solve(nextX, nextY, step + 1);
            }
        }

        solve(nextX, nextY, step);

        count[step] -= 1;
        visit[map[y][x]] = false;
    }

    public static void cal() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += count[i];
        }
        if (ans < sum) {
            ans = sum;
        }
    }
}
