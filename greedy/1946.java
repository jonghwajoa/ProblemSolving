import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int repeat = sc.nextInt();

        while (repeat-- > 0) {
            int n = sc.nextInt();
            int[] input = new int[n + 1];

            for (int i = 0; i < n; i++) {
                input[sc.nextInt()] = sc.nextInt();
            }

            int ans = n;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    if (input[i] > input[j]) {
                        ans -= 1;
                        break;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
