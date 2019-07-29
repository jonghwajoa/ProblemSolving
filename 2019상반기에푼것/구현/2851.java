import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] acc = new int[10];

        acc[0] = sc.nextInt();

        for (int i = 1; i < 10; i++) {
            acc[i] = acc[i - 1] + sc.nextInt();
        }

        int overN = 0;
        for (int i = 0; i < 10; i++) {
            if (acc[i] > 100) {
                overN = i;
                break;
            }
        }

        if (overN == 0) {
            if (acc[0] > 100) {
                System.out.println(acc[0]);
            } else {
                System.out.println(acc[9]);
            }
        } else {
            int a = Math.abs(100 - acc[overN]);
            int b = Math.abs(100 - acc[overN - 1]);
            int ansIdx = a > b ? overN - 1 : overN;
            System.out.println(acc[ansIdx]);
        }
    }
}
