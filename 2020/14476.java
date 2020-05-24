import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = atoi(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      int input = atoi(st.nextToken());
      arr[i] = input;
    }

    int[] left = new int[N];
    int[] right = new int[N];

    left[0] = arr[0];
    right[N - 1] = arr[N - 1];

    for (int i = 1; i < N; i++) {
      left[i] = getGcd(left[i - 1], arr[i]);
    }

    for (int i = N - 2; i >= 0; i--) {
      right[i] = getGcd(right[i + 1], arr[i]);
    }

    int[] ans = new int[N];
    ans[0] = right[1];
    ans[N - 1] = left[N - 2];

    for (int i = 1; i < N - 1; i++) {
      int gcd = getGcd(left[i - 1], right[i + 1]);
      ans[i] = gcd;
    }

    boolean check = false;
    int max = Integer.MIN_VALUE;
    int index = arr[0];
    int stand = ans[0];
    for (int i = 0; i < N; i++) {
      if (stand != ans[i]) {
        check = true;
      }
      if (max < ans[i]) {
        max = ans[i];
        index = arr[i];
      }
    }

    if (check) {
      System.out.println(max + " " + index);
    } else {
      System.out.println(-1);
    }
  }

  private static int getGcd(int a, int b) {
    if (b < a) {
      int tmp = a;
      a = b;
      b = tmp;
    }

    int remain = b % a;
    while (remain != 0) {
      b = a;
      a = remain;
      remain = b % a;
    }

    return a;
  }

  private static int atoi(String string) {
    return Integer.parseInt(string);
  }

}
