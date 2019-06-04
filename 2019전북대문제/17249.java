import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("0");

        int left = 0;
        int right = 0;
        for (char c : str[0].toCharArray()) {
            if (c == '@') {
                left += 1;
            }
        }

        for (char c : str[1].toCharArray()) {
            if (c == '@') {
                right += 1;
            }
        }
        System.out.println(left + " " + right);
    }
}
