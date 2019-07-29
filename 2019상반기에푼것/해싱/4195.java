import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int[] parent, ans;
    static HashMap<String, Integer> hash;
    static StringBuilder sb;

    public static void main(String[] argv) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int repeat = Integer.parseInt(br.readLine());

        while (repeat-- > 0) {
            final int N = Integer.parseInt(br.readLine());
            final int LEN = N * 2;
            parent = new int[LEN];
            ans = new int[LEN];
            for (int i = 0; i < LEN; i++) {
                parent[i] = i;
                ans[i] = 1;
            }

            hash = new HashMap<String, Integer>();
            int index = 0;
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
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
        }
        System.out.println(sb.toString());
    }

    public static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x > y) {
            int tmp = y;
            y = x;
            x = tmp;
        }

        if (x != y) {
            parent[y] = x;
            ans[x] += ans[y];
        }
        sb.append(ans[x] + "\n");
    }

    public static int find(int idx) {
        if (parent[idx] == idx) {
            return idx;
        }
        return parent[idx] = find(parent[idx]);
    }
}