import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] inputs;

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        K = atoi(st.nextToken());

        inputs = new int[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = atoi(br.readLine());
        }

        Arrays.sort(inputs);

        int l = 0;
        int r = 1000000000;
        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (isPossible(mid)) {
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

    private static boolean isPossible(int mid) {
        int count = 1;
        int stand = inputs[0];
        int range = 2 * mid;
        for (int i = 1; i < N; i++) {
            if (stand + range < inputs[i]) {
                count += 1;
                stand = inputs[i];
                if (K < count) {
                    return false;
                }
            }
        }

        return count <= K;
    }

    private static int atoi(String string) {
        return Integer.parseInt(string);
    }
}
