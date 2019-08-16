import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int c1 = Integer.parseInt(input[0]);
        int p1 = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int c2 = Integer.parseInt(input[0]);
        int p2 = Integer.parseInt(input[1]);

        int cp = p1 * p2;
        c1 *= p2;
        c2 *= p1;
        int cc = c1 + c2;

        int gcd = getGCD(cp, cc);

        cc /= gcd;
        cp /= gcd;
        System.out.println(cc + " " + cp);
    }

    public static int getGCD(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int remain = a % b;
        while (remain != 0) {
            a = b;
            b = remain;
            remain = a % b;
        }
        return b;
    }
}
