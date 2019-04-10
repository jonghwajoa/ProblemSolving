
// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpFQaAQMDFAUq&categoryId=AV5PpFQaAQMDFAUq&categoryType=CODE
import java.util.Scanner;

public class Solution {
    final static int DAILY = 0, MONTHLY = 1, QUARTER = 2, YEAR = 3;
    static int ans;
    static boolean[] visit;
    static int[] price, use;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc += 1) {
            price = new int[4];
            use = new int[12];
            visit = new boolean[12];
            ans = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                price[i] = sc.nextInt();
            }

            for (int i = 0; i < 12; i++) {
                use[i] = sc.nextInt();
            }

            dfs(0, 0);

            if (price[YEAR] < ans) {
                ans = price[YEAR];
            }

            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void dfs(int acc, int month) {
        if (month >= 12) {
            if (acc < ans) {
                ans = acc;
            }
            return;
        }

        if (isLowPrice(month)) {
            dfs(acc + price[QUARTER], month + 3);
        }

        if (use[month] * price[DAILY] < price[MONTHLY]) {
            acc = acc + use[month] * price[DAILY];
        } else {
            acc = acc + price[MONTHLY];
        }
        dfs(acc, month + 1);
    }

    // 3달 이용권을 사는것이 더 저렴하니..?
    public static boolean isLowPrice(int startMonth) {
        int acc = 0;
        for (int i = startMonth; i < startMonth + 3; i++) {
            if (12 <= i) {
                break;
            }

            if (use[i] == 0) {
                continue;
            }

            int dailyPrice = price[DAILY] * use[i];
            if (dailyPrice < price[MONTHLY]) {
                acc += dailyPrice;
            } else {
                acc += price[MONTHLY];
            }
        }

        if (acc < price[QUARTER]) {
            return false;
        }
        return true;
    }
}
