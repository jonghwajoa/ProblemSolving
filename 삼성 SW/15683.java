import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int ans = Integer.MAX_VALUE;
    static int nY, nX;
    final static int CCTV = 1;
    static int[] mx = { 0, 1, 0, -1 };
    static int[] my = { -1, 0, 1, 0 };

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        nY = sc.nextInt();
        nX = sc.nextInt();

        final int[][] map = new int[nY][nX];
        final LinkedList<Point> list = new LinkedList<>();

        for (int i = 0; i < nY; i++) {
            for (int j = 0; j < nX; j++) {
                final int tmp = sc.nextInt();
                map[i][j] = tmp;

                if (0 < tmp && tmp < 6) {
                    list.addLast(new Point(j, i, tmp));
                }
            }
        }

        dfs(list, map, 0);
        System.out.println(ans);
    }

    public static void dfs(LinkedList<Point> list, int[][] origin, int count) {
        if (list.size() == count) {
            checkNotCCTV(origin);
            return;
        }
        Point cur = list.get(count);
        int direction = cur.d;
        int x = cur.x;
        int y = cur.y;
        switch (direction) {
        case 1:
            for (int i = 0; i < 4; i++) {
                int[][] copy = makeCopyMap(origin);
                wayMove(i, x, y, copy);
                dfs(list, copy, count + 1);
            }
            break;
        case 2:
            for (int i = 0; i < 2; i++) {
                int[][] copy = makeCopyMap(origin);
                twoWaySecondMean(copy, x, y, i);
                dfs(list, copy, count + 1);
            }
            break;
        case 3:
            for (int i = 0; i < 4; i++) {
                int[][] copy = makeCopyMap(origin);
                twoWayFirstMean(copy, x, y, i);
                dfs(list, copy, count + 1);
            }
            break;
        case 4:
            for (int i = 0; i < 4; i++) {
                int[][] copy = makeCopyMap(origin);
                threeWay(copy, x, y, i);
                dfs(list, copy, count + 1);
            }
            break;
        case 5:
            int[][] copy = makeCopyMap(origin);
            fourWay(copy, x, y);
            dfs(list, copy, count + 1);
            break;
        }
    }

    public static boolean safeCheck(int x, int y) {
        if (x < 0 || nX <= x || y < 0 || nY <= y) {
            return false;
        }
        return true;
    }

    public static void wayMove(int d, int x, int y, int[][] map) {
        while (true) {
            x += mx[d];
            y += my[d];
            if (!safeCheck(x, y) || map[y][x] == 6) {
                break;
            }
            map[y][x] = CCTV;
        }
    }

    public static void twoWaySecondMean(int[][] map, int x, int y, int d) {
        switch (d) {
        case 0:
            wayMove(0, x, y, map);
            wayMove(2, x, y, map);
            break;
        case 1:
            wayMove(1, x, y, map);
            wayMove(3, x, y, map);
            break;
        }
    }

    public static void twoWayFirstMean(int[][] map, int x, int y, int d) {
        switch (d) {
        case 0:
            wayMove(0, x, y, map);
            wayMove(1, x, y, map);
            break;
        case 1:
            wayMove(1, x, y, map);
            wayMove(2, x, y, map);
            break;
        case 2:
            wayMove(2, x, y, map);
            wayMove(3, x, y, map);
            break;
        case 3:
            wayMove(3, x, y, map);
            wayMove(0, x, y, map);
            break;
        }
    }

    // up right down left
    public static void threeWay(int[][] map, int x, int y, int d) {
        switch (d) {
        case 0:
            wayMove(0, x, y, map);
            wayMove(1, x, y, map);
            wayMove(2, x, y, map);
            break;
        case 1:
            wayMove(1, x, y, map);
            wayMove(2, x, y, map);
            wayMove(3, x, y, map);
            break;
        case 2:
            wayMove(2, x, y, map);
            wayMove(3, x, y, map);
            wayMove(0, x, y, map);
            break;
        case 3:
            wayMove(3, x, y, map);
            wayMove(0, x, y, map);
            wayMove(1, x, y, map);
            break;
        }
    }

    public static void fourWay(int[][] map, int x, int y) {
        for (int i = 0; i < 4; i++) {
            wayMove(i, x, y, map);
        }
    }

    public static int[][] makeCopyMap(int[][] origin) {
        int[][] copy = new int[nY][nX];
        for (int i = 0; i < nY; i++) {
            for (int j = 0; j < nX; j++) {
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }

    public static void checkNotCCTV(int[][] map) {
        int count = 0;
        for (int i = 0; i < nY; i++) {
            for (int j = 0; j < nX; j++) {
                if (map[i][j] == 0) {
                    count += 1;
                }
            }
        }

        if (count < ans) {
            ans = count;
        }
    }

}

class Point {
    int x;
    int y;
    int d;

    public Point(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

}