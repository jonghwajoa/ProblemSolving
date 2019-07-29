import java.util.*;

public class Main {
    static int ans = Integer.MIN_VALUE;
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        int start = 1;
        bfs(start);

        for (int i = 2; i <= n; i++) {
            if (dist[start] < dist[i]) {
                start = i;
            }
        }

        visit = new boolean[n + 1];
        dist = new int[n + 1];
        bfs(start);
        int ans = dist[1];

        for (int i = 2; i <= n; i++) {
            if (ans < dist[i]) {
                ans = dist[i];
            }
        }

        System.out.println(ans);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int curIdx = q.poll();
            for (Node cur : list[curIdx]) {
                int x = cur.x;
                int d = cur.d;

                if (!visit[x]) {
                    visit[x] = true;
                    q.add(x);
                    dist[x] = d + dist[curIdx];
                }
            }
        }
    }
}

class Node {
    int x;
    int d;

    public Node(int x, int d) {
        super();
        this.x = x;
        this.d = d;
    }
}
