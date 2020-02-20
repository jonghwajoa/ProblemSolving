import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  final static String NEW_LINE = "\n";
  static int N, TARGET;
  static int[] fences;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringBuilder ansSB = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = atoi(st.nextToken());
    int X = atoi(st.nextToken());

    fences = new int[N + 1];

    Deque<Integer> deque = new LinkedList<Integer>();
    st = new StringTokenizer(br.readLine());

    long total = 0; // 1,000,000 * 100,000 = 100,000,000,000
    for (int i = 0; i < N; i++) {
      fences[i] = atoi(st.nextToken());
      total += fences[i];
    }

    for (int i = 0; i < X; i++) {
      while (!deque.isEmpty() && fences[i] < fences[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.addLast(i);
    }

    int count = 0;
    long prevHeight = fences[deque.peek()];
    int prevIndex = 0;

    for (int i = X; i <= N; i++) {
      while (!deque.isEmpty() && fences[i] < fences[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.addLast(i);

      if (prevHeight != fences[deque.peek()]) {
        count += (i - prevIndex - 1) / X + 1;
        total -= (i - prevIndex) * prevHeight;
        prevIndex = i;
        prevHeight = fences[deque.peek()];
      }

      if (deque.peek() <= i - X) {
        int removeIdx = deque.poll();

        if (prevHeight != fences[deque.peek()]) {
          count += (removeIdx - prevIndex) / X + 1;
          total -= (removeIdx - prevIndex + 1) * prevHeight;
          prevHeight = fences[deque.peek()];
          prevIndex = removeIdx + 1;
        }
      }
    }

    System.out.println(total);
    System.out.println(count);
  }

  private static int atoi(String value) {
    return Integer.parseInt(value);
  }
}
