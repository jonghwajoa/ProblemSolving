import java.util.*;

public class Main {

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        boolean[] submit = new boolean[30];

        for (int i = 0; i < 28; i++) {
            int n = sc.nextInt();

            submit[n - 1] = true;
        }

        for (int i = 0; i < 30; i++) {
            if (!submit[i]) {
                System.out.println(i + 1);
            }
        }
    }
}