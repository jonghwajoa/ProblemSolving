import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] parent;
    static int[] acc;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        parent = new int[N + 1];
        acc = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            acc[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            if (b < a) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            union(a, b);

            ans.append(acc[find(a)] + "\n");
        }
        System.out.println(ans.toString());
    }

    public static void union(int a, int b) {
        int ap = find(a);
        int bp = find(b);

        if (ap != bp) {
            parent[bp] = ap;
            acc[ap] += acc[bp];
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
