
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  final static String NEW_LINE = "\n";
  static ArrayList<Integer> list[];
  static int orders[];
  static int order;
  static boolean ans[];

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = atoi(st.nextToken());
    int M = atoi(st.nextToken());

    orders = new int[N + 1];
    order = 0;
    ans = new boolean[N + 1];
    list = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = atoi(st.nextToken());
      int b = atoi(st.nextToken());
      list[a].add(b);
      list[b].add(a);
    }

    for (int i = 1; i <= N; i++) {
      if (orders[i] == 0) {
        dfs(i, true);
      }
    }

    int count = 0;
    for (int i = 1; i <= N; i++) {
      if (ans[i]) {
        count += 1;
        sb.append(i + " ");
      }
    }
    System.out.println(count);
    System.out.println(sb.toString());

  }

  public static int dfs(int node, boolean isRoot) {
    orders[node] = ++order;
    int low = orders[node];

    int childCount = 0;
    for (int n : list[node]) {
      if (orders[n] != 0) {
        low = Math.min(low, orders[n]);
      } else {
        int childLow = dfs(n, false);
        childCount += 1;
        low = Math.min(low, childLow);
        if (orders[node] <= childLow) {
          ans[node] = true;
        }
      }
    }

    if (isRoot) {
      ans[node] = childCount >= 2 ? true : false;
    }
    return low;
  }

  public static int atoi(String string) {
    return Integer.parseInt(string);
  }
}
