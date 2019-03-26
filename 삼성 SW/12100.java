import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;
    static final int[] ORDER = { UP, RIGHT, DOWN, LEFT };

    static int N;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        final int[][] BOARD = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                BOARD[i][j] = sc.nextInt();
            }
        }

        dfs(BOARD, 0);

        System.out.println(ans);
    }

    public static void dfs(final int[][] board, int count) {
        if (count >= 5) {
            findLargestValOnBoard(board);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] nextBoard = inputNextBoard(ORDER[i], board);
            dfs(nextBoard, count + 1);
        }
    }

    public static int[][] inputNextBoard(final int direction, final int[][] origin) {
        int[][] nextBoard = null;
        switch (direction) {
        case UP:
            nextBoard = moveUp(origin);
            break;
        case RIGHT:
            nextBoard = moveRight(origin);
            break;
        case DOWN:
            nextBoard = moveDown(origin);
            break;
        case LEFT:
            nextBoard = moveLeft(origin);
            break;
        }
        return nextBoard;
    }

    public static int[][] moveUp(final int[][] origin) {
        final int[][] nextBoard = new int[N][N];

        for (int x = 0; x < N; x++) {
            int prev = -1;
            final ArrayList<Integer> nextColums = new ArrayList<>();

            for (int y = 0; y < N; y++) {
                if (origin[y][x] == 0) {
                    continue;
                }

                if (prev == -1) {
                    prev = origin[y][x];
                    continue;
                }

                if (origin[y][x] == prev) {
                    nextColums.add(prev * 2);
                    prev = -1;
                } else {
                    nextColums.add(prev);
                    prev = origin[y][x];
                }
            }
            if (prev != -1) {
                nextColums.add(prev);
            }

            final int listSize = nextColums.size();
            for (int i = 0; i < listSize; i++) {
                nextBoard[i][x] = nextColums.get(i);
            }
        }

        return nextBoard;
    }

    public static int[][] moveRight(final int[][] origin) {
        final int[][] nextBoard = new int[N][N];
        for (int y = 0; y < N; y++) {
            int prev = -1;
            final ArrayList<Integer> nextColums = new ArrayList<>();
            for (int x = N - 1; 0 <= x; x--) {
                if (origin[y][x] == 0) {
                    continue;
                }

                if (prev == -1) {
                    prev = origin[y][x];
                    continue;
                }

                if (origin[y][x] == prev) {
                    nextColums.add(prev * 2);
                    prev = -1;
                } else {
                    nextColums.add(prev);
                    prev = origin[y][x];
                }
            }
            if (prev != -1) {
                nextColums.add(prev);
            }

            final int listSize = nextColums.size();
            int index = N - 1;
            for (int i = 0; i < listSize; i++) {
                nextBoard[y][index - i] = nextColums.get(i);
            }
        }

        return nextBoard;
    }

    public static int[][] moveDown(final int[][] origin) {
        final int[][] nextBoard = new int[N][N];
        for (int x = 0; x < N; x++) {
            int prev = -1;
            final ArrayList<Integer> nextColums = new ArrayList<>();
            for (int y = N - 1; 0 <= y; y--) {
                if (origin[y][x] == 0) {
                    continue;
                }

                if (prev == -1) {
                    prev = origin[y][x];
                    continue;
                }

                if (origin[y][x] == prev) {
                    nextColums.add(prev * 2);
                    prev = -1;
                } else {
                    nextColums.add(prev);
                    prev = origin[y][x];
                }
            }
            if (prev != -1) {
                nextColums.add(prev);
            }

            final int listSize = nextColums.size();
            int index = N - 1;
            for (int i = 0; i < listSize; i++) {
                nextBoard[index - i][x] = nextColums.get(i);
            }
        }

        return nextBoard;
    }

    public static int[][] moveLeft(final int[][] origin) {
        final int[][] nextBoard = new int[N][N];
        for (int y = 0; y < N; y++) {
            int prev = -1;
            final ArrayList<Integer> nextColums = new ArrayList<>();
            for (int x = 0; x < N; x++) {
                if (origin[y][x] == 0) {
                    continue;
                }

                if (prev == -1) {
                    prev = origin[y][x];
                    continue;
                }

                if (origin[y][x] == prev) {
                    nextColums.add(prev * 2);
                    prev = -1;
                } else {
                    nextColums.add(prev);
                    prev = origin[y][x];
                }
            }
            if (prev != -1) {
                nextColums.add(prev);
            }

            final int listSize = nextColums.size();
            for (int i = 0; i < listSize; i++) {
                nextBoard[y][i] = nextColums.get(i);
            }
        }

        return nextBoard;
    }

    public static void findLargestValOnBoard(final int[][] board) {
        final int len = board.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (ans < board[i][j]) {
                    ans = board[i][j];
                }
            }
        }
    }
}