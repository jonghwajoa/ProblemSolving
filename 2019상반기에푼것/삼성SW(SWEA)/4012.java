
// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH&categoryId=AWIeUtVakTMDFAVH&categoryType=CODE

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    static int[][] map;
    static boolean[] visit;
    static int min, N;

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        final int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc++) {
            min = Integer.MAX_VALUE;

            N = sc.nextInt();
            map = new int[N][N];
            visit = new boolean[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            dfs(0, 0);
            System.out.println("#" + tc + " " + min);
        }
    }

    public static void dfs(int step, int next) {
        if (step >= N / 2) {
            cal();
            return;
        }

        for (int i = next; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(step + 1, i + 1);
                visit[i] = false;
            }
        }
    }

    public static void cal() {
        int[] ok = new int[N / 2];
        int[] no = new int[N / 2];
        int okIndex = 0, noIndex = 0;
        for (int i = 0; i < N; i++) {
            if (visit[i]) {
                ok[okIndex] = i;
                okIndex++;
            } else {
                no[noIndex] = i;
                noIndex++;
            }
        }

        int sumA = 0, sumB = 0;
        int len = ok.length;
        for (int i = 0; i < len; i++) {
            int okY = ok[i];
            int noY = no[i];

            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                int okX = ok[j];
                int noX = no[j];

                sumA += map[okY][okX];
                sumB += map[noY][noX];
            }
        }

        int abs = Math.abs(sumA - sumB);
        if (abs < min) {
            min = abs;
        }
    }
}
