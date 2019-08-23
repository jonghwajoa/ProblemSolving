import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.bind.helpers.DefaultValidationEventHandler;

class Main {
    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        int cnt = 0;
        set.add(input);
        int lastSize = 1;
        while (true) {
            int middle = getMiddle(input);
            set.add(middle);
            if (lastSize == set.size()) {
                break;
            }
            input = middle * middle;
            lastSize = set.size();
        }
        System.out.println(lastSize);
    }

    public static int getMiddle(int n) {
        int hund = 0;
        int tenDigit = 0;

        int divide = 1000;
        int acc = 0;
        while (divide >= 10) {
            int v = n / divide;
            n %= divide;
            if (divide == 100) {
                acc = v * 10;
            } else if (divide == 10) {
                acc += v;
            }
            divide /= 10;
        }
        return acc;
    }
}