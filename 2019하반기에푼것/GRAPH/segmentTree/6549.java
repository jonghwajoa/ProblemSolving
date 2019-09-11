import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long max;
    static SegmentTree seg;
    static long[] input;

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder ansSB = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = atoi(st.nextToken());
            if (N == 0) {
                break;
            }

            Queue<Integer> zero = new LinkedList<>();
            input = new long[N];
            for (int i = 0; i < N; i++) {
                input[i] = atol(st.nextToken());
                if (input[i] == 0) {
                    zero.add(i);
                }
            }

            max = Long.MIN_VALUE;
            seg = new SegmentTree(input);

            recursive(0, N - 1);
            ansSB.append(max).append("\n");
        }
        System.out.println(ansSB.toString());
    }

    public static void recursive(int left, int right) {
        int idx = seg.query(1, 0, N - 1, left, right);
        long width = (long) (right - left + 1);
        long size = width * input[idx];

        if (max < size) {
            max = size;
        }

        if (left <= idx - 1) {
            recursive(left, idx - 1);
        }
        if (idx + 1 <= right) {
            recursive(idx + 1, right);
        }
    }

    private static int atoi(String string) {
        return Integer.parseInt(string);
    }

    private static long atol(String string) {
        return Long.parseLong(string);
    }
}

class SegmentTree {
    long[] input;
    int[] tree;

    public SegmentTree(long[] input) {
        this.input = input;
        int len = input.length;
        int height = (int) Math.ceil(Math.log(len) / Math.log(2));
        int size = (int) Math.pow(2, height + 1);
        this.tree = new int[size];
        this.makeSeg(1, 0, len - 1);
    }

    private int makeSeg(int root, int left, int right) {
        if (left == right) {
            return this.tree[root] = left;
        }

        int leftChild = root * 2;
        int rightChild = leftChild + 1;
        int mid = (left + right) / 2;

        int lv = makeSeg(leftChild, left, mid);
        int rv = makeSeg(rightChild, mid + 1, right);

        if (input[lv] < input[rv]) {
            return tree[root] = lv;
        }
        return tree[root] = rv;
    }

    public int query(int root, int left, int right, int findLeft, int findRight) {
        if (findRight < left || right < findLeft) {
            return -1;
        }

        if (findLeft <= left && right <= findRight) {
            return tree[root];
        }
        int leftChild = root * 2;
        int rightChild = leftChild + 1;
        int mid = (left + right) / 2;

        int li = query(leftChild, left, mid, findLeft, findRight);
        int ri = query(rightChild, mid + 1, right, findLeft, findRight);
        if (li == -1) {
            return ri;
        } else if (ri == -1) {
            return li;
        }
        if (input[li] < input[ri]) {
            return li;
        }
        return ri;
    }
}
