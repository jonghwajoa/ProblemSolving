import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] candys;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());

    final int N = atoi(st.nextToken());
    final int M = atoi(st.nextToken());
    candys = new int[M];

    int MAX = Integer.MIN_VALUE;
    for (int i = 0; i < M; i++) {
      candys[i] = atoi(br.readLine());
      MAX = Math.max(MAX, candys[i]);
    }

    int l = 1;
    int r = MAX;
    while (l <= r) {
      int mid = (l + r) >> 1;
      if (isPossible(mid, N)) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    System.out.println(l);
  }

  private static boolean isPossible(int mid, int N) {
    int count = 0;

    // [1,10^9]
    for (int n : candys) {
      count += ((n - 1) / mid) + 1;
    }

    return count <= N;
  }

  private static int atoi(String string) {
    return Integer.parseInt(string);
  }

}
