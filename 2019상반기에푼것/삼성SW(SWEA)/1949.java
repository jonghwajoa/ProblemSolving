import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    final static int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    final static int[] mx = { 0, 1, 0, -1 };
    final static int[] my = { -1, 0, 1, 0 };
    static int ans = 0;
    static int N, K, max;
    static int[][] map;
    static Queue<Point> maxQ;
    static boolean[][] visit;

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        final int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc += 1) {
            N = sc.nextInt();
            K = sc.nextInt();
            map = new int[N][N];
            visit = new boolean[N][N];
            maxQ = new LinkedList<>();
            max = 0;
            ans = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    if (max < map[i][j]) {
                        max = map[i][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (max == map[i][j]) {
                        maxQ.add(new Point(j, i));
                    }
                }
            }

            while (!maxQ.isEmpty()) {
                Point cur = maxQ.poll();
                visit[cur.y][cur.x] = true;
                dfs(cur.x, cur.y, max, true, 1);
                visit[cur.y][cur.x] = false;

            }

            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void dfs(int x, int y, int h, boolean deep, int depth) {

        boolean possible = false;
        for (int i = 0; i < 4; i++) {
            int nextX = x + mx[i];
            int nextY = y + my[i];

            if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
                if (!visit[nextY][nextX]) {
                    if (map[nextY][nextX] < h) {
                        visit[nextY][nextX] = true;
                        dfs(nextX, nextY, map[nextY][nextX], deep, depth + 1);
                        visit[nextY][nextX] = false;
                        possible = true;
                    } else {
                        if (deep) {
                            int diff = map[nextY][nextX] - h + 1;
                            if (diff <= K) {
                                for (int j = diff; j <= K; j++) {
                                    visit[nextY][nextX] = true;
                                    dfs(nextX, nextY, map[nextY][nextX] - j, false, depth + 1);
                                    visit[nextY][nextX] = false;
                                }
                                possible = true;
                            }
                        }
                    }
                }
            }
        }

        if (!possible) {
            if (ans < depth) {
                ans = depth;
            }
        }
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
