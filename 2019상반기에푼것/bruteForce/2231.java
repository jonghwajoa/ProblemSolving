import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] numberOfCase = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        Arrays.fill(numberOfCase, Integer.MAX_VALUE);

        for (int i = 1; i <= target; i++) {
            int sum = i;
            int copyCur = i;

            while (copyCur > 0) {
                sum += copyCur % 10;
                copyCur /= 10;
            }

            if (sum <= 1000000) {
                if (numberOfCase[sum] > i) {
                    numberOfCase[sum] = i;
                }
            }
        }

        if (numberOfCase[target] == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(numberOfCase[target]);
        }
    }
}