import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Bus>[] list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list[a].add(new Bus(b, c));
            list[b].add(new Bus(a, c));
        }

        int e1 = sc.nextInt();
        int e2 = sc.nextInt();

        int[] dist = diikstra(1, n, list);
        int[] dist1 = diikstra(e1, n, list);
        int[] dist2 = diikstra(e2, n, list);

        int ans1 = dist[e1] + dist1[e2] + dist2[n];
        int ans2 = dist[e2] + dist2[e1] + dist1[n];

        int min = Math.min(ans1, ans2);

        int ans = min < 0 ? -1 : min;

        System.out.println(ans);

    }

    public static int[] diikstra(int start, int n, ArrayList<Bus>[] list) {
        int[] dist = new int[n + 1];
        boolean[] visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;
        for (int i = 1; i < n; i++) {

            visit[start] = true;
            for (Bus cur : list[start]) {
                if (dist[start] + cur.c < dist[cur.e]) {
                    dist[cur.e] = dist[start] + cur.c;
                }
            }

            int nextIdx = start;
            int value = Integer.MAX_VALUE;

            for (int j = 1; j <= n; j++) {
                if (!visit[j] && dist[j] < value) {
                    value = dist[j];
                    nextIdx = j;
                }
            }

            start = nextIdx;
        }

        return dist;
    }
}

class Bus {
    int e;
    int c;

    public Bus(int e, int c) {
        this.e = e;
        this.c = c;
    }
}
