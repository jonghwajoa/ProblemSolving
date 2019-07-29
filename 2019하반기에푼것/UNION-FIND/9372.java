import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int[] parent;
    static int ans;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int REPEAT = Integer.parseInt(br.readLine());

        while (REPEAT-- > 0) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            parent = new int[N + 1];
            ans = 0;

            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                line = br.readLine().split(" ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);

                if (a > b) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }

                union(a, b);
            }

            System.out.println(ans);
        }
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            ans += 1;
            parent[b] = a;
        }
    }
}
