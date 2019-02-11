import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        Long sum = 0L;

        Long idx = 1L;
        while (sum < n) {
            sum += idx++;
        }

        if (sum == n) {
            System.out.println(idx - 1);
        } else {
            System.out.println(idx - 2);
        }
    }
}