import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static ArrayList<Graph>[] list;
    static int E, V;
    final static int INF = 2000000001;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int e1 = Integer.parseInt(st.nextToken());
        int e2 = Integer.parseInt(st.nextToken());
        // E 200,000
        // V 100,000
        // ElogE

        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Graph>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[s].add(new Graph(e, c));
            list[e].add(new Graph(s, c));
        }

        int[] dist = dijkstra(start);
        int[] distE1 = dijkstra(e1);
        int[] distE2 = dijkstra(e2);

        int case1 = dist[e1] + distE1[e2];
        int case2 = dist[e2] + distE2[e1];
        System.out.println(Math.min(case1, case2));
    }

    public static int[] dijkstra(int st) {
        boolean[] isVisit = new boolean[V + 1];
        int[] dist = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            dist[i] = INF;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return dist[n1] - dist[n2];
            }
        });

        dist[st] = 0;
        pq.add(st);

        while (!pq.isEmpty()) {
            int idx = pq.poll();

            if (!isVisit[idx]) {
                isVisit[idx] = true;

                for (Graph g : list[idx]) {
                    if (dist[idx] + g.c < dist[g.x]) {
                        dist[g.x] = dist[idx] + g.c;
                        pq.add(g.x);
                    }
                }
            }
        }

        return dist;
    }
}

class Graph {
    int x;
    int c;

    public Graph(int x, int c) {
        this.x = x;
        this.c = c;
    }

}