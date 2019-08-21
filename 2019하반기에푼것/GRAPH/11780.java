import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] path;

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int M = Integer.parseInt(br.readLine());
        final int INF = 100000001;

        map = new int[N + 1][N + 1];
        path = new int[N + 1][N + 1];
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                if (x != y) {
                    map[y][x] = INF;
                }
            }
        }

        for (int y = 0; y < M; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[s][e] = Math.min(c, map[s][e]);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }

        StringBuilder ansSB = new StringBuilder();

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                int n = map[y][x];
                ansSB.append(n == INF ? "0 " : (n + " "));
            }
            ansSB.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int n = map[i][j];
                if (n == 0) {
                    ansSB.append("0");
                } else {
                    LinkedList<Integer> list = new LinkedList<>();
                    tracePath(list, i, j);
                    ansSB.append(list.size() + " ");
                    for (int num : list) {
                        ansSB.append(num + " ");
                    }
                }
                ansSB.append("\n");
            }
        }
        System.out.println(ansSB);
    }

    public static void tracePath(LinkedList<Integer> list, int i, int j) {
        if (path[i][j] == 0) {
            list.addLast(i);
            list.addLast(j);
            return;
        }
        tracePath(list, i, path[i][j]);
        list.removeLast();
        tracePath(list, path[i][j], j);
    }
}
