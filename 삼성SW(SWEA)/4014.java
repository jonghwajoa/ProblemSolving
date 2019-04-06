
// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeW7FakkUDFAVH

import java.util.Scanner;

class Solution {
    final static int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    final static int[] mx = { 0, 1, 0, -1 };
    final static int[] my = { -1, 0, 1, 0 };
    static int N, ans, K;
    static int[][] map, map2;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();
            ans = 0;
            map = new int[N][N];
            map2 = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int tmp = sc.nextInt();
                    map[i][j] = tmp;
                    map2[j][i] = tmp;
                }
            }
            solve();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = map2[i][j];
                }
            }

            solve();
            System.out.println("#" + tc + " " + ans);

        }
    }

    public static void solve() {

        for (int y = 0; y < N; y++) {
            int prev = map[y][0];
            boolean flag = false;
            boolean[] visit = new boolean[N];
            for (int x = 0; x < N; x++) {
                if (prev == map[y][x]) {
                    continue;
                }

                int abs = Math.abs(prev - map[y][x]);
                if (abs > 1) {
                    flag = true;
                    break;
                }

                if (prev < map[y][x]) {
                    if (x - K < 0) {
                        flag = true;
                        break;
                    }

                    for (int z = x - 1; x - K <= z; z--) {
                        if (visit[z] || map[y][z] != prev) {
                            flag = true;
                            break;
                        }
                        visit[z] = true;
                    }
                } else {
                    // next가 더작은거임
                    if (N <= x + K - 1) {
                        flag = true;
                        break;
                    }
                    for (int z = x; z < x + K; z++) {
                        if (visit[z] || map[y][x] != map[y][z]) {
                            flag = true;
                            break;
                        }
                        visit[z] = true;
                    }
                    x = x + K - 1;
                }

                if (flag) {
                    break;
                }
                prev = map[y][x];
            }

            if (!flag) {
                ans += 1;
            }
        }
    }
}
