import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    final static int RIGHT = 0, UP = 1, LEFT = 2, DOWN = 3;
    final static int[] mx = { 1, 0, -1, 0 };
    final static int[] my = { 0, -1, 0, 1 };

    static int ans, N, M, C, CAPACITY, maxA, maxB;
    static int[][] map;
    static boolean[][] visit;
    static LinkedList<Integer> listA, listB;

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        final int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc += 1) {
            ans = 0;
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();
            CAPACITY = C * C;
            map = new int[N][N];
            maxA = 0;
            maxB = 0;
            visit = new boolean[N][N];
            listA = new LinkedList<>();
            listB = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            solve(0);
            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void solve(int step) {
        if (step >= 2) {
            cal2();
            return;
        }

        int sum = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x <= N - M; x++) {

                // 연속으로 갈수 있는지 확인
                boolean flag = false;
                for (int z = x; z < x + M; z++) {
                    if (visit[y][z]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }

                for (int z = x; z < x + M; z++) {
                    visit[y][z] = true;
                    if (step == 0) {
                        listA.add(map[y][z]);
                    } else {
                        listB.add(map[y][z]);
                    }
                    sum += map[y][z];
                }

                solve(step + 1);

                for (int z = x; z < x + M; z++) {
                    visit[y][z] = false;
                    if (step == 0) {
                        listA.clear();
                    } else {
                        listB.clear();
                    }
                    sum = 0;
                }
            }
        }
    }

    public static int cal2() {
        int sum = 0;

        maxA = 0;
        maxB = 0;
        findMax(listA, 0, 0, 0, 0);
        findMax(listB, 0, 0, 0, 1);

        if (ans < maxA + maxB) {
            ans = maxA + maxB;
        }

        return sum;
    }

    public static void findMax(LinkedList<Integer> list, int acc, int accPow, int step, int a) {
        if (step >= M) {
            if (a == 0) {
                if (maxA < accPow) {
                    maxA = accPow;
                }
            } else {
                if (maxB < accPow) {
                    maxB = accPow;
                }
            }
            return;
        }

        if (acc + list.get(step) <= C) {
            findMax(list, acc + list.get(step), accPow + (int) Math.pow(list.get(step), 2), step + 1, a);
        }

        findMax(list, acc, accPow, step + 1, a);
    }
}
