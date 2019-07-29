// https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRF8s6ezEDFAUo&categoryId=AWXRF8s6ezEDFAUo&categoryType=CODE&&&

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static final int BLACK_HALL = -1;
    static final int EMPTY = 0;
    static final int[] mx = { 0, 1, 0, -1 };
    static final int[] my = { -1, 0, 1, 0 };
    static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

    static int N;
    static int max = Integer.MAX_VALUE, curDirection = 0, count = 0;
    static int[][][] visit;
    static int[][] map;
    static ArrayList<Point>[] warmHall;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            max = Integer.MIN_VALUE;

            map = new int[N][N];
            visit = new int[4][N][N];

            warmHall = new ArrayList[5];

            for (int i = 0; i < 5; i++) {
                warmHall[i] = new ArrayList<Point>();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int input = sc.nextInt();
                    map[i][j] = input;
                    if (6 <= input && input <= 10) {
                        warmHall[input - 6].add(new Point(j, i));
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) {
                        bfs(j, i);
                    }
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }

    public static void bfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int count = 0;
            int curX = x;
            int curY = y;
            curDirection = i;

            while (true) {
                int nextX = curX + mx[curDirection];
                int nextY = curY + my[curDirection];
                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {

                    int mapV = map[nextY][nextX];

                    if (nextX == x && nextY == y || mapV == -1) {
                        break;
                    } else if (mapV == 0) {
                        curX = nextX;
                        curY = nextY;
                        continue;
                    } else if (6 <= mapV && mapV <= 10) {
                        Point warm1 = warmHall[mapV - 6].get(0);
                        Point warm2 = warmHall[mapV - 6].get(1);

                        if (warm1.x == nextX && warm1.y == nextY) {
                            curX = warm2.x;
                            curY = warm2.y;
                        } else {
                            curX = warm1.x;
                            curY = warm1.y;
                        }
                    } else {
                        if (isWall(nextX, nextY)) {
                            curDirection = (curDirection + 2) % 4;
                        } else {
                            findNextDirection(nextX, nextY);
                        }
                        count += 1;
                        curX = nextX;
                        curY = nextY;
                    }
                } else {
                    count += 1;
                    curX = nextX;
                    curY = nextY;
                    curDirection = (curDirection + 2) % 4;
                }
            }

            if (max < count) {
                max = count;
            }
        }
    }

    public static boolean isWall(int x, int y) {
        int figure = map[y][x];
        // 벽인지 확인
        switch (figure) {
        case 1:
            if (curDirection == RIGHT || curDirection == UP) {
                return true;
            }
            break;
        case 2:
            if (curDirection == DOWN || curDirection == RIGHT) {
                return true;
            }
            break;
        case 3:
            if (curDirection == DOWN || curDirection == LEFT) {
                return true;
            }
            break;
        case 4:
            if (curDirection == UP || curDirection == LEFT) {
                return true;
            }
            break;
        case 5:
            return true;
        }

        return false;
    }

    public static void findNextDirection(int x, int y) {
        int figure = map[y][x];
        // 벽인지 확인
        switch (figure) {
        case 1:
            if (curDirection == DOWN) {
                curDirection = RIGHT;
            } else if (curDirection == LEFT) {
                curDirection = UP;
            }
            break;
        case 2:
            if (curDirection == UP) {
                curDirection = RIGHT;
            } else if (curDirection == LEFT) {
                curDirection = DOWN;
            }
            break;
        case 3:
            if (curDirection == UP) {
                curDirection = LEFT;
            } else if (curDirection == RIGHT) {
                curDirection = DOWN;
            }
            break;
        case 4:
            if (curDirection == RIGHT) {
                curDirection = UP;
            } else if (curDirection == DOWN) {
                curDirection = LEFT;
            }
            break;
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
