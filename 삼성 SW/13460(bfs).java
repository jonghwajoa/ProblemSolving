import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int WALL = 0, POSSIBLE = 1, HALL = 2, BLUE = 3, RED = 4;
    static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    static int[][] BOARD;
    static int Y, X;
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

        sc.nextLine();

        int bX = 0, bY = 0, rX = 0, rY = 0;
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
                    bX = j;
                    bY = i;
                } else if (cur == 'R') {
                    BOARD[i][j] = POSSIBLE;
                    rX = j;
                    rY = i;
                } else {
                    BOARD[i][j] = HALL;
                }
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, bX, bY, rX, rY));

        boolean flag = false;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int blueX = cur.blueX;
            int blueY = cur.blueY;
            int redX = cur.redX;
            int redY = cur.redY;
            int count = cur.count;

            if (count >= 10) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                if (possible(i, blueX, blueY)) {
                    boolean whoIsFront = true;

                    switch (i) {
                    case UP:
                        whoIsFront = redY < blueY ? true : false;
                        break;
                    case RIGHT:
                        whoIsFront = redX > blueX ? true : false;
                        break;
                    case DOWN:
                        whoIsFront = redY > blueY ? true : false;
                        break;
                    case LEFT:
                        whoIsFront = redX < blueX ? true : false;
                        break;
                    }

                    int nextBlueX = blueX;
                    int nextBlueY = blueY;
                    int nextRedX = redX;
                    int nextRedY = redY;

                    // 레드부터 음직인다.
                    if (whoIsFront) {
                        while (true) {
                            nextRedX += mx[i];
                            nextRedY += my[i];

                            if (BOARD[nextRedY][nextRedX] == HALL) {
                                flag = true;
                                break;
                            }

                            if (BOARD[nextRedY][nextRedX] == WALL) {
                                nextRedX -= mx[i];
                                nextRedY -= my[i];
                                break;
                            }
                        }

                        while (true) {
                            nextBlueX += mx[i];
                            nextBlueY += my[i];

                            if (nextBlueX == nextRedX && nextBlueY == nextRedY || BOARD[nextBlueY][nextBlueX] == WALL) {
                                nextBlueX -= mx[i];
                                nextBlueY -= my[i];
                                break;
                            }
                        }
                    } else { // 블루 부터 음직인다.
                        while (true) {
                            nextBlueX += mx[i];
                            nextBlueY += my[i];

                            if (BOARD[nextBlueY][nextBlueX] == WALL) {
                                nextBlueX -= mx[i];
                                nextBlueY -= my[i];
                                break;
                            }
                        }

                        while (true) {
                            nextRedX += mx[i];
                            nextRedY += my[i];

                            if (BOARD[nextRedY][nextRedX] == WALL || nextBlueX == nextRedX && nextBlueY == nextRedY) {
                                nextRedX -= mx[i];
                                nextRedY -= my[i];
                                break;
                            }

                            if (BOARD[nextRedY][nextRedX] == HALL) {
                                flag = true;
                                break;
                            }
                        }
                    }
                    q.add(new Point(count + 1, nextBlueX, nextBlueY, nextRedX, nextRedY));
                }
            }

            if (flag) {
                ans = count + 1;
                break;
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static boolean possible(int direction, int x, int y) {

        while (true) {
            x += mx[direction];
            y += my[direction];

            if (BOARD[y][x] == WALL) {
                return true;
            } else if (BOARD[y][x] == HALL) {
                return false;
            }
        }
    }
}

class Point {
    int count;
    int blueX;
    int blueY;
    int redX;
    int redY;

    public Point(int count, int blueX, int blueY, int redX, int redY) {
        this.count = count;
        this.blueX = blueX;
        this.blueY = blueY;
        this.redX = redX;
        this.redY = redY;
    }
}