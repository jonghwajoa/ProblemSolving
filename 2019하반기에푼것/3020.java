import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int N, H;

    public static void main(String[] argv) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        H = Integer.parseInt(line[1]) + 1;

        int[] bottom = new int[H];
        int[] top = new int[H];
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                bottom[v] += 1;
            } else {
                top[H - v] += 1;
            }
        }
        int[] sum = new int[H];

        int topAcc = 0;
        int bottomAcc = N / 2;
        int min = Integer.MAX_VALUE;
        int minCnt = 0;

        for (int i = 1; i < H; i++) {
            sum[i] = top[i] + bottomAcc + topAcc;
            bottomAcc -= bottom[i];
            topAcc += top[i];
            if (sum[i] < min) {
                min = sum[i];
                minCnt = 1;
            } else if (sum[i] == min) {
                minCnt += 1;
            }
        }

        System.out.println(min + " " + minCnt);
    }
}