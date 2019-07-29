import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    static int[] parent;
    static int ans;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ans = 0;
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        String[] line = null;
        PriorityQueue<Computer> pq = new PriorityQueue<>(new Comparator<Computer>() {
            @Override
            public int compare(Computer o1, Computer o2) {
                return o1.d - o2.d;
            }
        });

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int d = Integer.parseInt(line[2]);
            pq.add(new Computer(a, b, d));

        }

        while (!pq.isEmpty()) {
            Computer c = pq.poll();
            union(c.st, c.ed, c.d);
        }
        System.out.println(ans);
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b, int d) {
        a = find(a);
        b = find(b);
        if (a != b) {
            ans += d;
            parent[b] = a;
        }
    }
}

class Computer {
    int st;
    int ed;
    int d;

    public Computer(int st, int ed, int d) {
        super();
        this.st = st;
        this.ed = ed;
        this.d = d;
    }

}
