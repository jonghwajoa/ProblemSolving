import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws Exception {
        int[] arr = getReadline();
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        int[] ans = new int[max + 1];

        int cnt = 3;
        for (int y = 1; y <= max; y++) {
            for (int x = 1; x < y; x++) {
                if (gcd(x, y) == 1) {
                    cnt += 2;
                }
            }
            ans[y] = cnt;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(ans[arr[i]] + "\n");
        }
        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int remain = a % b;
        while (remain != 0) {
            a = b;
            b = remain;
            remain = a % b;
        }
        return b;
    }

    private static int[] getReadline() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        return arr;
    }
}