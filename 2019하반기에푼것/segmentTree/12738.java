import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = atoi(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> hashSet = new HashSet<>();

        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = atoi(st.nextToken());
            hashSet.add(input[i]);
        }

        Integer[] values = hashSet.toArray(new Integer[hashSet.size()]);
        Arrays.sort(values);
        HashMap<Integer, Integer> match = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            match.put(values[i], i + 1);
        }

        int size = hashSet.size();
        SegmentTree seg = new SegmentTree(size);
        int ans = 0;

        for (int i = 0; i < N; i++) {
            int index = match.get(input[i]);
            int v = seg.query(1, 0, size - 1, 0, index - 1) + 1;
            ans = Math.max(v, ans);
            seg.update(1, 0, size - 1, index, v);
        }
        System.out.println(ans);
    }

    private static int atoi(String string) {
        return Integer.parseInt(string);
    }
}

class SegmentTree {
    int[] tree;

    public SegmentTree(int n) {
        int height = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        int size = 1 << height;
        tree = new int[size];
    }

    public void update(int root, int left, int right, int target, int value) {
        if (target < left || right < target) {
            return;
        }

        tree[root] = Math.max(tree[root], value);

        if (left != right) {
            int mid = (left + right) >> 1;
            int leftChild = root * 2;
            int rightChild = leftChild + 1;
            update(leftChild, left, mid, target, value);
            update(rightChild, mid + 1, right, target, value);
        }
    }

    public int query(int root, int left, int right, int findLeft, int findRight) {
        if (findRight < left || right < findLeft) {
            return 0;
        }

        if (findLeft <= left && right <= findRight) {
            return tree[root];
        }

        int mid = (left + right) >> 1;
        int leftChild = root * 2;
        int rightChild = leftChild + 1;

        int leftV = query(leftChild, left, mid, findLeft, findRight);
        int rightV = query(rightChild, mid + 1, right, findLeft, findRight);
        return Math.max(leftV, rightV);
    }

}