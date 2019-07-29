import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int acc = 0;
        for (int i = 0; i < 4; i++) {
            acc += sc.nextInt();
        }

        int min = acc / 60;
        int seconds = acc % 60;

        System.out.println(min);
        System.out.println(seconds);

    }
}