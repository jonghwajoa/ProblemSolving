import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static MinAndMax[] tree;
    static int[] input;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        final int depth = (int) Math.ceil(Math.log(N) / Math.log(2));
        final int height = depth + 1;
        final int MAX_SIZE = (int) Math.pow(2, height);
        tree = new MinAndMax[MAX_SIZE];
        input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        makeSegment(1, 0, N - 1);
        StringBuilder ansSB = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            MinAndMax res = query(1, 0, N - 1, l, r);
            ansSB.append(res.min + " " + res.max + "\n");
        }
        System.out.println(ansSB);
    }

    public static void makeSegment(int root, int left, int right) {
        if (left == right) {
            tree[root] = new MinAndMax(input[left]);
            return;
        }

        int childLeft = root * 2;
        int childRight = root * 2 + 1;
        int mid = (left + right) / 2;

        makeSegment(childLeft, left, mid);
        makeSegment(childRight, mid + 1, right);
        int min = Math.min(tree[childLeft].min, tree[childRight].min);
        int max = Math.max(tree[childLeft].max, tree[childRight].max);
        tree[root] = new MinAndMax(max, min);
    }

    public static MinAndMax query(int root, int left, int right, int findLeft, int findRight) {
        // 찾는 구간이 아닌경우
        if (right < findLeft || findRight < left) {
            return null;
        }
        // 현재구간이 완전히 포함되는 경우
        if (findLeft <= left && right <= findRight) {
            return tree[root];
        }
        int childLeft = root * 2;
        int childRight = root * 2 + 1;
        int mid = (left + right) / 2;
        MinAndMax leftQuery = query(childLeft, left, mid, findLeft, findRight);
        MinAndMax rightQuery = query(childRight, mid + 1, right, findLeft, findRight);
        if (leftQuery == null) {
            return rightQuery;
        } else if (rightQuery == null) {
            return leftQuery;

        }
        int min = Math.min(leftQuery.min, rightQuery.min);
        int max = Math.max(leftQuery.max, rightQuery.max);
        return new MinAndMax(max, min);
    }
}

class MinAndMax {
    int max;
    int min;

    public MinAndMax(int v) {
        this.max = v;
        this.min = v;
    }

    public MinAndMax(int max, int min) {
        this.max = max;
        this.min = min;
    }
}
