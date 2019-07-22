
public class QuickSort {
    public void sort(int[] input) {
        quick(input, 0, input.length - 1);
    }

    private void quick(int[] input, int left, int right) {
        int mid = (left + right) / 2;
        int pivot = input[mid];
        int l = left;
        int r = right;

        while (l <= r) {
            while (input[l] < pivot) {
                l++;
            }

            while (pivot < input[r]) {
                r--;
            }

            if (l <= r) {
                int tmp = input[l];
                input[l] = input[r];
                input[r] = tmp;
                r--;
                l++;
            }
        }

        if (l < right) {
            quick(input, l, right);
        }

        if (left < r) {
            quick(input, left, r);
        }

    }
}
