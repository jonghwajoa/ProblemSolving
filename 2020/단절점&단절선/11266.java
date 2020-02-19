package cutting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  final static String NEW_LINE = "\n";
  static int[] childs, lows, orders;
  static int order;
  static ArrayList<Integer>[] list;
  static boolean[] isCutting;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = atoi(st.nextToken());
    int M = atoi(st.nextToken());
    list = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      list[i] = new ArrayList();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = atoi(st.nextToken());
      int e = atoi(st.nextToken());
      list[s].add(e);
      list[e].add(s);
    }

    orders = new int[N + 1];
    childs = new int[N + 1];
    lows = new int[N + 1];
    isCutting = new boolean[N + 1];

    order = 0;
    for (int i = 1; i <= N; i++) {
      if (orders[i] == 0) {
        dfs(i, true);
      }
    }

    StringBuilder sb = new StringBuilder();
    int count = 0;
    for (int i = 1; i <= N; i++) {
      if (isCutting[i]) {
        sb.append(i + " ");
        count += 1;
      }
    }
    System.out.println(count);
    System.out.println(sb.toString());
  }

  public static void dfs(int index, boolean isRoot) {
    orders[index] = ++order;
    lows[index] = orders[index];

    int childCount = 0;
    for (int n : list[index]) {
      if (orders[n] != 0) {
        lows[index] = Math.min(lows[index], orders[n]);
      } else {
        dfs(n, false);
        if (orders[index] <= lows[n]) {
          isCutting[index] = true;
        }
        lows[index] = Math.min(lows[index], lows[n]);

        childCount += 1;
      }

      if (isRoot) {
        isCutting[index] = childCount >= 2 ? true : false;
      }
    }
  }

  public static int atoi(String string) {
    return Integer.parseInt(string);
  }

}
