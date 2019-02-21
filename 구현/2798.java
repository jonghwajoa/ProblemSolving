import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int m = sc.nextInt();
        int max = Integer.MIN_VALUE;

        int curIndx = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (tmp <= m) {
                arr[curIndx] = tmp;
                curIndx += 1;
            }
        }
        n = curIndx;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int z = j + 1; z < n; z++) {
                    int sum = arr[i] + arr[j] + arr[z];
                    if (sum <= m) {
                        if (max < sum) {
                            max = sum;
                        }

                        if (sum == m) {
                            System.out.println(m);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
