import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (sc.nextInt() == 1) {
                count++;
            }
        }

        if (count > n - count) {
            System.out.println("Junhee is cute!");
        } else {
            System.out.println("Junhee is not cute!");
        }
    }

}