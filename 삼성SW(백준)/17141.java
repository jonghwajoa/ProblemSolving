import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    final static int WALL = 1, VIRUS = 2, EMPTY = 0;
    final static int[] mx = { 0, 1, 0, -1 };
    final static int[] my = { -1, 0, 1, 0 };
    static int[][] map;
    static int M, N;
    static LinkedList<Point> virusList;
    static int ans = Integer.MAX_VALUE;
    static boolean[] virusUse;

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        M = sc.nextInt();

        virusList = new LinkedList<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                map[y][x] = sc.nextInt();
                if (map[y][x] == 2) {
                    virusList.add(new Point(x, y));
                }
            }
        }
        virusUse = new boolean[virusList.size()];
        dfs(0, 0);

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
            System.out.println(ans);
        } else {
            System.out.println(ans - 1);
        }
    }

    public static void dfs(int index, int acc) {
        if (acc >= M) {
            if (possibleCheck()) {
                move();
            }
            return;
        }

        if (index >= virusList.size()) {
            return;
        }

        virusUse[index] = true;
        dfs(index + 1, acc + 1);
        virusUse[index] = false;
        dfs(index + 1, acc);
    }

    public static void move() {

        Queue<Point> q = new LinkedList<>();
        boolean visit[][] = new boolean[N][N];
        int len = virusList.size();
        for (int i = 0; i < len; i++) {
            if (virusUse[i]) {
                Point cur = virusList.get(i);
                q.add(new Point(cur.x, cur.y));
            }
        }

        int time = 0;
        while (!q.isEmpty()) {
            len = q.size();
            for (int i = 0; i < len; i++) {
                Point cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nextX = cur.x + mx[j];
                    int nextY = cur.y + my[j];

                    if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
                        if (!visit[nextY][nextX]) {
                            if (map[nextY][nextX] != WALL) {
                                q.add(new Point(nextX, nextY));
                            }
                            visit[nextY][nextX] = true;
                        }
                    }
                }
            }

            time += 1;
        }

        if (time < ans) {
            ans = time;
        }
    }

    public static boolean possibleCheck() {
        Point[] list = new Point[M];
        int index = 0;
        int len = virusList.size();
        for (int i = 0; i < len; i++) {
            if (virusUse[i]) {
                list[index] = virusList.get(i);
                index += 1;
            }
        }

        boolean visit[][] = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            Point cur = list[i];

            if (visit[cur.y][cur.x]) {
                continue;
            }

            Queue<Point> q = new LinkedList<>();
            visit[cur.y][cur.x] = true;
            q.add(cur);
            while (!q.isEmpty()) {
                Point p = q.poll();
                int curX = p.x;
                int curY = p.y;
                for (int j = 0; j < 4; j++) {
                    int nextX = curX + mx[j];
                    int nextY = curY + my[j];

                    if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
                        if (!visit[nextY][nextX]) {
                            if (map[nextY][nextX] != WALL) {
                                q.add(new Point(nextX, nextY));
                            }
                            visit[nextY][nextX] = true;
                        }
                    }
                }
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visit[y][x] && map[y][x] != WALL) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}