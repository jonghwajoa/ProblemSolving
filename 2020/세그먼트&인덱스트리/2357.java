package minandmax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  final static String NEW_LINE = "\n";

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringBuilder ansSB = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = atoi(st.nextToken());
    int M = atoi(st.nextToken());
    int[] inputs = new int[N];

    for (int i = 0; i < N; i++) {
      inputs[i] = atoi(br.readLine());
    }

    SegmentTree seg = new SegmentTree(inputs);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = atoi(st.nextToken()) - 1;
      int e = atoi(st.nextToken()) - 1;
      MaxAndMin ans = seg.search(1, 0, N - 1, s, e);
      ansSB.append(ans.min + " " + ans.max).append(NEW_LINE);
    }
    System.out.println(ansSB.toString());
  }

  private static int atoi(String value) {
    return Integer.parseInt(value);
  }
}

class MaxAndMin {
  int min;
  int max;

  public MaxAndMin(int min, int max) {
    this.min = min;
    this.max = max;
  }

}

class SegmentTree {
  int[] inputs;
  MaxAndMin[] tree;

  public SegmentTree(int[] inputs) {
    this.inputs = inputs;
    int len = inputs.length;
    int level = (int) Math.ceil(Math.log(len) / Math.log(2)) + 1;
    int size = (int) Math.pow(2, level);
    tree = new MaxAndMin[size];
    makeTree(1, 0, len - 1);
  }

  private void makeTree(int root, int left, int right) {
    if (left == right) {
      tree[root] = new MaxAndMin(inputs[left], inputs[right]);
      return;
    }

    int childLeft = root * 2;
    int childRight = root * 2 + 1;
    int mid = (left + right) / 2;

    makeTree(childLeft, left, mid);
    makeTree(childRight, mid + 1, right);

    int max = Math.max(tree[childLeft].max, tree[childRight].max);
    int min = Math.min(tree[childLeft].min, tree[childRight].min);
    tree[root] = new MaxAndMin(min, max);
  }

  public MaxAndMin search(int root, int left, int right, int findLeft, int findRight) {
    if (right < findLeft || findRight < left) {
      return null;
    }

    if (findLeft <= left && right <= findRight) {
      return tree[root];
    }

    int childLeft = root << 1;
    int childRight = childLeft + 1;
    int mid = (left + right) >> 1;

    MaxAndMin lr = search(childLeft, left, mid, findLeft, findRight);
    MaxAndMin rr = search(childRight, mid + 1, right, findLeft, findRight);
    if (lr == null) {
      return rr;
    } else if (rr == null) {
      return lr;
    }

    int max = Math.max(lr.max, rr.max);
    int min = Math.min(lr.min, rr.min);
    return new MaxAndMin(min, max);
  }
}
