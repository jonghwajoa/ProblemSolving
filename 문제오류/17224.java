import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    final static int[] mx = { 0, 1, 0, -1 };
    final static int[] my = { -1, 0, 1, 0 };
    static char[][] map;
    static int cnt, ans;
    final static int MAX_ITEM = 5;
    static Pair[] item;
    static Pair curP, END;
    static boolean[] isVisit;
    static int[] order;
    static int Y, X;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        X = sc.nextInt();
        Y = sc.nextInt();
        sc.nextLine();
        map = new char[Y][X];
        cnt = 0;
        ans = Integer.MAX_VALUE;

        item = new Pair[MAX_ITEM];
        isVisit = new boolean[MAX_ITEM];
        order = new int[MAX_ITEM];

        for (int i = 0; i < Y; i++) {
            map[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < X; j++) {
                if (map[i][j] == 'S') {
                    curP = new Pair(j, i, 0);
                } else if (map[i][j] == 'X') {
                    item[cnt] = new Pair(j, i, 0);
                    cnt += 1;
                } else if (map[i][j] == 'E') {
                    END = new Pair(j, i, 0);
                }
            }
        }

        dfs(0);
        System.out.println(ans);
    }

    public static void dfs(int index) {
        if (cnt <= index) {
            Pair copyStart = new Pair(curP.x, curP.y, 0);
            simulation();
            curP = copyStart;
            return;
        }

        for (int i = 0; i < cnt; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                order[index] = i;
                dfs(index + 1);
                isVisit[i] = false;
            }
        }
    }

    public static void simulation() {
        int sum = 0;

        for (int i = 0; i < cnt; i++) {
            Pair target = item[order[i]];

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(curP.x, curP.y, 0));
            boolean[][] visit = new boolean[Y][X];
            visit[curP.y][curP.x] = true;

            while (!q.isEmpty()) {
                Pair cur = q.poll();

                if (cur.x == target.x && cur.y == target.y) {
                    sum += cur.c;
                    curP = target;
                    break;
                }

                for (int z = 0; z < 4; z++) {
                    int nextX = cur.x + mx[z];
                    int nextY = cur.y + my[z];

                    if (0 <= nextX && nextX < X && 0 <= nextY && nextY < Y) {
                        if (!visit[nextY][nextX] && map[nextY][nextX] != '#') {
                            visit[nextY][nextX] = true;
                            q.add(new Pair(nextX, nextY, cur.c + 1));
                        }
                    }
                }
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(curP.x, curP.y, 0));
        boolean[][] visit = new boolean[Y][X];
        visit[curP.y][curP.x] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            if (cur.x == END.x && cur.y == END.y) {
                sum += cur.c;
                break;
            }

            for (int z = 0; z < 4; z++) {
                int nextX = cur.x + mx[z];
                int nextY = cur.y + my[z];

                if (0 <= nextX && nextX < X && 0 <= nextY && nextY < Y) {
                    if (!visit[nextY][nextX] && map[nextY][nextX] != '#') {
                        visit[nextY][nextX] = true;
                        q.add(new Pair(nextX, nextY, cur.c + 1));
                    }
                }
            }
        }

        if (sum < ans) {
            ans = sum;
        }
    }

}

class Pair {
    int x;
    int y;
    int c;

    public Pair(int x, int y, int c) {
        super();
        this.x = x;
        this.y = y;
        this.c = c;
    }
}