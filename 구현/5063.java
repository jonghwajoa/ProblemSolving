import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();

        while (repeat-- > 0) {
            int r = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();

            int benefit = e - c;

            if (benefit == r) {
                System.out.println("does not matter");
            } else if (benefit > r) {
                System.out.println("advertise");
            } else {
                System.out.println("do not advertise");
            }
        }
    }
}
