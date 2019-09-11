import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = atoi(br.readLine());
        int[] value = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1,000,000,000 int
        // N 500,000 N^2은 무조건 터짐
        for (int i = 0; i < N; i++) {
            value[i] = atoi(st.nextToken());
        }

        Merge merge = new Merge();

        System.out.println(merge.sort(value));
    }

    private static int atoi(String string) {
        return Integer.parseInt(string);
    }

}

class Merge {
    long count = 0;

    public long sort(int[] arr) {
        divide(arr, 0, arr.length - 1);
        return count;
    }

    private void divide(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }

        int mid = (left + right) >> 1;

        divide(arr, left, mid);
        divide(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;

        int size = right - left + 1;
        int[] tmps = new int[size];
        int index = 0;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                tmps[index++] = arr[l++];
            } else {
                tmps[index++] = arr[r++];
                count += mid - l + 1;
            }
        }

        if (l <= mid) {
            for (int i = l; i <= mid; i++) {
                tmps[index++] = arr[i];
            }
        } else {
            for (int i = r; i <= right; i++) {
                tmps[index++] = arr[i];
            }
        }

        for (int i = 0; i < size; i++) {
            arr[i + left] = tmps[i];
        }
    }
}

class SegmentTree {
    int[] value;
    int[] tree;

    public SegmentTree(int[] value, int stand) {
        this.value = value;
        int len = value.length;
        int height = (int) Math.ceil(Math.log(len) / Math.log(2)) + 1;
        int size = 1 << height;
        tree = new int[size];
        this.makeSeg(1, 0, len - 1, stand);
    }

    private int makeSeg(int root, int left, int right, int stand) {
        if (left == right) {
            tree[root] = value[left];
            return tree[root] < stand ? 0 : 1;
        }

        int leftChild = root << 1;
        int rightChild = leftChild + 1;
        int mid = (left + right) / 2;

        int sum = makeSeg(leftChild, left, mid, stand);
        sum += makeSeg(rightChild, mid + 1, right, stand);
        tree[root] = sum;
        return sum;
    }

    public int query(int root, int left, int right, int findLeft, int findRight) {
        if (findRight < left || right < findLeft) {
            return 0;
        }

        if (findLeft <= left && right < findRight) {
            return tree[root];
        }

        int leftChild = root << 1;
        int rightChild = leftChild + 1;
        int mid = (left + right) / 2;

        int sum = query(leftChild, left, mid, findLeft, findRight);
        return sum + query(rightChild, mid + 1, right, findLeft, findRight);
    }

}
