import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        cost[start] = 0;

        for (int i = 1; i < N; i++) {
            isVisit[start] = true;
            for (Bus bus : list[start]) {
                if (bus.cost + cost[start] < cost[bus.ed]) {
                    cost[bus.ed] = bus.cost + cost[start];
                }
            }

            int min = INF;
            for (int j = 1; j <= N; j++) {
                if (!isVisit[j] && cost[j] < min) {
                    min = cost[j];
                    start = j;
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