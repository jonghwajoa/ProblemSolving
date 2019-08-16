import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    final static int MAX_LINE = 6;
    final static int MAX_FRET = 300000;

    public static void main(String[] argv) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        VioletStack[] stack = new VioletStack[MAX_LINE];
        for (int i = 0; i < MAX_LINE; i++) {
            stack[i] = new VioletStack();
        }

        int ans = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken()) - 1;
            int pressedFret = Integer.parseInt(st.nextToken());

            VioletStack curStack = stack[line];
            if (curStack.size == 0) {
                ans += 1;
                curStack.fret[curStack.size++] = pressedFret;
            } else {
                while (curStack.size != 0 && pressedFret < curStack.fret[curStack.size - 1]) {
                    curStack.size -= 1;
                    ans += 1;
                }

                if (curStack.size == 0 || curStack.fret[curStack.size - 1] != pressedFret) {
                    ans += 1;
                    curStack.fret[curStack.size++] = pressedFret;
                }
            }
        }
        System.out.println(ans);
    }
}

class VioletStack {
    int[] fret = new int[300000];
    int size = 0;
}