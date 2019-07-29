import java.util.*;

class Main {
    final static int DOWN = 0, RIGHT = 1, LEFT = 2;
    static int[][] map;
    static int ans;
    static int X, Y;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        X = sc.nextInt();
        int M = sc.nextInt();
        Y = sc.nextInt();
        map = new int[Y][X];
        ans = -1;

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            map[a][b] = RIGHT;
            map[a][b + 1] = LEFT;
        }

        dfs(0);
        System.out.println(ans);
    }

    public static void dfs(int step) {
        if (possible()) {
            ans = step;
            return;
        }
        if (ans != -1 && ans <= step) {
            return;
        }

        if (step >= 3) {
            return;
        }

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X - 1; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = RIGHT;
                    map[i][j + 1] = LEFT;
                    dfs(step + 1);
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
    }

    public static boolean possible() {
        for (int i = 0; i < X; i++) {
            int y = 0;
            int x = i;
            while (y < Y) {
                switch (map[y][x]) {
                case RIGHT:
                    x += 1;
                    break;
                case LEFT:
                    x -= 1;
                    break;
                case DOWN:
                    break;
                }
                y += 1;
            }
            if (x != i) {
                return false;
            }
        }
        return true;
    }
}
