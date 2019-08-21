import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] parent;
    static long[] cost;
    static int N, M;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder ansSB = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            parent = new int[N + 1];
            cost = new long[N + 1];

            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                char action = st.nextToken().charAt(0);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (action == '!') {
                    int c = Integer.parseInt(st.nextToken());
                    union(a, b, c);
                } else {
                    if (find(a) != find(b)) {
                        ansSB.append("UNKNOWN\n");
                    } else {
                        long diff = cost[a] - cost[b];
                        ansSB.append(diff + "\n");
                    }
                }
            }
        }
        System.out.print(ansSB);
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        int p = find(parent[x]);
        cost[x] += cost[parent[x]];
        parent[x] = p;
        return p;
    }

    // B가 A보다 C만큼 크다
    public static void union(int a, int b, int c) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return;
        }

        cost[pa] = cost[b] - cost[a] + c;
        parent[pa] = pb;
    }

}