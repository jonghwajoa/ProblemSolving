import java.util.Scanner;

public class Main {
    static int N, TARGET, ans;
    static int[] input;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long ans = 0L;
        int stand = 10;
        int start = 9;
        int ci = 1;
        int acc = 0;

        if (n < 10) {
            System.out.println(n);
            return;
        }

        while (stand <= n) {
            ans = ans + (start * ci);
            stand *= 10;
            ci += 1;
            acc += start;
            start *= 10;
        }

        int remain = (n - acc) * ci;
        System.out.println(ans + remain);
    }
}
