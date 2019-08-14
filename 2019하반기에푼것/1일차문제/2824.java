import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");
        BigInteger big1 = new BigInteger(arr[0]);

        int len = arr.length;
        for (int i = 1; i < len; i++) {
            big1 = big1.multiply(new BigInteger(arr[i]));
        }

        N = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");
        BigInteger big2 = new BigInteger(arr[0]);
        len = arr.length;
        for (int i = 1; i < len; i++) {
            big2 = big2.multiply(new BigInteger(arr[i]));
        }

        String gcd = big1.gcd(big2).toString();

        System.out.println(9 < gcd.length() ? gcd.substring(gcd.length() - 9) : gcd);
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
