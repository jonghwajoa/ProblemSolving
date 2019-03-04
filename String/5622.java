import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] match = { 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10 };

        char[] str = sc.nextLine().toCharArray();
        int len = str.length;
        int ans = 0;

        for (int i = 0; i < len; i++) {
            ans += match[str[i] - 'A'];
        }

        System.out.println(ans);
    }
}
