// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRQm6qfL0DFAUo
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Solution {
    final static int UP = 0, RIGTH = 1, DOWN = 2, LEFT = 3;
    final static int[] mx = { 0, 1, 0, -1 };
    final static int[] my = { -1, 0, 1, 0 };
    static int ans, NX, NY, N;

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        final int repeat = sc.nextInt();

        for (int tc = 1; tc <= repeat; tc++) {
            ans = 0;
            N = sc.nextInt();
            NX = sc.nextInt();
            NY = sc.nextInt();
            int[][] map = new int[NY][NX];

            for (int i = 0; i < NY; i++) {
                for (int j = 0; j < NX; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int getWallNo = findWallCount(map);
            dfs(0, map, 0);
            ans = getWallNo - ans;

            System.out.println("#" + tc + " " + ans);
        }

    }

    public static int findWallCount(int[][] map) {
        int count = 0;
        for (int i = 0; i < NY; i++) {
            for (int j = 0; j < NX; j++) {
                if (map[i][j] > 0) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void dfs(int step, int[][] origin, int breakCount) {
        if (step >= N) {
            if (ans < breakCount) {
                ans = breakCount;
            }
            return;
        }

        // i행을 뿌시거나
        for (int i = 0; i < NX; i++) {
            if (origin[NY - 1][i] != 0) {
                int[][] copy = makeCopy(origin);
                int newBreakCount = breakWall(i, copy);
                dfs(step + 1, copy, breakCount + newBreakCount);
            } else {
                if (i == NX - 1) {
                    if (ans < breakCount) {
                        ans = breakCount;
                    }
                    return;
                }
            }
        }
    }

    public static int breakWall(int index, int[][] map) {
        int y = 0;
        int x = index;
        Queue<Point> q = new LinkedList<>();

        while (map[y][x] == 0) {
            y += 1;
        }

        q.add(new Point(x, y, map[y][x]));
        map[y][x] = 0;
        int count = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int range = cur.r;

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x;
                int nextY = cur.y;

                for (int j = 0; j < range - 1; j++) {
                    nextX += mx[i];
                    nextY += my[i];

                    if (0 <= nextX && nextX < NX && 0 <= nextY && nextY < NY) {
                        if (map[nextY][nextX] != 0) {
                            q.add(new Point(nextX, nextY, map[nextY][nextX]));
                            map[nextY][nextX] = 0;
                            count += 1;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < NX; i++) {
            for (int j = 0; j < NY; j++) {
                if (map[j][i] != 0) {
                    stack.push(map[j][i]);
                    map[j][i] = 0;
                }
            }

            int top = NY - 1;
            while (!stack.isEmpty()) {
                map[top][i] = stack.pop();
                top -= 1;
            }
        }
        return count;
    }

    public static int[][] makeCopy(int[][] origin) {
        int[][] copy = new int[NY][NX];
        for (int i = 0; i < NY; i++) {
            for (int j = 0; j < NX; j++) {
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }
}

class Point {
    int x;
    int y;
    int r;

    public Point(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}