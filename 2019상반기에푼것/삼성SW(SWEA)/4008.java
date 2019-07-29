import java.util.Arrays;
import java.util.Scanner;

class Solution {
    final static int ADD = 0, SUB = 1, MUL = 2, DIV = 3;
    static int[] op, num;
    static int max, min, N;

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        final int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            N = sc.nextInt();
            op = new int[4];
            num = new int[N];

            for (int i = 0; i < 4; i++) {
                op[i] = sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                num[i] = sc.nextInt();
            }

            dfs(0, num[0]);
            int ans = max - min;
            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void dfs(int step, int acc) {
        if (step >= N - 1) {
            if (acc < min) {
                min = acc;
            }

            if (max < acc) {
                max = acc;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] != 0) {
                op[i] -= 1;
                int nextAcc = cal(acc, num[step + 1], i);
                dfs(step + 1, nextAcc);
                op[i] += 1;
            }
        }
    }

    public static int cal(int preNo, int nextNo, int op) {
        int calResult = 0;
        switch (op) {
        case 0:
            calResult = preNo + nextNo;
            break;
        case 1:
            calResult = preNo - nextNo;
            break;
        case 2:
            calResult = preNo * nextNo;
            break;
        case 3:
            calResult = preNo / nextNo;
            break;
        }
        return calResult;
    }
}
