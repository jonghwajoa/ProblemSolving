import java.util.Arrays;
import java.util.Scanner;

public class Main {
    final static int UP = 0;
    final static int RIGHT = 1;
    final static int DOWN = 2;
    final static int LEFT = 3;
    final static int EMPTY = 0;
    final static int WALL = 1;
    final static int VISIT = 2;

    final static int[] mx = { 0, 1, 0, -1 };
    final static int[] my = { -1, 0, 1, 0 };
    // d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽
    static int[][] map;
    static int curDirection;
    static int ans = 0;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int NY = sc.nextInt();
        int NX = sc.nextInt();

        map = new int[NY][NX];

        int y = sc.nextInt();
        int x = sc.nextInt();
        curDirection = sc.nextInt();

        for (int i = 0; i < NY; i++) {
            for (int j = 0; j < NX; j++) {
                if (sc.nextInt() == 1) {
                    map[i][j] = WALL;
                }
            }
        }

        int ans = 0;

        while (true) {
            if (map[y][x] == EMPTY) {
                ans += 1;
                map[y][x] = VISIT;
            }

            if (check4d(x, y)) {
                if (exitCondition(x, y)) {
                    break;
                }
                int backDirection = (curDirection + 2) % 4;
                x += mx[backDirection];
                y += my[backDirection];
                continue;
            }

            int nextD = leftDirection();
            int nextX = x + mx[nextD];
            int nextY = y + my[nextD];

            if (map[nextY][nextX] == EMPTY) {
                curDirection = nextD;
                x = nextX;
                y = nextY;
            } else {
                curDirection = nextD;
            }

        }

        System.out.println(ans);
    }

    public static int leftDirection() {
        return (curDirection + 3) % 4;
    }

    // true 반환시 갈곳이 없음..
    public static boolean check4d(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + mx[i];
            int nextY = y + my[i];
            if (map[nextY][nextX] == EMPTY) {
                return false;
            }
        }
        return true;
    }

    // true 반환시 exit
    public static boolean exitCondition(int x, int y) {
        int backDirection = (curDirection + 2) % 4;
        int nextX = x + mx[backDirection];
        int nextY = y + my[backDirection];
        if (map[nextY][nextX] == WALL) {
            return true;
        }
        return false;
    }
}
