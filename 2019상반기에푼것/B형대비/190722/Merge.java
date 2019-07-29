
public class Merge {
    public void sort(int[] input) {
        merge(input, 0, input.length - 1);
    }

    private void merge(int[] input, int left, int right) {
        if (right <= left) {
            return;
        }

        int mid = (left + right) / 2;
        merge(input, left, mid);
        merge(input, mid + 1, right);

        int l = left;
        int r = mid + 1;
        int len = right - left + 1;
        int[] tmp = new int[len];
        int idx = 0;

        while (l <= mid && r <= right) {
            if (input[l] < input[r]) {
                tmp[idx++] = input[l];
                l++;
            } else {
                tmp[idx++] = input[r];
                r++;
            }
        }
        if (l <= mid) {
            while (l <= mid) {
                tmp[idx++] = input[l];
                l++;
            }
        } else {
            while (r <= right) {
                tmp[idx++] = input[r];
                r++;
            }
        }

        for (int i = 0; i < len; i++) {
            input[left + i] = tmp[i];
        }
    }
}
