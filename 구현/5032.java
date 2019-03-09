import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int b = sc.nextInt();
        int c = sc.nextInt();

        int sum = a + b;
        int ans = 0;
        while (sum >= c) {
            int exchange = sum / c;
            ans += exchange;
            sum %= c;
            sum += exchange;
        }

        System.out.println(ans);
    }
}
