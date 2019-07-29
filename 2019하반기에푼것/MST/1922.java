import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    static int[] parent;
    static int ans;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String[] line = null;
        ArrayList<Pair>[] list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                // TODO Auto-generated method stub
                return o1.dist - o2.dist;
            }
        });

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int d = Integer.parseInt(line[2]);

            list[a].add(new Pair(b, d));
            list[b].add(new Pair(a, d));
        }

        boolean[] isVisit = new boolean[N + 1];

        int start = 1;
        isVisit[start] = true;
        int ans = 0;

        for (Pair cur : list[start]) {
            pq.add(cur);
        }

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (!isVisit[cur.dest]) {
                isVisit[cur.dest] = true;
                ans += cur.dist;
                for (Pair p : list[cur.dest]) {
                    pq.add(p);
                }
            }
        }

        System.out.println(ans);
    }
}

class Pair {
    int dest;
    int dist;

    public Pair(int dest, int dist) {
        super();
        this.dest = dest;
        this.dist = dist;
    }

}
