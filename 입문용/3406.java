import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();

        for (int i = 0; i < repeat; i++) {
            int n = sc.nextInt();
            int index = 0;
            while (n != 0) {
                if (n % 2 == 1) {
                    System.out.print(index + " ");
                }
                n /= 2;
                index += 1;
            }
            System.out.println();
        }

    }
}
