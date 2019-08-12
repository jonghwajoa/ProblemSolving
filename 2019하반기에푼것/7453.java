import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] argv) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int[] b = new int[N];
        int[] c = new int[N];
        int[] d = new int[N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            a[i] = Integer.parseInt(line[0]);
            b[i] = Integer.parseInt(line[1]);
            c[i] = Integer.parseInt(line[2]);
            d[i] = Integer.parseInt(line[3]);
        }

        HashMap<Integer, Long> map2 = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum1 = a[i] + b[j];
                int sum2 = c[i] + d[j];
                map2.put(sum2, map2.containsKey(sum2) ? map2.get(sum2) + 1 : 1);
            }
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum1 = a[i] + b[j];
                int addZero = sum1 * -1;
                if (map2.containsKey(addZero)) {
                    ans += map2.get(addZero);
                }
            }
        }

        System.out.println(ans);
    }
}
