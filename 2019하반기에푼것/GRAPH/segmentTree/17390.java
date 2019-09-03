import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// Q LOG N  -> 5,458,380 * 2 = 천만..?
// Q 300,000
// N 300,000 
// LOG N -> 18.2

class Main {
    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = atoi(st.nextToken());
        int Q = atoi(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = atoi(st.nextToken());
        }

        Arrays.sort(input);

        StringBuilder ansSB = new StringBuilder();
        Segment seg = new Segment(input);
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int left = atoi(st.nextToken()) - 1;
            int right = atoi(st.nextToken()) - 1;
            ansSB.append(seg.query(1, 0, N - 1, left, right) + "\n");
        }
        System.out.println(ansSB);
    }

    private static int atoi(String string) {
        return Integer.parseInt(string);
    }
}

class Segment {
    private int[] input;
    private int[] tree;

    public Segment(int[] input) {
        this.input = input;
        int len = input.length;

        int height = (int) (Math.ceil(Math.log(len) / Math.log(2))) + 1;
        int size = 1 << height;
        this.tree = new int[size];
        this.makeSegTree(1, 0, len - 1);
    }

    private void makeSegTree(int root, int left, int right) {
        if (left == right) {
            tree[root] = input[left];
            return;
        }

        int leftChild = root * 2;
        int rightChild = leftChild + 1;
        int mid = (left + right) / 2;

        makeSegTree(leftChild, left, mid);
        makeSegTree(rightChild, mid + 1, right);
        tree[root] = tree[leftChild] + tree[rightChild];
    }

    public int query(int root, int left, int right, int findLeft, int findRight) {
        if (findRight < left || right < findLeft) {
            return 0;
        }

        if (findLeft <= left && right <= findRight) {
            return tree[root];
        }

        int childLeft = root * 2;
        int childRight = childLeft + 1;
        int mid = (left + right) / 2;
        int sum = query(childLeft, left, mid, findLeft, findRight);
        return sum + query(childRight, mid + 1, right, findLeft, findRight);
    }
}