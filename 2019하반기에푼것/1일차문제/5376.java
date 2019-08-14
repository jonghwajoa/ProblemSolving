import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder ansSB = new StringBuilder();
        while (N-- > 0) {
            String line = br.readLine().substring(2);
            int openIdx = line.indexOf('(');
            int len = line.length();
            if (openIdx < 0) {
                long mother = (int) Math.pow(10, len);
                long son = Integer.parseInt(line);
                long gcd = getGCD(mother, son);
                mother /= gcd;
                son /= gcd;
                ansSB.append(son + "/" + mother + "\n");
            } else {
                StringBuilder motherSB = new StringBuilder();
                StringBuilder sonSB = new StringBuilder();
                for (char c : line.toCharArray()) {
                    if (c == '(' || c == ')') {
                        continue;
                    }
                    sonSB.append(c);
                }
                long son = Long.parseLong(sonSB.toString());
                if (openIdx >= 1) {
                    StringBuilder diff = new StringBuilder();
                    for (int i = 0; i < openIdx; i++) {
                        diff.append(line.charAt(i));
                    }
                    son -= Integer.parseInt(diff.toString());
                }

                len -= 2;
                for (int i = 0; i < len - openIdx; i++) {
                    motherSB.append("9");
                }

                for (int i = 0; i < openIdx; i++) {
                    motherSB.append("0");
                }
                long mother = Long.parseLong(motherSB.toString());
                long gcd = getGCD(mother, son);
                son /= gcd;
                mother /= gcd;
                ansSB.append(son + "/" + mother + "\n");
            }
        }
        System.out.println(ansSB.toString());
    }

    private static long getGCD(long a, long b) {
        if (a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        long remain = a % b;
        while (remain != 0) {
            a = b;
            b = remain;
            remain = a % b;
        }
        return b;
    }
}
