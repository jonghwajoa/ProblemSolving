import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean[] visit;
    static int[] order;
    static int inning, outCount, attacker;
    static int[][] hit;
    static int N;
    final static int ONE = 1, TWO = 2, THREE = 3, HOME = 4, OUT = 0;
    static boolean BASE_ONE, BASE_TWO, BASE_THREE;
    static int ans, score;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visit = new boolean[9];
        order = new int[9];
        visit[0] = true;
        ans = 0;
        hit = new int[N][9];
        for (int i = 0; i < N; i++) {
            for (int z = 0; z < 9; z++) {
                hit[i][z] = sc.nextInt();
            }
        }
        dfs(0);
        System.out.println(ans);
    }

    public static void dfs(int index) {
        if (9 <= index) {
            simulation();
            return;
        }

        if (index == 3) {
            order[3] = 0;
            dfs(index + 1);
        } else {
            for (int i = 0; i < 9; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    order[index] = i;
                    dfs(index + 1);
                    visit[i] = false;
                }
            }
        }
    }

    public static void simulation() {
        inning = 0;
        outCount = 0;
        attacker = 0;
        score = 0;

        while (inning < N) {
            int curHit = hit[inning][order[attacker]];
            attacker = (attacker + 1) % 9;

            if (curHit == 0) {
                outCount += 1;
                if (outCount == 3) {
                    initBase();
                }
            } else {
                move(curHit);
            }
        }

        if (score > ans) {
            ans = score;
        }
    }

    public static void initBase() {
        BASE_ONE = false;
        BASE_TWO = false;
        BASE_THREE = false;
        inning += 1;
        outCount = 0;
    }

    public static void move(int hit) {
        if (hit == ONE) {
            if (BASE_THREE) {
                BASE_THREE = false;
                score += 1;
            }

            if (BASE_TWO) {
                BASE_TWO = false;
                BASE_THREE = true;
            }

            if (BASE_ONE) {
                BASE_TWO = true;
            }

            BASE_ONE = true;
        } else if (hit == TWO) {
            if (BASE_THREE) {
                BASE_THREE = false;
                score += 1;
            }

            if (BASE_TWO) {
                BASE_TWO = false;
                score += 1;
            }

            if (BASE_ONE) {
                BASE_THREE = true;
                BASE_ONE = false;
            }
            BASE_TWO = true;
        } else if (hit == THREE) {
            if (BASE_THREE) {
                BASE_THREE = false;
                score += 1;
            }

            if (BASE_TWO) {
                BASE_TWO = false;
                score += 1;
            }

            if (BASE_ONE) {
                BASE_ONE = false;
                score += 1;
            }
            BASE_THREE = true;
        } else if (hit == HOME) {
            if (BASE_THREE) {
                BASE_THREE = false;
                score += 1;
            }

            if (BASE_TWO) {
                BASE_TWO = false;
                score += 1;
            }

            if (BASE_ONE) {
                BASE_ONE = false;
                score += 1;
            }
            score += 1;
        }
    }
}
