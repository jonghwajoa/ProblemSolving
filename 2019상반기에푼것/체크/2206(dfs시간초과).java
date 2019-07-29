import java.util.*;

public class Main {
    static int[] moveX = { 0, 0, 1, -1 };
    static int[] moveY = { 1, -1, 0, 0 };
    static boolean[][] isVisit;
    static int[][] map;
    static int mapX, mapY;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");

        mapY = Integer.parseInt(line[0]);
        mapX = Integer.parseInt(line[1]);
        map = new int[mapY][mapX];
        isVisit = new boolean[mapY][mapX];

        for (int i = 0; i < mapY; i++) {
            line = sc.nextLine().split("");
            for (int j = 0; j < mapX; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        dfs(0, 0, 1, false);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static void dfs(int x, int y, int count, boolean check) {
        if (x == mapX - 1 && y == mapY - 1) {
            if (count < ans) {
                ans = count;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if (0 <= nextX && 0 <= nextY && nextX < mapX && nextY < mapY) {
                if (!isVisit[nextY][nextX]) {
                    if (map[nextY][nextX] == 0) {
                        isVisit[nextY][nextX] = true;
                        dfs(nextX, nextY, count + 1, check);
                        isVisit[nextY][nextX] = false;
                    } else {
                        if (check == false) {
                            isVisit[nextY][nextX] = true;
                            dfs(nextX, nextY, count + 1, true);
                            isVisit[nextY][nextX] = false;
                        }
                    }
                }
            }
        }
    }
}
