import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    final static int MAX_LINE = 6;

    public static void main(String[] argv) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] pqArr = new PriorityQueue[MAX_LINE];
        for (int i = 0; i < MAX_LINE; i++) {
            pqArr[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
        }

        int ans = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken()) - 1;
            int pressedFret = Integer.parseInt(st.nextToken());
            while (!pqArr[line].isEmpty() && pressedFret < pqArr[line].peek()) {
                pqArr[line].poll();
                ans += 1;
            }
            if (pqArr[line].isEmpty() || pqArr[line].peek() != pressedFret) {
                pqArr[line].add(pressedFret);
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}