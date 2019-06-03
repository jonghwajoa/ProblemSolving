import java.util.Scanner;

public class Main {
    static int aim;
    static boolean ans;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        aim = sc.nextInt();

        if (aim == 0) {
            System.out.println("NO");
            return;
        }

        dfs(0, 0L);
        System.out.println(ans ? "YES" : "NO");
    }

    public static void dfs(int n, long acc) {
        if (acc == aim) {
            ans = true;
            return;
        }

        if (Integer.MAX_VALUE < acc) {
            return;
        }

        if (20 <= n) {
            return;
        }

        long v = (long) Math.pow(3, n);
        dfs(n + 1, acc);
        dfs(n + 1, acc + v);
    }
}
