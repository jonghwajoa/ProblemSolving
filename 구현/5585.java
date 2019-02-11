import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coin = { 500, 100, 50, 10, 5, 1 };

        int n = 1000 - sc.nextInt();
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            ans += n / coin[i];
            n %= coin[i];
        }

        System.out.println(ans);
    }
}