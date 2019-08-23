import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicBorders.FieldBorder;

class Main {
    static int N, M;
    static int[] tree, input;

    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        final int depth = (int) Math.ceil(Math.log(N) / Math.log(2));
        final int height = depth + 1;
        final int MAX_SIZE = (int) Math.pow(2, height);
        tree = new int[MAX_SIZE];
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
            ansSB.append(query(1, 0, N - 1, l, r) + "\n");
        }           
        System.out.println(ansSB);
    }

    public static void makeSegment(int root, int left, int right) {
        if (left == right) {
            tree[root] = input[left];
            return;
        }

        int childLeft = root * 2;
        int childRight = root * 2 + 1;
        int mid = (left + right) / 2;

        makeSegment(childLeft, left, mid);
        makeSegment(childRight, mid + 1, right);
        tree[root] = Math.min(tree[childLeft], tree[childRight]);
    }

    public static int query(int root, int left, int right, int findLeft, int findRight) {
        // 찾는 구간이 아닌경우
        if (right < findLeft || findRight < left) {
            return -1;
        }
        // 현재구간이 완전히 포함되는 경우
        if (findLeft <= left && right <= findRight) {
            return tree[root];
        }
        int childLeft = root * 2;
        int childRight = root * 2 + 1;
        int mid = (left + right) / 2;
        int leftQuery = query(childLeft, left, mid, findLeft, findRight);
        int rightQuery = query(childRight, mid + 1, right, findLeft, findRight);
        if (leftQuery == -1) {
            return rightQuery;
        } else if (rightQuery == -1) {
            return leftQuery;
        }
        return Math.min(leftQuery, rightQuery);
    }
}