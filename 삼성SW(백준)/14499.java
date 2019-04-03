import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int RIGHT = 1;
    static final int LEFT = 2;
    static final int UP = 3;
    static final int DOWN = 4;

    static final int[] mx = { 1, -1, 0, 0 };
    static final int[] my = { 0, 0, -1, 1 };

    static int nX, nY;
    static int[] dice = { 0, 0, 0, 0, 0, 0, 0 };

    public static void main(String[] args) {

        final StringBuilder ans = new StringBuilder();
        final Scanner sc = new Scanner(System.in);

        nY = sc.nextInt();
        nX = sc.nextInt();

        int curY = sc.nextInt();
        int curX = sc.nextInt();
        final int orderNo = sc.nextInt();

        final int[][] map = new int[nY][nX];
        for (int i = 0; i < nY; i++) {
            for (int j = 0; j < nX; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Queue<Integer> order = new LinkedList<>();
        for (int i = 0; i < orderNo; i++) {
            order.add(sc.nextInt());
        }

        while (!order.isEmpty()) {
            int d = order.poll();
            int nextX = curX + mx[d - 1];
            int nexty = curY + my[d - 1];

            if (safeCheck(nextX, nexty)) {
                dice = move(d);
                if (map[nexty][nextX] == 0) {
                    map[nexty][nextX] = dice[6];
                } else {
                    dice[6] = map[nexty][nextX];
                    map[nexty][nextX] = 0;
                }
                ans.append(dice[1] + "\n");
                curX = nextX;
                curY = nexty;
            }

        }

        System.out.println(ans.toString());
    }

    public static int[] move(int direction) {

        int[] newDice = new int[7];
        switch (direction) {
        case RIGHT:
            newDice[1] = dice[4];
            newDice[3] = dice[1];
            newDice[4] = dice[6];
            newDice[6] = dice[3];
            newDice[2] = dice[2];
            newDice[5] = dice[5];

            break;
        case LEFT:
            newDice[1] = dice[3];
            newDice[3] = dice[6];
            newDice[4] = dice[1];
            newDice[6] = dice[4];
            newDice[2] = dice[2];
            newDice[5] = dice[5];

            break;
        case UP:
            newDice[1] = dice[5];
            newDice[2] = dice[1];
            newDice[3] = dice[3];
            newDice[4] = dice[4];
            newDice[5] = dice[6];
            newDice[6] = dice[2];
            break;
        case DOWN:
            newDice[1] = dice[2];
            newDice[2] = dice[6];
            newDice[3] = dice[3];
            newDice[4] = dice[4];
            newDice[5] = dice[1];
            newDice[6] = dice[5];
            break;
        }
        return newDice;
    }

    public static boolean safeCheck(int x, int y) {
        if (0 <= x && x < nX && 0 <= y && y < nY) {
            return true;
        }
        return false;
    }
}
