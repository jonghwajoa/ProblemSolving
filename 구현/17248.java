import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int c = sc.nextInt();
            int min = 0;
            int acc = 0;
            while (A < B) {
                acc += c;
                A += acc;
                min += 1;
            }
            System.out.println(min);
        }
    }
}