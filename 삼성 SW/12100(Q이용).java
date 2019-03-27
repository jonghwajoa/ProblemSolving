import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
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

    public static void commonLogic(Queue<Integer> q, ArrayList<Integer> nextColums) {
        while (!q.isEmpty()) {
            int cur = q.poll();
            Integer nextVal = q.peek();

            if (nextVal == null || cur != nextVal) {
                nextColums.add(cur);
            } else {
                q.poll();
                nextColums.add(cur * 2);
            }
        }
    }

    public static int[][] moveUp(final int[][] origin) {
        final int[][] nextBoard = new int[N][N];
        final ArrayList<Integer> nextColums = new ArrayList<>();
        final Queue<Integer> q = new LinkedList<>();

        for (int x = 0; x < N; x++) {
            nextColums.clear();

            for (int y = 0; y < N; y++) {
                if (origin[y][x] != 0) {
                    q.add(origin[y][x]);
                }
            }

            commonLogic(q, nextColums);

            final int listSize = nextColums.size();
            for (int i = 0; i < listSize; i++) {
                nextBoard[i][x] = nextColums.get(i);
            }
        }

        return nextBoard;
    }

    public static int[][] moveRight(final int[][] origin) {
        final int[][] nextBoard = new int[N][N];
        final ArrayList<Integer> nextColums = new ArrayList<>();
        final Queue<Integer> q = new LinkedList<>();

        for (int y = 0; y < N; y++) {
            nextColums.clear();

            for (int x = N - 1; 0 <= x; x--) {
                if (origin[y][x] != 0) {
                    q.add(origin[y][x]);
                }
            }

            commonLogic(q, nextColums);

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
        final ArrayList<Integer> nextColums = new ArrayList<>();
        final Queue<Integer> q = new LinkedList<>();

        for (int x = 0; x < N; x++) {
            nextColums.clear();

            for (int y = N - 1; 0 <= y; y--) {
                if (origin[y][x] != 0) {
                    q.add(origin[y][x]);
                }
            }

            commonLogic(q, nextColums);

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
        final ArrayList<Integer> nextColums = new ArrayList<>();
        final Queue<Integer> q = new LinkedList<>();

        for (int y = 0; y < N; y++) {
            nextColums.clear();

            for (int x = 0; x < N; x++) {
                if (origin[y][x] != 0) {
                    q.add(origin[y][x]);
                }
            }

            commonLogic(q, nextColums);

            final int listSize = nextColums.size();
            for (int i = 0; i < listSize; i++) {
                nextBoard[y][i] = nextColums.get(i);
            }
        }

        return nextBoard;
    }

    public static void findLargestValOnBoard(final int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ans < board[i][j]) {
                    ans = board[i][j];
                }
            }
        }
    }
}