import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int NY, NX, ND;
    static int[][] map;
    static boolean[] visit;
    static int COUNT, ANS;
    final static int[] mx = { 0, -1, 1 };
    final static int[] my = { -1, 0, 0 };

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        NY = sc.nextInt();
        NX = sc.nextInt();
        ND = sc.nextInt();
        map = new int[NY][NX];
        visit = new boolean[NX];
        COUNT = 0;
        ANS = 0;
        for (int y = 0; y < NY; y++) {
            for (int x = 0; x < NX; x++) {
                map[y][x] = sc.nextInt();
                if (map[y][x] == 1) {
                    COUNT += 1;
                }
            }
        }
        dfs(0, 0);
        System.out.println(ANS);
    }

    public static void dfs(int index, int acc) {
        if (acc >= 3) {
            cal();
            return;
        }

        if (index >= NX) {
            return;
        }

        dfs(index + 1, acc); // 궁수를 배치하지 않는 경우
        visit[index] = true;
        dfs(index + 1, acc + 1); // 궁수를 배치하는경우
        visit[index] = false;
    }

    public static void cal() {
        int[] position = new int[3];
        int[][] copy = makeCopy(map);
        int index = 0;
        int killCount = 0;
        int enemyCount = COUNT;
        for (int i = 0; i < NX; i++) {
            if (visit[i]) {
                position[index] = i;
                index++;
            }
        }

        while (0 < enemyCount) {
            // 적 좌표 구하기
            Enemy[] tmp = new Enemy[3];
            for (int i = 0; i < 3; i++) {
                int curX = position[i];
                int curY = NY;
                Enemy enemy = findEnemy(curX, curY, copy);
                tmp[i] = enemy;
            }

            // 적 죽이기
            for (int i = 0; i < 3; i++) {
                if (tmp[i] == null) {
                    continue;
                }
                Enemy cur = tmp[i];
                if (copy[cur.y][cur.x] == 1) {
                    killCount += 1;
                    enemyCount -= 1;
                    copy[cur.y][cur.x] = 0;
                }
            }

            // 적이 한칸 앞으로 전진
            for (int x = 0; x < NX; x++) {
                if (copy[NY - 1][x] == 1) {
                    enemyCount -= 1;
                    copy[NY - 1][x] = 0;
                }
            }
            for (int y = NY - 2; 0 <= y; y--) {
                for (int x = 0; x < NX; x++) {
                    copy[y + 1][x] = copy[y][x];
                    copy[y][x] = 0;
                }
            }
        }

        if (ANS < killCount) {
            ANS = killCount;
        }
    }

    public static int[][] makeCopy(int[][] origin) {
        int[][] copy = new int[NY][NX];
        for (int y = 0; y < NY; y++) {
            for (int x = 0; x < NX; x++) {
                copy[y][x] = origin[y][x];
            }
        }
        return copy;
    }

    public static Enemy findEnemy(int x, int y, int[][] copy) {
        Queue<Point> q = new LinkedList<>();

        boolean visit[][] = new boolean[NY][NX];
        q.add(new Point(x, y));
        int max = Integer.MAX_VALUE;
        Enemy enemy = null;

        boolean flag = false;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 3; i++) {
                int nextX = cur.x + mx[i];
                int nextY = cur.y + my[i];
                int diff = Math.abs(nextX - x) + Math.abs(nextY - y);

                if (max < diff || ND < diff) {
                    flag = true;
                    break;
                }
                if (isSafe(nextX, nextY)) {
                    if (!visit[nextY][nextX]) {
                        visit[nextY][nextX] = true;
                        q.add(new Point(nextX, nextY));
                        if (copy[nextY][nextX] == 1) {
                            if (diff <= max) {
                                max = diff;

                                if (enemy == null) {
                                    enemy = new Enemy(nextX, nextY, diff);
                                } else {
                                    if (diff < enemy.d) {
                                        enemy = new Enemy(nextX, nextY, diff);
                                    } else if (diff == enemy.d) {
                                        if (nextX < enemy.x) {
                                            enemy = new Enemy(nextX, nextY, diff);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (flag) {
                break;
            }
        }
        return enemy;
    }

    public static boolean isSafe(int x, int y) {
        if (x < 0 || NX <= x || y < 0 || NY <= y) {
            return false;
        }
        return true;
    }
}

class AttackOrder implements Comparator<Enemy> {
    @Override
    public int compare(Enemy o1, Enemy o2) {
        if (o1.d == o2.d) {
            return o1.x - o2.x;
        }
        return o1.d - o2.d;
    }

}

class Enemy {
    int x;
    int y;
    int d;

    public Enemy(int x, int y, int d) {
        super();
        this.x = x;
        this.y = y;
        this.d = d;
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}