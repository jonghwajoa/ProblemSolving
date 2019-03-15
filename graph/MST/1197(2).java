import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Network>[] list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int t = sc.nextInt();
            list[a].add(new Network(a, b, t));
            list[b].add(new Network(b, a, t));
        }

        boolean[] visit = new boolean[n + 1];
        PriorityQueue<Network> q = new PriorityQueue<>(new Compare());
        visit[1] = true;

        for (Network cur : list[1]) {
            q.add(cur);
        }

        int ans = 0;

        while (!q.isEmpty()) {
            Network cur = q.poll();

            if (!visit[cur.end]) {
                visit[cur.end] = true;
                ans += cur.cost;
                q.add(cur);

                for (Network e : list[cur.end]) {
                    q.add(e);
                }
            }
        }

        System.out.println(ans);
    }
}

class Compare implements Comparator<Network> {
    @Override
    public int compare(Network o1, Network o2) {
        return o1.cost - o2.cost;
    }
}

class Network {
    int start;
    int end;
    int cost;

    public Network(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

}