import java.util.*;

public class Main {
    static int ans = Integer.MIN_VALUE;
    static int[] moveX = { 1, -1, 0, 0 };
    static int[] moveY = { 0, 0, 1, -1 };
    static char[][] matrix;
    static Queue<Pair> fire;
    static Queue<Pair> me;
    static int x;
    static int y;
    static boolean success = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        y = sc.nextInt();
        x = sc.nextInt();

        matrix = new char[y][x];
        fire = new LinkedList<>();
        me = new LinkedList<>();

        sc.nextLine();
        for (int i = 0; i < y; i++) {
            matrix[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < x; j++) {
                if (matrix[i][j] == 'F') {
                    fire.add(new Pair(j, i, 0));
                } else if (matrix[i][j] == 'J') {
                    me.add(new Pair(j, i, 0));
                }
            }
        }

        success = false;
        for (int i = 0;; i++) {
            meMove(i);
            if (success) {
                System.out.println(i + 1);
                break;
            }
            fireMove(i);
            if (me.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                break;
            }

        }
    }

    public static void meMove(int step) {
        while (!me.isEmpty()) {
            if (me.peek().step != step) {
                break;
            }
            Pair cur = me.poll();

            if (matrix[cur.y][cur.x] != 'J') {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + moveX[i];
                int nextY = cur.y + moveY[i];

                if (nextX < 0 || nextY < 0 || nextX >= x || nextY >= y) {
                    success = true;
                    break;
                }

                char status = matrix[nextY][nextX];
                if (status == '.') {
                    matrix[nextY][nextX] = 'J';
                    me.add(new Pair(nextX, nextY, step + 1));
                }
            }
        }
    }

    public static void fireMove(int step) {

        while (!fire.isEmpty()) {
            if (fire.peek().step != step) {
                break;
            }
            Pair cur = fire.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + moveX[i];
                int nextY = cur.y + moveY[i];

                if (0 <= nextX && 0 <= nextY && nextX < x && nextY < y) {
                    char status = matrix[nextY][nextX];
                    if (status == '.' || status == 'J') {
                        matrix[nextY][nextX] = 'F';
                        fire.add(new Pair(nextX, nextY, step + 1));
                    }
                }
            }
        }
    }
}

class Pair {
    int x;
    int y;
    int step;

    public Pair(int x, int y, int step) {
        super();
        this.x = x;
        this.y = y;
        this.step = step;
    }

}
