import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] my = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] mx = { -1, 0, 1, -1, 1, -1, 0, 1 };
    static int N, M, K;
    static int[][] map;
    static int[][] rc;
    static PriorityQueue<Tree> q;

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][N];
        rc = new int[N][N];
        q = new PriorityQueue<>(new TreeOrder());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = 5;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rc[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            int age = sc.nextInt();
            q.add(new Tree(x, y, age));
        }
        solve();

        System.out.println(q.size());
    }

    // 9분에 시작
    public static void solve() {

        Queue<Tree> dieQ = new LinkedList<>();
        Queue<Tree> qjstlrQ = new LinkedList<>();
        int time = 0;

        // 봄에 나이만큼 양분을 먹고 나이가 +1 , 양분못먹으면 죽음
        // 하나의 칸에 여러개 먹을수도 있다.
        // 여름에 나이/2 만큼 양분이됨
        // 가을 번식함 but 나무가 5배수여야함..
        // 겨울에는 양분을 추가해줌.
        while (time < K) {
            PriorityQueue<Tree> tmp = new PriorityQueue<>(new TreeOrder());
            while (!q.isEmpty()) {
                Tree cur = q.poll();
                if (cur.age <= map[cur.y][cur.x]) {
                    map[cur.y][cur.x] -= cur.age;
                    cur.age += 1;
                    tmp.add(cur);

                    if (cur.age % 5 == 0) {
                        qjstlrQ.add(cur);
                    }
                } else {
                    dieQ.add(cur);
                }
            }
            q = tmp;

            while (!dieQ.isEmpty()) {
                Tree cur = dieQ.poll();
                cur.age = (int) (cur.age / 2);
                map[cur.y][cur.x] += cur.age;
            }

            while (!qjstlrQ.isEmpty()) {
                Tree cur = qjstlrQ.poll();
                int x = cur.x;
                int y = cur.y;
                for (int i = 0; i < 8; i++) {
                    int nextX = x + mx[i];
                    int nextY = y + my[i];
                    if (isSafe(nextX, nextY)) {
                        q.add(new Tree(nextX, nextY, 1));
                    }
                }
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    map[y][x] += rc[y][x];
                }
            }

            time++;
        }
    }

    public static boolean isSafe(int x, int y) {
        if (x < 0 || N <= x || y < 0 || N <= y) {
            return false;
        }
        return true;
    }
}

class TreeOrder implements Comparator<Tree> {
    @Override
    public int compare(Tree o1, Tree o2) {
        return o1.age - o2.age;
    }
}

class Tree {
    int x;
    int y;
    int age;

    public Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }
}
