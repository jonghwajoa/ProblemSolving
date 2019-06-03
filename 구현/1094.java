import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int acc = 0;
        int count = 0;

        while (n != 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }

        System.out.println(count);
    }
}
