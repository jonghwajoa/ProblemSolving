import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int[][] map;
    static Turn[] turn;
    static boolean[] isVisit;
    static int[] order;
    static int ans, K, Y, X;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[Y][X];
        turn = new Turn[K];
        order = new int[K];
        ans = Integer.MAX_VALUE;
        isVisit = new boolean[K + 1];

        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < X; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            turn[i] = new Turn(y, x, s);
        }

        dfs(0);
        System.out.println(ans);

    }

    // 백트레킹을 이용하여 모든 경우의수 order를 만든다..
    public static void dfs(int depth) {
        if (K <= depth) {
            action();
            return;
        }

        for (int i = 1; i <= K; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                order[depth] = i;
                dfs(depth + 1);
                isVisit[i] = false;
            }
        }
    }

    // 만들어진 순서를 통해서 turn을 진행한다.
    public static void action() {
        int[][] copy = deepCopy();

        for (int i = 0; i < K; i++) {
            executeTurn(copy, i);
        }
        calSquareValue(copy);
    }

    // 하나의 turn을 수행한다. K 하나에 대한 수행
    public static void executeTurn(int[][] copy, int i) {
        int index = order[i] - 1;
        Turn turnInfo = turn[index];
        int stY = turnInfo.y - turnInfo.s - 1;
        int edY = turnInfo.y + turnInfo.s - 1;
        int stX = turnInfo.x - turnInfo.s - 1;
        int edX = turnInfo.x + turnInfo.s - 1;

        int repeat = (edX - stX + 1) / 2;
        for (int z = 0; z < repeat; z++) {
            unitTurn(copy, stX + z, stY + z, edX - z, edY - z);
        }

    }

    public static void calSquareValue(int[][] copy) {
        int min = Integer.MAX_VALUE;

        for (int y = 0; y < Y; y++) {
            int sum = 0;
            for (int x = 0; x < X; x++) {
                sum += copy[y][x];
            }
            if (sum < min) {
                min = sum;
            }
        }

        if (min < ans) {
            ans = min;
        }
    }

    // 한 테두리를 turn시킨다. 여러번 호출시켜 사각형 전체를 턴하는것을 의미
    public static void unitTurn(int[][] copy, int stX, int stY, int edX, int edY) {
        int backup = copy[stY][stX];
        // up -> left -> down -> right 즉 ↑ ← ↓ →을 수행할 for문 4개

        // up
        for (int y = stY; y < edY; y++) {
            copy[y][stX] = copy[y + 1][stX];
        }

        // left
        for (int x = stX; x < edX; x++) {
            copy[edY][x] = copy[edY][x + 1];
        }

        // down
        for (int y = edY; stY < y; y--) {
            copy[y][edX] = copy[y - 1][edX];
        }

        // right
        for (int x = edX; stX < x; x--) {
            copy[stY][x] = copy[stY][x - 1];
        }

        copy[stY][stX + 1] = backup;
    }

    public static int[][] deepCopy() {
        int[][] newMap = new int[Y][X];
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                newMap[y][x] = map[y][x];
            }
        }
        return newMap;
    }
}

class Turn {
    int y;
    int x;
    int s;

    public Turn(int y, int x, int s) {
        super();
        this.y = y;
        this.x = x;
        this.s = s;
    }
}