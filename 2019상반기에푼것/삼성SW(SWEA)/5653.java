
// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRJ8EKe48DFAUo&categoryId=AWXRJ8EKe48DFAUo&categoryType=CODE

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    final static int UP = 0, RIGTH = 1, DOWN = 2, LEFT = 3;
    final static int[] mx = { 0, 1, 0, -1 };
    final static int[] my = { -1, 0, 1, 0 };
    final static int stand = 500, DIE = Integer.MAX_VALUE;
    static int ans, NX, NY, N;
    static boolean[][] map;

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        final int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc++) {
            NY = sc.nextInt();
            NX = sc.nextInt();
            N = sc.nextInt();
            map = new boolean[1001][1001];

            PriorityQueue<Point> ready = new PriorityQueue<>(new readyPriority()); // 비활성상태
            PriorityQueue<Point> active = new PriorityQueue<>(new activePriority()); // 활성상태
            LinkedList<Point> wait = new LinkedList<>(); // 1시간 대기상태...
            for (int j = stand; j < NY + stand; j++) {
                for (int i = stand; i < NX + stand; i++) {
                    int tmp = sc.nextInt();
                    if (tmp != 0) {
                        ready.add(new Point(i, j, tmp, tmp));
                        map[j][i] = true;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                int len = active.size();
                for (int j = 0; j < len; j++) {
                    Point cur = active.remove();
                    for (int z = 0; z < 4; z++) {
                        int nextX = cur.x + mx[z];
                        int nextY = cur.y + my[z];

                        if (!map[nextY][nextX]) {
                            map[nextY][nextX] = true;
                            ready.add(new Point(nextX, nextY, cur.k, cur.k + 1));
                        }
                    }
                    cur.s = cur.k;
                    wait.add(cur);
                }

                len = wait.size();
                for (int j = 0; j < len; j++) {
                    Point cur = wait.poll();
                    if (cur.s != 1) {
                        cur.s -= 1;
                        wait.addLast(cur);
                    }
                }

                len = ready.size();
                Queue<Point> tmp = new LinkedList<>();
                for (int j = 0; j < len; j++) {
                    Point cur = ready.remove();
                    if (cur.s == 1) {
                        active.add(cur);
                    } else {
                        cur.s -= 1;
                        tmp.add(cur);
                    }
                }

                len = tmp.size();
                for (int j = 0; j < len; j++) {
                    ready.add(tmp.remove());
                }

            }

            int ans = wait.size() + active.size() + ready.size();
            System.out.println("#" + tc + " " + ans);
        }
    }
}

// K가 높고 s가 낮을수록
class readyPriority implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        if (o1.s == o2.s) {
            return o2.k - o1.k;
        }
        return o1.s - o2.s;
    }
}

class activePriority implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        return o2.k - o1.k;
    }
}

class Point {
    int x;
    int y;
    int k;
    int s;

    public Point(int x, int y, int k, int s) {
        super();
        this.x = x;
        this.y = y;
        this.k = k;
        this.s = s;
    }
}
