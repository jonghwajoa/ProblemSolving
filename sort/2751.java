import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean[] positive = new boolean[1000001];
        boolean[] negative = new boolean[1000001];

        int repeat = sc.nextInt();

        for (int i = 0; i < repeat; i++) {
            int n = sc.nextInt();
            if (n < 0) {
                negative[n * -1] = true;
            } else {
                positive[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = -1000000; i < 0; i++) {
            if (negative[i * -1]) {
                sb.append(i + "\n");
            }
        }

        for (int i = 0; i <= 1000000; i++) {
            if (positive[i]) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}