import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    final static int STOP = 0, UP = 1, RIGHT = 2, DOWN = 3, LEFT = 4;
    final static int[] mx = { 0, 0, 1, 0, -1 };
    final static int[] my = { 0, -1, 0, 1, 0 };

    static int[][] map;
    static int[][] sub;
    static int[][] share;
    static int ans = 0;
    static int topX = 0, topY = 0, bottomX = 9, bottomY = 9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc++) {

            int M = sc.nextInt();
            int A = sc.nextInt();
            topX = 0;
            topY = 0;
            bottomX = 9;
            bottomY = 9;
            ans = 0;
            map = new int[10][10];
            sub = new int[10][10];
            share = new int[10][10];

            LinkedList<Integer> topQ = new LinkedList<>();
            LinkedList<Integer> bottomQ = new LinkedList<>();

            for (int i = 0; i < M; i++) {
                topQ.add(sc.nextInt());
            }

            for (int i = 0; i < M; i++) {
                bottomQ.add(sc.nextInt());
            }

            for (int i = 0; i < A; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int c = sc.nextInt();
                int p = sc.nextInt();
                drawMap(x - 1, y - 1, c, p, i + 1);
            }

            solve(topQ, bottomQ);
            System.out.println("#" + tc + " " + ans);

        }
    }

    public static void solve(LinkedList<Integer> topQ, LinkedList<Integer> bottomQ) {
        int len = topQ.size();
        if (share[topY][topX] > 0 && share[topY][topX] == share[bottomY][bottomX]) {
            ans = map[topY][topX] + Math.max(sub[topY][topX], sub[bottomY][bottomX]);
        } else {
            ans = ans + map[topY][topX] + map[bottomY][bottomX];
        }

        for (int i = 0; i < len; i++) {
            int topD = topQ.poll();
            int bottomD = bottomQ.poll();

            topX += mx[topD];
            topY += my[topD];
            bottomX += mx[bottomD];
            bottomY += my[bottomD];

            if (share[topY][topX] > 0 && share[topY][topX] == share[bottomY][bottomX]) {
                ans = ans + map[topY][topX] + Math.max(sub[topY][topX], sub[bottomY][bottomX]);
            } else {
                ans = ans + map[topY][topX] + map[bottomY][bottomX];
            }

        }

    }

    public static void drawMap(int x, int y, int c, int p, int id) {
        boolean[][] visit = new boolean[10][10];
        Queue<Target> q = new LinkedList<>();
        q.add(new Target(x, y));
        visit[y][x] = true;
        if (map[y][x] < p) {
            sub[y][x] = map[y][x];
            map[y][x] = p;
            share[y][x] = id;
        } else {
            if (sub[y][x] < p) {
                sub[y][x] = p;
            }
        }

        while (!q.isEmpty()) {
            Target cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for (int i = 1; i <= 4; i++) {
                int nextX = curX + mx[i];
                int nextY = curY + my[i];

                if (0 <= nextX && nextX < 10 && 0 <= nextY && nextY < 10) {
                    int abs = Math.abs(x - nextX) + Math.abs(y - nextY);

                    if (abs <= c && !visit[nextY][nextX]) {
                        visit[nextY][nextX] = true;
                        q.add(new Target(nextX, nextY));

                        if (map[nextY][nextX] < p) {
                            sub[nextY][nextX] = map[nextY][nextX];
                            map[nextY][nextX] = p;
                            share[nextY][nextX] = id;
                        } else {
                            if (sub[nextY][nextX] < p) {
                                sub[nextY][nextX] = p;
                            }
                        }
                    }
                }
            }
        }
    }
}

class Target {
    int x;
    int y;

    public Target(int x, int y) {
        this.x = x;
        this.y = y;
    }
}