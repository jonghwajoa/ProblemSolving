import java.util.*;

public class Main {
    final static int WALL = 0;
    final static int POSSIBLE = 1;
    final static int HALL = 2;
    final static int BLUE = 3;
    final static int RED = 4; // 탈출해야함

    final static int UP = 0;
    final static int RIGHT = 1;
    final static int DOWN = 2;
    final static int LEFT = 3;

    static int[][] BOARD;
    static int Y;
    static int X;
    static int ans = Integer.MAX_VALUE;

    static int[] order = { UP, RIGHT, DOWN, LEFT };
    static int[] mx = { 0, 1, 0, -1 };
    static int[] my = { -1, 0, 1, 0 };

    static boolean flag = false;

    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);

        Y = sc.nextInt();
        X = sc.nextInt();
        BOARD = new int[Y][X];

        Point red = null, blue = null;

        sc.nextLine();
        for (int i = 0; i < Y; i += 1) {
            char[] inputLine = sc.nextLine().toCharArray();

            for (int j = 0; j < X; j += 1) {
                char cur = inputLine[j];
                if (cur == '#') {
                    BOARD[i][j] = WALL;
                } else if (cur == '.') {
                    BOARD[i][j] = POSSIBLE;
                } else if (cur == 'B') {
                    BOARD[i][j] = POSSIBLE;
                    blue = new Point(j, i);
                } else if (cur == 'R') {
                    BOARD[i][j] = POSSIBLE;
                    red = new Point(j, i);
                } else {
                    BOARD[i][j] = HALL;
                }
            }
        }

        dfs(0, red, blue);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static void dfs(int count, Point red, Point blue) {
        if (count > 9) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (possible(order[i], blue)) {
                Point nextRedPoint = new Point(0, 0), nextBluePoint = new Point(0, 0);

                if (!getPoint(order[i], red, blue, count + 1, nextRedPoint, nextBluePoint)) {
                    dfs(count + 1, nextRedPoint, nextBluePoint);
                }
            }
        }
    }

    public static boolean getPoint(int direction, Point red, Point blue, int count, Point nextRedPoint,
            Point nextBluePoint) {
        // true 라면 red가 앞에있음
        boolean whoIsFront = true;

        switch (direction) {
        case UP:
            whoIsFront = red.y < blue.y ? true : false;
            break;
        case RIGHT:
            whoIsFront = red.x > blue.x ? true : false;
            break;
        case DOWN:
            whoIsFront = red.y > blue.y ? true : false;
            break;
        case LEFT:
            whoIsFront = red.x < blue.x ? true : false;
            break;
        }

        // red가 앞에 있을때
        int curRedX = red.x;
        int curRedY = red.y;
        int curBlueX = blue.x;
        int curBlueY = blue.y;
        if (whoIsFront) {

            // 레드부터 음직인다.
            while (true) {
                curRedX += mx[direction];
                curRedY += my[direction];

                if (BOARD[curRedY][curRedX] == HALL) {

                    if (count < ans) {
                        ans = count;
                    }
                    return true;
                }

                if (BOARD[curRedY][curRedX] == WALL) {
                    curRedX -= mx[direction];
                    curRedY -= my[direction];
                    break;
                }
            }

            while (true) {
                curBlueX += mx[direction];
                curBlueY += my[direction];

                if (curBlueX == curRedX && curBlueY == curRedY || BOARD[curBlueY][curBlueX] == WALL) {
                    curBlueX -= mx[direction];
                    curBlueY -= my[direction];
                    break;
                }
            }
        } else { // 블루 부터 음직인다.

            while (true) {
                curBlueX += mx[direction];
                curBlueY += my[direction];

                if (BOARD[curBlueY][curBlueX] == WALL) {
                    curBlueX -= mx[direction];
                    curBlueY -= my[direction];
                    break;
                }
            }

            while (true) {
                curRedX += mx[direction];
                curRedY += my[direction];

                if (BOARD[curRedY][curRedX] == WALL || curBlueX == curRedX && curBlueY == curRedY) {
                    curRedX -= mx[direction];
                    curRedY -= my[direction];
                    break;
                }

                if (BOARD[curRedY][curRedX] == HALL) {
                    if (count < ans) {
                        ans = count;
                    }
                    return true;
                }
            }
        }

        nextRedPoint.x = curRedX;
        nextRedPoint.y = curRedY;

        nextBluePoint.x = curBlueX;
        nextBluePoint.y = curBlueY;

        return false;
    }

    public static boolean possible(int direction, Point blue) {

        int curX = blue.x;
        int curY = blue.y;

        while (true) {
            curX += mx[direction];
            curY += my[direction];

            if (BOARD[curY][curX] == HALL) {
                return false;
            } else if (BOARD[curY][curX] == WALL) {
                return true;
            }
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