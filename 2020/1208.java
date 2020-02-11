package subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  final static String NEW_LINE = "\n";
  static int N, TARGET;
  static int[] cards;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringBuilder ansSB = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = atoi(st.nextToken());
    TARGET = atoi(st.nextToken());

    st = new StringTokenizer(br.readLine());
    cards = new int[N];
    for (int i = 0; i < N; i++) {
      cards[i] = atoi(st.nextToken());
    }

    ArrayList<Integer> leftCompoundNumbers = new ArrayList<>();
    ArrayList<Integer> rightCompoundNumbers = new ArrayList<>();

    combineNumbersUseRecursive(0, N / 2, 0, leftCompoundNumbers);
    combineNumbersUseRecursive(N / 2, N, 0, rightCompoundNumbers);

    Collections.sort(leftCompoundNumbers);
    Collections.sort(rightCompoundNumbers);

    int leftIndex = 0;
    int leftLength = leftCompoundNumbers.size();
    int rightIndex = rightCompoundNumbers.size() - 1;
    long ans = 0;

    while (leftIndex < leftLength && 0 <= rightIndex) {
      long leftValue = leftCompoundNumbers.get(leftIndex);
      long rightValue = rightCompoundNumbers.get(rightIndex);
      long sum = leftValue + rightValue;

      if (sum == TARGET) {
        long leftCount = 0;
        while (leftIndex < leftLength && leftCompoundNumbers.get(leftIndex) == leftValue) {
          leftCount += 1;
          leftIndex += 1;
        }

        long rightCount = 0;
        while (0 <= rightIndex && rightCompoundNumbers.get(rightIndex) == rightValue) {
          rightCount += 1;
          rightIndex -= 1;
        }

        ans += leftCount * rightCount;

      } else if (sum < TARGET) {
        leftIndex += 1;
      } else if (sum > TARGET) {
        rightIndex -= 1;
      }

    }

    if (TARGET == 0) {
      ans -= 1;
    }

    ansSB.append(ans).append(NEW_LINE);
    System.out.println(ansSB.toString());
  }

  private static void combineNumbersUseRecursive(int cur, int end, int acc, ArrayList<Integer> list) {
    if (end <= cur) {
      list.add(acc);
      return;
    }

    combineNumbersUseRecursive(cur + 1, end, acc, list);
    combineNumbersUseRecursive(cur + 1, end, acc + cards[cur], list);
  }

  private static int atoi(String value) {
    return Integer.parseInt(value);
  }
}
