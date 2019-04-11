import java.util.Scanner;

public class Solution {
    final static int[] available = new int[6];
    final static int N = 10;
    final static int[][] map = new int[N][N];
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        for (int i = 1; i < 6; i++) {
            available[i] = 5;
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                map[y][x] = sc.nextInt();
            }
        }

        dfs(0);
        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        System.out.println(ans);

    }

    public static void cal() {
        int sum = 0;
        for (int i = 1; i < 6; i++) {
            sum = sum + 5 - available[i];
        }

        if (sum < ans) {
            ans = sum;
        }
    }

    public static void dfs(int originY) {
        boolean flag = false;
        for (int y = originY; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (y == N - 1 && x == N - 1) {
                    if (map[y][x] == 1) {
                        if (available[1] != 0) {
                            available[1] -= 1;
                            cal();
                            available[1] += 1;
                        }
                    } else {
                        cal();
                    }
                    return;
                }

                if (map[y][x] == 0) {
                    continue;
                }

                for (int size = 1; size <= 5; size++) {
                    if (0 < available[size] && check(x, y, size)) {
                        available[size] -= 1;
                        change(x, y, size, false);
                        dfs(y);
                        available[size] += 1;
                        change(x, y, size, true);
                    }
                }

                flag = true;
                break;
            }
            if (flag) {
                break;
            }
        }
    }

    public static void change(int x, int y, int size, boolean way) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (!way) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }
    }

    public static boolean check(int x, int y, int size) {
        if (N <= y + size - 1 || N <= x + size - 1) {
            return false;
        }

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}