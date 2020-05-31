import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] inputs = new int[N];
    for (int i = 0; i < N; i++) {
      inputs[i] = Integer.parseInt(br.readLine());
    }

    quickSort(inputs, 0, N - 1);
    System.out.println(Arrays.toString(inputs));
  }

  public static void quickSort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }

    int mid = (left + right) / 2;
    int pivot = arr[mid];
    int l = left;
    int r = right;
    while (l <= r) {
      while (arr[l] < pivot) {
        l++;
      }
      while (pivot < arr[r]) {
        r--;
      }

      if (l <= r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
        l++;
        r--;
      }
    }

    if (l < right) {
      quickSort(arr, l, right);
    }
    if (left < r) {
      quickSort(arr, left, r);
    }
  }
}
