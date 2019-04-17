import java.util.Arrays;
import java.util.Scanner;

public class Main {

    final static int[] mx = { 0, 1, 0, -1 };
    final static int[] my = { -1, 0, 1, 0 };
    static int[][] possible, map;
    static int NX, NY, T, CLEANY;

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        NY = sc.nextInt();
        NX = sc.nextInt();
        T = sc.nextInt();

        map = new int[NY][NX];
        possible = new int[NY][NX];

        for (int y = 0; y < NY; y++) {
            for (int x = 0; x < NX; x++) {
                map[y][x] = sc.nextInt();
                if (map[y][x] == -1) {
                    CLEANY = y;
                }
            }
        }
        calPossible();
        solve();

        System.out.println(calAns());
    }

    public static void solve() {
        int time = 0;
        while (time < T) {
            int[][] newMap = new int[NY][NX];
            for (int y = 0; y < NY; y++) {
                for (int x = 0; x < NX; x++) {

                    if (map[y][x] == -1) {
                        continue;
                    }

                    if (map[y][x] < 4) {
                        newMap[y][x] += map[y][x];
                        continue;
                    }

                    int moveC = map[y][x] / 5;
                    int remain = map[y][x] - (moveC * possible[y][x]);
                    newMap[y][x] += remain;

                    for (int i = 0; i < 4; i++) {
                        int nextX = x + mx[i];
                        int nextY = y + my[i];
                        if (0 <= nextX && nextX < NX && 0 <= nextY && nextY < NY) {
                            if (newMap[nextY][nextX] != -1) {
                                newMap[nextY][nextX] += moveC;
                            }
                        }
                    }

                }
            }
            map = newMap;
            workClean();
            time += 1;
        }
    }

    public static void workClean() {
        for (int y = CLEANY - 2; 0 < y; y--) {
            map[y][0] = map[y - 1][0];
        }

        for (int x = 0; x < NX - 1; x++) {
            map[0][x] = map[0][x + 1];
        }

        for (int y = 0; y < CLEANY - 1; y++) {
            map[y][NX - 1] = map[y + 1][NX - 1];
        }

        for (int x = NX - 1; x > 1; x--) {
            map[CLEANY - 1][x] = map[CLEANY - 1][x - 1];
        }

        for (int y = CLEANY + 1; y < NY - 1; y++) {
            map[y][0] = map[y + 1][0];
        }

        for (int x = 0; x < NX - 1; x++) {
            map[NY - 1][x] = map[NY - 1][x + 1];
        }

        for (int y = NY - 1; CLEANY < y; y--) {
            map[y][NX - 1] = map[y - 1][NX - 1];
        }

        for (int x = NX - 1; 1 < x; x--) {
            map[CLEANY][x] = map[CLEANY][x - 1];
        }

        map[CLEANY - 1][1] = 0;
        map[CLEANY][1] = 0;

        map[CLEANY - 1][0] = 0;
        map[CLEANY][0] = 0;

    }

    public static void calPossible() {
        for (int y = 0; y < NY; y++) {
            for (int x = 0; x < NX; x++) {
                int sum = 0;

                for (int i = 0; i < 4; i++) {
                    int nextX = x + mx[i];
                    int nextY = y + my[i];
                    if (0 <= nextX && nextX < NX && 0 <= nextY && nextY < NY) {
                        if (map[nextY][nextX] != -1) {
                            sum += 1;
                        }
                    }
                }
                possible[y][x] = sum;
            }
        }
    }

    public static int calAns() {
        int sum = 0;
        for (int y = 0; y < NY; y++) {
            for (int x = 0; x < NX; x++) {
                sum += map[y][x];
            }
        }
        return sum;
    }
}
