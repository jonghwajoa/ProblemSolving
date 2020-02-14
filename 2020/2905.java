package fense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  final static String NEW_LINE = "\n";
  static int N, TARGET;
  static int[] fenses;
  static int[] covers;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringBuilder ansSB = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = atoi(st.nextToken());
    int X = atoi(st.nextToken());

    fenses = new int[N];
    covers = new int[N];

    Deque<Integer> deque = new LinkedList<Integer>();
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      fenses[i] = atoi(st.nextToken());
    }

    for (int i = 0; i < X - 1; i++) {
      while (!deque.isEmpty() && fenses[i] <= fenses[deque.peek()]) {
        deque.removeFirst();
      }
      deque.add(i);
    }

    // 뒤에서 보기
    for (int i = X - 1; i < N; i++) {
      while (!deque.isEmpty()) {
        int peekIndex = deque.peek();
        if (fenses[i] <= fenses[peekIndex] || peekIndex < (i - X + 1)) {
          deque.removeFirst();
        } else {
          break;
        }
      }
      deque.addLast(i);
      covers[i - X + 1] = fenses[deque.peek()];
    }

    int last = covers[N - X];
    for (int i = N - X; i < N; i++) {
      covers[i] = last;
    }

    long unColorbleCount = 0;
    for (int i = 0; i < N; i++) {
      unColorbleCount += fenses[i] - covers[i];
    }

    int h = covers[0];
    int successiveDegree = 1;
    int rollCount = 1;
    for (int i = 1; i < N; i++) {
      if (successiveDegree == X || h != covers[i]) {
        successiveDegree = 1;
        h = covers[i];
        rollCount += 1;
      } else {
        successiveDegree += 1;
      }
    }

    System.out.println(unColorbleCount);
    System.out.println(rollCount);
  }

  private static int atoi(String value) {
    return Integer.parseInt(value);
  }
}
