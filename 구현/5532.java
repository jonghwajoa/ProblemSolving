import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int koreanLang = a % c > 0 ? a / c + 1 : a / c;
        int math = b % d > 0 ? b / d + 1 : b / d;

        System.out.println(l - Math.max(koreanLang, math));
    }
}