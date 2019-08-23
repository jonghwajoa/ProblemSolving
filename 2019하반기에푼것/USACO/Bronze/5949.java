import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.bind.helpers.DefaultValidationEventHandler;

class Main {
    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        StringBuilder ansSB = new StringBuilder();

        int idx = 0;
        for (int i = chars.length - 1; 0 <= i; i--) {
            if (idx == 3) {
                idx = 0;
                ansSB.append(",");
            }
            ansSB.append(chars[i]);
            idx += 1;
        }

        System.out.println(ansSB.reverse());

    }
}