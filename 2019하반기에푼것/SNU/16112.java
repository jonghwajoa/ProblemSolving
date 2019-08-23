import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());
        int[] input = new int[N];

        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < N; i++) {
            input[i] = stoi(st.nextToken());
            sum += input[i];
        }

        // nlog(n) 5,458,380
        // n <= 300,000
        // v <= 100,000,000
        Arrays.sort(input);

        // v * k = 300,000,000,000,000
        long ans = 0;
        int index = 0;
        while (K - index > 0) {
            sum -= input[index++];
            ans += sum;
        }

        System.out.println(ans);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}