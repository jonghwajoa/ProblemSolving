import java.util.*;

public class Main {
    static int[][] map;
    static int nDivideSecond;
    static int n;
    static int ans = Integer.MAX_VALUE;
    static int[] left, right;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());
        nDivideSecond = n / 2;
        map = new int[n][n];

        String[] line;
        for (int i = 0; i < n; i++) {
            line = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        left = new int[nDivideSecond];
        right = new int[nDivideSecond];

        dfs(0, 0, 0);
        System.out.println(ans);
    }

    public static void dfs(int curIndex, int leftIndex, int rightIndex) {
        if (curIndex == n) {
            calculate();
        } else {
            if (leftIndex < nDivideSecond && rightIndex < nDivideSecond) {
                left[leftIndex] = curIndex;
                dfs(curIndex + 1, leftIndex + 1, rightIndex);

                right[rightIndex] = curIndex;
                dfs(curIndex + 1, leftIndex, rightIndex + 1);
            } else if (rightIndex < nDivideSecond) {
                right[rightIndex] = curIndex;
                dfs(curIndex + 1, leftIndex, rightIndex + 1);
            } else {
                left[leftIndex] = curIndex;
                dfs(curIndex + 1, leftIndex + 1, rightIndex);
            }
        }
    }

    public static void calculate() {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nDivideSecond; i++) {
            int leftFixedVal = left[i];
            int rightFixedVal = right[i];
            for (int j = 0; j < nDivideSecond; j++) {
                if (i != j) {
                    leftSum += map[leftFixedVal][left[j]];
                    rightSum += map[rightFixedVal][right[j]];

                }
            }
        }

        int diff = Math.abs(leftSum - rightSum);
        if (diff < ans) {
            ans = diff;
        }
    }
}