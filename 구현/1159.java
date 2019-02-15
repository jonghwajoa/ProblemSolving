import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] alpha = new int[26];

        for (int i = 0; i < n; i++) {
            String tmp = sc.nextLine();
            alpha[tmp.charAt(0) - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (alpha[i] >= 5) {
                ans.append((char) (i + 'a'));
            }
        }

        if (ans.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(ans);
        }

    }
}