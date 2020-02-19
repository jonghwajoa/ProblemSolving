import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  final static String NEW_LINE = "\n";
  static ArrayList<Pair> list[], ans;
  static int orders[];
  static int order;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = atoi(st.nextToken());
    int M = atoi(st.nextToken());

    list = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = atoi(st.nextToken());
      int b = atoi(st.nextToken());
      list[a].add(new Pair(b, i));
      list[b].add(new Pair(a, i));
    }

    orders = new int[N + 1];
    ans = new ArrayList<Pair>();
    order = 0;

    for (int i = 1; i <= N; i++) {
      if (orders[i] == 0) {
        dfs(i, 0);
      }
    }

    Collections.sort(ans);
    for (int i = 0; i < ans.size(); i++) {
      Pair p = ans.get(i);
      sb.append(p.e + " " + p.index).append(NEW_LINE);
    }

    System.out.println(ans.size());
    System.out.println(sb.toString());
  }

  public static int dfs(int node, int parent) {
    orders[node] = ++order;
    int low = orders[node];

    for (Pair p : list[node]) {
      if (parent == p.e) {
        continue;
      }

      if (orders[p.e] == 0) {
        int childLow = dfs(p.e, node);
        if (orders[node] < childLow) {
          int a = node;
          int b = p.e;
          if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
          }
          ans.add(new Pair(a, b));
        }
        low = Math.min(low, childLow);
      } else {
        low = Math.min(low, orders[p.e]);
      }
    }

    return low;
  }

  public static int atoi(String string) {
    return Integer.parseInt(string);
  }
}

class Pair implements Comparable<Pair> {
  int e;
  int index;

  public Pair(int e, int index) {
    this.e = e;
    this.index = index;
  }

  @Override
  public int compareTo(Pair o) {
    if (this.e == o.e) {
      return this.index - o.index;
    }
    return this.e - o.e;
  }

}