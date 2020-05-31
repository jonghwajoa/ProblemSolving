package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static long[] tree, inputs;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = atoi(st.nextToken());
    int M = atoi(st.nextToken());
    int K = atoi(st.nextToken());

    int H = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
    int SIZE = (int) Math.pow(2, H);

    inputs = new long[N];
    tree = new long[SIZE];

    for (int i = 0; i < N; i++) {
      inputs[i] = atol(br.readLine());
      update(1, 0, N - 1, i, inputs[i]);
    }

    for (int i = 0; i < M + K; i++) {
      st = new StringTokenizer(br.readLine());
      int mod = atoi(st.nextToken());

      // b -> c로 바꾼다
      if (mod == 1) {
        int b = atoi(st.nextToken());
        long c = atol(st.nextToken());
        b -= 1;
        long diff = c - inputs[b];
        inputs[b] = c;

        update(1, 0, N - 1, b, diff);
      } else {
        int b = atoi(st.nextToken());
        int c = atoi(st.nextToken());
        System.out.println(sum(1, 0, N - 1, b - 1, c - 1));
      }
    }
  }

  public static long sum(int index, int left, int right, int findLeft, int findRight) {
    if (right < findLeft || findRight < left) {
      return 0;
    }
    if (findLeft <= left && right <= findRight) {
      return tree[index];
    }

    int mid = (left + right) / 2;
    int lc = index << 1;
    int rc = lc + 1;

    long ls = sum(lc, left, mid, findLeft, findRight);
    long rs = sum(rc, mid + 1, right, findLeft, findRight);

    return ls + rs;
  }

  public static void update(int index, int left, int right, int target, long diff) {
    if (target < left || right < target) {
      return;
    }

    tree[index] += diff;
    if (left == right)
      return;

    int mid = (left + right) >> 1;
    int lc = index << 1;
    int rc = lc + 1;

    update(lc, left, mid, target, diff);
    update(rc, mid + 1, right, target, diff);
  }

  public static int atoi(String str) {
    return Integer.parseInt(str);
  }

  public static long atol(String str) {
    return Long.parseLong(str);
  }
}
