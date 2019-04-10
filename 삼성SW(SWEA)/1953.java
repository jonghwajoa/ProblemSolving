
// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq&categoryId=AV5PpLlKAQ4DFAUq&categoryType=CODE

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    final static int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    final static int[] mx = { 0, 1, 0, -1 };
    final static int[] my = { -1, 0, 1, 0 };
    static int NY, NX;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc += 1) {
            NY = sc.nextInt();
            NX = sc.nextInt();
            int RY = sc.nextInt();
            int RX = sc.nextInt();
            int L = sc.nextInt();

            int[][] map = new int[NY][NX];
            boolean[][] visit = new boolean[NY][NX];
            for (int y = 0; y < NY; y += 1) {
                for (int x = 0; x < NX; x += 1) {
                    map[y][x] = sc.nextInt();
                }
            }

            int time = 1;
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(RX, RY));
            visit[RY][RX] = true;

            while (time < L) {
                int len = q.size();
                for (int i = 0; i < len; i++) {
                    Point cur = q.poll();
                    int type = map[cur.y][cur.x];
                    if (type == 0) {
                        continue;
                    }

                    move(cur.x, cur.y, type, q, visit, map);
                }

                time += 1;
            }

            int ans = 0;
            for (int y = 0; y < NY; y += 1) {
                for (int x = 0; x < NX; x += 1) {
                    if (visit[y][x]) {
                        ans += 1;
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void move(int x, int y, int d, Queue<Point> q, boolean[][] visit, int[][] map) {
        switch (d) {
        case 1:
            for (int i = 0; i < 4; i++) {
                int nextX = x + mx[i];
                int nextY = y + my[i];
                if (isSafe(nextX, nextY)) {
                    if (!visit[nextY][nextX]) {
                        if (moveable(i, map[nextY][nextX])) {
                            visit[nextY][nextX] = true;
                            q.add(new Point(nextX, nextY));
                        }
                    }
                }
            }
            break;
        case 2:
            for (int i = 0; i < 4; i += 2) {
                int nextX = x + mx[i];
                int nextY = y + my[i];
                if (isSafe(nextX, nextY)) {
                    if (!visit[nextY][nextX]) {
                        if (moveable(i, map[nextY][nextX])) {
                            visit[nextY][nextX] = true;
                            q.add(new Point(nextX, nextY));
                        }
                    }
                }
            }
            break;
        case 3:
            for (int i = 1; i < 4; i += 2) {
                int nextX = x + mx[i];
                int nextY = y + my[i];
                if (isSafe(nextX, nextY)) {
                    if (!visit[nextY][nextX]) {
                        if (moveable(i, map[nextY][nextX])) {
                            visit[nextY][nextX] = true;
                            q.add(new Point(nextX, nextY));
                        }
                    }
                }
            }
            break;
        case 4:
            for (int i = 0; i < 2; i += 1) {
                int nextX = x + mx[i];
                int nextY = y + my[i];
                if (isSafe(nextX, nextY)) {
                    if (!visit[nextY][nextX]) {
                        if (moveable(i, map[nextY][nextX])) {
                            visit[nextY][nextX] = true;
                            q.add(new Point(nextX, nextY));
                        }
                    }
                }
            }
            break;
        case 5:
            for (int i = 1; i < 3; i += 1) {
                int nextX = x + mx[i];
                int nextY = y + my[i];
                if (isSafe(nextX, nextY)) {
                    if (!visit[nextY][nextX]) {
                        if (moveable(i, map[nextY][nextX])) {
                            visit[nextY][nextX] = true;
                            q.add(new Point(nextX, nextY));
                        }
                    }
                }
            }
            break;
        case 6:
            for (int i = 2; i < 4; i += 1) {
                int nextX = x + mx[i];
                int nextY = y + my[i];
                if (isSafe(nextX, nextY)) {
                    if (!visit[nextY][nextX]) {
                        if (moveable(i, map[nextY][nextX])) {
                            visit[nextY][nextX] = true;
                            q.add(new Point(nextX, nextY));
                        }
                    }
                }
            }
            break;
        case 7:
            for (int i = 0; i < 4; i += 3) {
                int nextX = x + mx[i];
                int nextY = y + my[i];
                if (isSafe(nextX, nextY)) {
                    if (!visit[nextY][nextX]) {
                        if (moveable(i, map[nextY][nextX])) {
                            visit[nextY][nextX] = true;
                            q.add(new Point(nextX, nextY));
                        }
                    }
                }
            }
            break;
        }
    }

    public static boolean moveable(int curD, int nextPipe) {
        if (nextPipe == 0) {
            return false;
        }

        switch (nextPipe) {
        case 1:
            return true;
        case 2:
            if (curD == UP || curD == DOWN) {
                return true;
            }
            return false;
        case 3:
            if (curD == LEFT || curD == RIGHT) {
                return true;
            }
            return false;
        case 4:
            if (curD == DOWN || curD == LEFT) {
                return true;
            }
            return false;
        case 5:
            if (curD == UP || curD == LEFT) {
                return true;
            }
            return false;
        case 6:
            if (curD == RIGHT || curD == UP) {
                return true;
            }
            return false;
        case 7:
            if (curD == DOWN || curD == RIGHT) {
                return true;
            }
            return false;
        }

        return false;
    }

    public static boolean isSafe(int x, int y) {
        if (x < 0 || y < 0 || NX <= x || NY <= y) {
            return false;
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