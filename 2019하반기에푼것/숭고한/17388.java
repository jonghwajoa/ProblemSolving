import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] argv) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] name = { "Soongsil", "Korea", "Hanyang" };

        int minIndex = 0;
        int min = atoi(st.nextToken());
        int acc = min;

        for (int i = 1; i < 3; i++) {
            int value = atoi(st.nextToken());
            acc += value;
            if (value < min) {
                min = value;
                minIndex = i;
            }
        }

        System.out.println(acc < 100 ? name[minIndex] : "OK");
    }

    private static int atoi(String string) {
        return Integer.parseInt(string);
    }
}