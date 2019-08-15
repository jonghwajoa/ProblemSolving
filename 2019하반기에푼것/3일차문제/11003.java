import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] argv) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int stIdx = 0, edIdx = 0;
        int[] deque = new int[N];
        int[] input = new int[N];
        int[] result = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            while (stIdx != edIdx && input[i] < input[deque[edIdx - 1]]) {
                edIdx -= 1;
            }
            deque[edIdx++] = i;
            if (deque[stIdx] < i - L + 1) {
                stIdx += 1;
            }

            result[i] = input[deque[stIdx]];
        }
        for (int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();

    }
}
