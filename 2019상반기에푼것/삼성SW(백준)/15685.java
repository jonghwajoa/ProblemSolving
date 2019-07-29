import java.util.Scanner;

public class Main {
    final static int RIGHT = 0, UP = 1, LEFT = 2, DOWN = 3;
    final static int[] mx = { 1, 0, -1, 0 };
    final static int[] my = { 0, -1, 0, 1 };

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[][] memo = new int[4][1024];
        int[] generation = new int[11];
        boolean[][] map = new boolean[101][101];

        for (int i = 0; i < 11; i++) {
            generation[i] = (int) Math.pow(2, i);
        }

        // 세대별 패턴 구하기
        memo[0][0] = 0;
        memo[1][0] = 1;
        memo[2][0] = 2;
        memo[3][0] = 3;
        for (int g = 1; g <= 10; g += 1) {
            int prev = generation[g - 1];
            int next = generation[g];
            for (int i = prev, j = 1; i < next; i++, j++) {
                memo[0][i] = (memo[0][prev - j] + 1) % 4;
                memo[1][i] = (memo[1][prev - j] + 1) % 4;
                memo[2][i] = (memo[2][prev - j] + 1) % 4;
                memo[3][i] = (memo[3][prev - j] + 1) % 4;
            }
        }

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();
            map[y][x] = true;

            int len = generation[g];
            for (int j = 0; j < len; j++) {
                int nextD = memo[d][j];
                x += mx[nextD];
                y += my[nextD];
                map[y][x] = true;
            }
        }

        int ans = 0;
        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                if (map[y][x] && map[y + 1][x] && map[y][x + 1] && map[y + 1][x + 1]) {
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}