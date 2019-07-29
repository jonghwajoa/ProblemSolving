import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        char op = sc.nextLine().charAt(0);
        String b = sc.nextLine();

        int alen = a.length();
        int blen = b.length();
        StringBuilder ans = new StringBuilder();
        if (op == '*') {

            ans.append("1");
            int repeat = alen + blen - 2;
            for (int i = 0; i < repeat; i++) {
                ans.append("0");
            }
        } else {
            if (alen == blen) {
                ans.append(a);
                ans.replace(0, 1, "2");
            } else {
                if (alen < blen) {
                    String tmp = b;
                    b = a;
                    a = tmp;
                }
                ans.append(a);
                int diff = a.length() - b.length();
                ans.replace(diff, diff + 1, "1");
            }
        }
        System.out.println(ans);
    }
}
