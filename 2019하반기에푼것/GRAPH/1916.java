import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int INF = Integer.MAX_VALUE;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Bus>[] list = new ArrayList[N + 1];
        int[] cost = new int[N + 1];
        boolean[] isVisit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            cost[i] = INF;
            list[i] = new ArrayList<Bus>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[s].add(new Bus(e, c));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return cost[n1] - cost[n2];
            }
        });

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        cost[start] = 0;
        pq.add(start);

        while (!pq.isEmpty()) {
            int idx = pq.poll();

            if (!isVisit[idx]) {
                isVisit[idx] = true;

                for (Bus bus : list[idx]) {
                    if (cost[idx] != INF && cost[idx] + bus.cost < cost[bus.ed]) {
                        cost[bus.ed] = cost[idx] + bus.cost;
                        pq.add(bus.ed);
                    }
                }
            }
        }
        System.out.println(cost[end]);
    }
}

class Bus {
    int ed;
    int cost;

    public Bus(int ed, int cost) {
        this.ed = ed;
        this.cost = cost;
    }
}