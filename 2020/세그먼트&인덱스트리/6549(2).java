package histogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  final static String NEW_LINE = "\n";
  static SegmentTree seg;
  static long max;
  static int N;
  static int[] inputs;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = atoi(st.nextToken());
      max = 0;
      if (N == 0) {
        break;
      }

      inputs = new int[N];
      for (int i = 0; i < N; i++) {
        inputs[i] = atoi(st.nextToken());
      }

      seg = new SegmentTree(inputs);
      recursive(0, N - 1);
      System.out.println(max);
    }
  }

  private static void recursive(int left, int right) {
    int index = seg.search(1, 0, N - 1, left, right);
    long width = right - left + 1;
    long size = width * inputs[index];

    max = Math.max(max, size);

    if (left <= index - 1) {
      recursive(left, index - 1);
    }

    if (index + 1 <= right) {
      recursive(index + 1, right);
    }
  }

  private static int atoi(String value) {
    return Integer.parseInt(value);
  }
}

class SegmentTree {
  int[] tree;
  int[] input;

  public SegmentTree(int[] input) {
    int N = input.length;
    int height = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
    int length = (int) Math.pow(2, height);
    this.tree = new int[length];
    this.input = input;
    makeSagmentTree(1, 0, N - 1);
  }

  private int makeSagmentTree(int root, int left, int right) {
    if (left == right) {
      return tree[root] = left;
    }

    int childLeft = root * 2;
    int childRight = root * 2 + 1;
    int mid = (left + right) / 2;

    int lv = makeSagmentTree(childLeft, left, mid);
    int rv = makeSagmentTree(childRight, mid + 1, right);

    if (input[lv] < input[rv]) {
      return tree[root] = lv;
    }
    return tree[root] = rv;
  }

  public int search(int root, int left, int right, int findLeft, int findRight) {
    if (right < findLeft || findRight < left) {
      return -1;
    }

    if (findLeft <= left && right <= findRight) {
      return tree[root];
    }

    int childLeft = root * 2;
    int childRight = root * 2 + 1;
    int mid = (left + right) / 2;
    int leftIndex = search(childLeft, left, mid, findLeft, findRight);
    int rightIndex = search(childRight, mid + 1, right, findLeft, findRight);
    if (leftIndex == -1) {
      return rightIndex;
    } else if (rightIndex == -1) {
      return leftIndex;
    }

    return input[leftIndex] < input[rightIndex] ? leftIndex : rightIndex;
  }
}
