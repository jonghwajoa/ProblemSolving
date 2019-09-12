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