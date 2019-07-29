import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Bus>[] list = new ArrayList[n + 1];
        int[] dist = new int[n + 1];
        int[] path = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
            path[i] = i;
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list[a].add(new Bus(b, c));
        }

        int start = sc.nextInt();
        int dest = sc.nextInt();
        int copyStart = start;
        boolean[] visit = new boolean[n + 1];

        dist[start] = 0;

        for (int i = 1; i < n; i++) {

            visit[start] = true;
            for (Bus cur : list[start]) {
                if (dist[start] + cur.c < dist[cur.e]) {
                    dist[cur.e] = dist[start] + cur.c;
                    path[cur.e] = start;
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

        System.out.println(dist[dest]);

        Stack<Integer> stack = new Stack<>();
        stack.add(dest);
        int curIdx = dest;
        while (curIdx != copyStart) {
            curIdx = path[curIdx];
            stack.add(curIdx);
        }

        System.out.println(stack.size());

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

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
