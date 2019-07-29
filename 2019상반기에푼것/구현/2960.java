import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        ArrayList<Integer> ans = new ArrayList<>();

        prime[0] = prime[1] = false;

        for (int i = 2; i < n + 1; i++) {
            if (prime[i]) {
                ans.add(i);
                for (int j = i + i; j < n + 1; j += i) {
                    if (prime[j]) {
                        ans.add(j);
                    }
                    prime[j] = false;
                }
            }
        }
        System.out.println(ans.get(k - 1));
    }
}