import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = atoi(st.nextToken());
    int M = atoi(st.nextToken());
    int K = atoi(st.nextToken());

    int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
    int size = (int) Math.pow(2, h);
    long[] tree = new long[size];

    int s = 1;

    while (s < N) {
      s *= 2;
    }

    for (int i = 0; i < N; i++) {
      tree[s + i] = atol(br.readLine());
    }

    for (int i = s - 1; i > 0; i--) {
      tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    StringBuilder sb = new StringBuilder();
    int sum = M + K;
    for (int i = 0; i < sum; i++) {
      st = new StringTokenizer(br.readLine());
      int a = atoi(st.nextToken());
      int b = atoi(st.nextToken());
      int c = atoi(st.nextToken());
      if (a == 1) {

        long diff = c - tree[s + b - 1];
        update(tree, b + s - 1, diff);
      } else {
        sb.append(sum(tree, s + b - 1, s + c - 1)).append("\n");
      }
    }

    System.out.println(sb.toString());

  }

  private static long sum(long[] tree, int left, int right) {
    long acc = 0;
    while (left <= right) {
      if (left % 2 == 1) {
        acc += tree[left];
      }
      if (right % 2 == 0) {
        acc += tree[right];
      }

      left = (left + 1) / 2;
      right = (right - 1) / 2;
    }
    return acc;
  }

  private static void update(long[] tree, int index, long val) {
    while (index > 0) {
      tree[index] += val;
      index /= 2;
    }
  }

  private static int atoi(String string) {
    return Integer.parseInt(string);
  }

  private static long atol(String string) {
    return Long.parseLong(string);
  }
}
