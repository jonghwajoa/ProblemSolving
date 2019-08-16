import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] argv) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long x = Long.parseLong(input[0]);
        long y = Long.parseLong(input[1]);

        int curZ = getWinPercent(x, y);
        if (curZ >= 99) {
            System.out.println(-1);
            return;
        }

        int l = 0;
        int r = 1000000001;
        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (curZ < getWinPercent(x + mid, y + mid)) {
                if (mid < ans) {
                    ans = mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(ans);
    }

    private static int getWinPercent(long x, long y) {
        return (int) ((y * 100) / (double) x);
    }
}
