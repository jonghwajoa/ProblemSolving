import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] cup = { 1, 2, 3 };

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;

            int tmp = cup[x];
            cup[x] = cup[y];
            cup[y] = tmp;
        }

        for (int i = 0; i < 3; i++) {
            if (cup[i] == 1) {
                System.out.println(i + 1);
            }
        }
    }

}
