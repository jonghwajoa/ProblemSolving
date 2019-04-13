import java.util.Scanner;

public class Main {
    // 가로, 세로, 대각선
    static int[] my = { 0, 1, 1 };
    static int[] mx = { 1, 0, 1 };
    static int[][] map;
    static int N;
    static int direction, ans;

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        ans = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                map[y][x] = sc.nextInt();
            }
        }
        dfs(1, 0, 0);

        System.out.println(ans);
    }

    public static void dfs(int x, int y, int d) {

        if (x == N - 1 && y == N - 1) {
            ans += 1;
            return;
        }

        switch (d) {
        case 0:
            // 가로일때
            for (int i = 0; i < 3; i += 2) {
                if (isSafe(x, y, i)) {
                    int nextX = x + mx[i];
                    int nextY = y + my[i];
                    dfs(nextX, nextY, i);
                }
            }
            break;
        case 1:
            // 세로일때
            for (int i = 1; i < 3; i += 1) {
                if (isSafe(x, y, i)) {
                    int nextX = x + mx[i];
                    int nextY = y + my[i];
                    dfs(nextX, nextY, i);
                }
            }
            break;
        case 2:
            for (int i = 0; i < 3; i += 1) {
                if (isSafe(x, y, i)) {
                    int nextX = x + mx[i];
                    int nextY = y + my[i];
                    dfs(nextX, nextY, i);
                }
            }
            break;
        }
    }

    public static boolean isSafe(int x, int y, int d) {
        switch (d) {
        case 0:
            if (N <= x + 1) {
                return false;
            }

            if (map[y][x + 1] != 1) {
                return true;
            }
            break;
        case 1:
            if (N <= y + 1) {
                return false;
            }

            if (map[y + 1][x] != 1) {
                return true;
            }
            break;
        case 2:
            for (int i = 0; i < 3; i++) {
                int nextX = x + mx[i];
                int nextY = y + my[i];
                if (N <= nextX || N <= nextY || map[nextY][nextX] == 1) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
// 가로로 놓여있는경우 2가지방법
// 세로 2가지
// 대각선 3가지 방법

class Point {
    int x;
    int y;
    int d;

    public Point(int x, int y, int d) {
        super();
        this.x = x;
        this.y = y;
        this.d = d;
    }

}