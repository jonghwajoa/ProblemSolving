import java.util.*;

public class Main {
    static int[] moveX = { 0, 0, -1, 1 };
    static int[] moveY = { 1, -1, 0, 0 };
    static int max = Integer.MIN_VALUE;
    static int nX;
    static int nY;
    static int[][] map;
    static boolean[][] isVisit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputLine = sc.nextLine().split(" ");

        nY = Integer.parseInt(inputLine[0]);
        nX = Integer.parseInt(inputLine[1]);
        map = new int[nY][nX];
        isVisit = new boolean[nY][nX];

        for (int i = 0; i < nY; i++) {
            inputLine = sc.nextLine().split(" ");
            for (int j = 0; j < nX; j++) {
                map[i][j] = Integer.parseInt(inputLine[j]);
            }
        }

        for (int y = 0; y < nY; y++) {
            for (int x = 0; x < nX; x++) {
                isVisit[y][x] = true;
                dfs(1, map[y][x], x, y);
                middleFinger(map[y][x], x, y);
                isVisit[y][x] = false;
            }
        }

        System.out.println(max);
    }

    public static void dfs(int curIndex, int acc, int curX, int curY) {
        if (curIndex == 4) {
            if (max < acc) {
                max = acc;
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int nextX = curX + moveX[i];
                int nextY = curY + moveY[i];

                if (0 <= nextX && 0 <= nextY && nextX < nX && nextY < nY) {
                    if (!isVisit[nextY][nextX]) {
                        isVisit[nextY][nextX] = true;
                        dfs(curIndex + 1, acc + map[nextY][nextX], nextX, nextY);
                        isVisit[nextY][nextX] = false;
                    }
                }
            }
        }
    }

    public static void middleFinger(int acc, int curX, int curY) {
        int count = 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int nextX = curX + moveX[i];
            int nextY = curY + moveY[i];
            if (0 <= nextX && 0 <= nextY && nextX < nX && nextY < nY) {
                count += 1;
                int nextVal = map[nextY][nextX];
                if (nextVal < min) {
                    min = nextVal;
                }
                acc += nextVal;
            }
        }

        if (count < 4) {
            return;
        } else if (count == 4) {
            if (max < acc) {
                max = acc;
            }
        } else {
            acc -= min;
            if (max < acc) {
                max = acc;
            }
        }
    }
}