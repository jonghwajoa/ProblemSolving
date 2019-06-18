import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        int[] arr = { 3, 1, 5, 6 };
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] input) {
        divide(input, 0, input.length - 1);
    }

    public static void divide(int[] input, int left, int right) {
        if (right <= left) {
            return;
        }

        int mid = (left + right) / 2;
        divide(input, left, mid);
        divide(input, mid + 1, right);

        int l = left;
        int r = mid + 1;
        int[] tempArr = new int[right - left + 1];
        int index = 0;

        while (l <= mid && r <= right) {
            if (input[l] <= input[r]) {
                tempArr[index++] = input[l++];
            } else {
                tempArr[index++] = input[r++];
            }
        }

        if (l <= mid) {
            while (l <= mid) {
                tempArr[index++] = input[l++];
            }
        } else {
            while (r <= right) {
                tempArr[index++] = input[r++];
            }
        }

        for (int i = 0; i < tempArr.length; i++) {
            input[left++] = tempArr[i];
        }
    }

}
