import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    final static int[][] map = new int[4003][4003];
    final static int STANDARD = 2000;
    final static int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    final static int[] mx = { 0, 0, -1, 1 };
    final static int[] my = { 1, -1, 0, 0 };

    static int ans;

    public static void main(String args[]) throws Exception {

        final Scanner sc = new Scanner(System.in);
        final int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            ans = 0;
            LinkedList<Atom> list = new LinkedList<>();
            LinkedList<Point> initPoint = new LinkedList<>();
            // x , y , d , k
            for (int i = 0; i < N; i++) {
                int x = (sc.nextInt() * 2) + STANDARD;
                int y = (sc.nextInt() * 2) + STANDARD;
                int d = sc.nextInt();
                int k = sc.nextInt();
                list.add(new Atom(x, y, d, k));
                map[y][x] += 1;
            }

            // 빈공간인경우
            // 누군가 있는경우
            int count = 0;
            while (!list.isEmpty()) {
                int len = list.size();
                for (int j = 0; j < len; j++) {
                    Atom cur = list.pollFirst();
                    map[cur.y][cur.x] -= 1;
                    int nextX = cur.x + mx[cur.d];
                    int nextY = cur.y + my[cur.d];

                    if (nextY < 0 || 4002 <= nextY || nextX < 0 || 4002 <= nextX) {
                        continue;
                    }

                    list.add(new Atom(nextX, nextY, cur.d, cur.k));
                    map[nextY][nextX] += 1;
                }

                len = list.size();

                for (int i = 0; i < len; i++) {
                    Atom cur = list.pollFirst();
                    if (map[cur.y][cur.x] >= 2) {
                        ans += cur.k;
                        initPoint.add(new Point(cur.x, cur.y));
                    } else {
                        list.add(cur);
                    }
                }
                len = initPoint.size();
                for (int i = 0; i < len; i++) {
                    Point cur = initPoint.removeFirst();
                    map[cur.y][cur.x] = 0;
                }
            }
            System.out.println("#" + test_case + " " + ans);
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

class Atom {
    int x;
    int y;
    int d;
    int k;

    public Atom(int x, int y, int d, int k) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.k = k;
    }
}