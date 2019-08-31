import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int[] parent;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = atoi(br.readLine());

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N - 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = atoi(st.nextToken());
            int b = atoi(st.nextToken());
            // 작은게 부모
            if (b < a) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            union(a, b);
        }

        int standard = find(1);
        int ans = 0;
        for (int i = 2; i <= N; i++) {
            if (standard != find(i)) {
                ans = i;
                break;
            }
        }

        System.out.println(standard + " " + ans);
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int atoi(String string) {
        return Integer.parseInt(string);
    }
}