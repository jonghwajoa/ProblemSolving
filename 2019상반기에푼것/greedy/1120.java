import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        int len1 = input[0].length();
        int len2 = input[1].length();
        int ans = Integer.MAX_VALUE;
        if (len1 != len2) {
            int diff = len2 - len1;

            for (int i = 0; i <= diff; i++) {
                int count = 0;
                int range = i + len1;

                for (int j = 0; j < len1; j++) {
                    if (input[0].charAt(j) != input[1].charAt(j + i)) {
                        count += 1;
                    }
                }

                if (count < ans) {
                    ans = count;
                }
            }
        } else {
            ans = 0;
            for (int i = 0; i < len1; i++) {
                if (input[0].charAt(i) != input[1].charAt(i)) {
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}
