import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String n = sc.nextLine();

            if (n.equals("0")) {
                break;
            }

            String result = cal(n);

            while (Long.parseLong(result) >= 10) {
                result = cal(result);
            }

            System.out.println(Long.parseLong(result));
        }
    }

    public static String cal(String n) {
        char[] c = n.toCharArray();
        Long sum = 0L;
        for (int i = 0; i < c.length; i++) {
            sum += Character.getNumericValue(c[i]);
        }
        return sum.toString();
    }
}
