import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int[] parent, level;
    static HashMap<String, Integer> hash;
    static StringBuilder sb;

    public static void main(String[] argv) {
        final Scanner sc = new Scanner(System.in);

        int repeat = sc.nextInt();
        while (repeat-- > 0) {
            final int N = sc.nextInt();
            parent = new int[N * 2];
            level = new int[N * 2];
            sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            sc.nextLine();
            hash = new HashMap<String, Integer>();
            int index = 0;
            for (int i = 0; i < N; i++) {
                String[] input = sc.nextLine().split(" ");
                if (!hash.containsKey(input[0])) {
                    hash.put(input[0], index++);
                }

                if (!hash.containsKey(input[1])) {
                    hash.put(input[1], index++);
                }

                int idx1 = hash.get(input[0]);
                int idx2 = hash.get(input[1]);

                union(idx1, idx2);
            }
            System.out.println(sb.toString());
        }
    }

    public static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        if (x != y) {
            parent[y] = x;
            level[x] = level[y] + 2;
        }
        sb.append(level[x] + "\n");
    }

    public static int find(int idx) {
        if (parent[idx] == idx) {
            return idx;
        }
        return parent[idx] = find(parent[idx]);
    }
}