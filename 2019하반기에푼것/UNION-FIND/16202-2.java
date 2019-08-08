
// union-find로 개선
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    static Graph[] graphArr;
    static int[] parent;
    static int ans;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        graphArr = new Graph[E];

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int st = Integer.parseInt(input[0]);
            int ed = Integer.parseInt(input[1]);
            graphArr[i] = new Graph(st, ed, i + 1);
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < K; i++) {
            if (flag) {
                if (getMST(i, V, E)) {
                    sb.append(ans + " ");
                } else {
                    flag = false;
                    sb.append("0 ");
                }
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean getMST(int K, int V, int E) {
        parent = new int[V + 1];
        ans = 0;

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = K; i < E; i++) {
            Graph graph = graphArr[i];
            int st = graph.st;
            int ed = graph.ed;

            if (ed < st) {
                int tmp = st;
                st = ed;
                ed = tmp;
            }
            union(st, ed, graph.cost);
        }

        return isAllVisit(V);
    }

    public static boolean isAllVisit(int V) {
        int standard = find(1);
        for (int i = 1; i <= V; i++) {
            if (find(i) != standard) {
                return false;
            }
        }
        return true;
    }

    public static void union(int a, int b, int c) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
            ans += c;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

}

class Graph {
    int st;
    int ed;
    int cost;

    public Graph(int st, int ed, int cost) {
        this.st = st;
        this.ed = ed;
        this.cost = cost;
    }
}
