import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] card = new boolean[N];

        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        int index = 0;
        int sum = 0;
        while (sum != N) {
            if (!card[index]) {
                if (cnt == 0) {
                    card[index] = true;
                    sb.append(index + 1 + " ");
                    sum += 1;
                }
                cnt = (cnt + 1) % 2;
            }
            index = (index + 1) % N;
        }

        System.out.println(sb.toString());
    }
}
