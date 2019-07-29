import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class Solution {
    static int[] V = { 10, 11, 12, 13, 14, 15 };
    static Set<Integer> set;

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        final int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int v = N / 4;
            sc.nextLine();
            String line = sc.nextLine();
            set = new HashSet<>();

            convert(line, v);
            for (int i = 1; i <= v - 1; i++) {
                String str = line.substring(N - i) + line.substring(0, N - i);
                convert(str, v);
            }

            int[] array = new int[N];

            Iterator<Integer> itor = set.iterator();
            int index = 0;
            while (itor.hasNext()) {
                array[index++] = itor.next();
            }

            Arrays.sort(array);

            int len = N / 2;
            for (int i = 0; i < len; i++) {
                int tmp = array[i];
                array[i] = array[N - 1 - i];
                array[N - 1 - i] = tmp;
            }
            System.out.println("#" + tc + " " + array[K - 1]);
        }
    }

    public static void convert(String str, int v) {
        for (int i = 0; i < 4; i++) {
            String word = str.substring(i * v, (i + 1) * v);
            int parseN = Integer.parseInt(word, 16);
            set.add(parseN);
        }
    }

}
