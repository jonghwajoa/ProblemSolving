import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int[] input = new int[5];
            int[] input2 = new int[5];
            for (int j = 0; j < 5; j++) {
                input[j] = sc.nextInt();
            }

            for (int j = 0; j < 5; j++) {
                input2[j] = sc.nextInt();
            }

            Arrays.sort(input);
            Arrays.sort(input2);

            int fIdx = 0;
            int sIdx = 0;
            int ans = 0;
            for (int j = 0; j < 8; j++) {
                if (fIdx == 5) {
                    ans = input2[sIdx];
                    sIdx += 1;
                } else if (sIdx == 5) {
                    ans = input[fIdx];
                    fIdx += 1;
                } else {
                    if (input[fIdx] < input2[sIdx]) {
                        ans = input[fIdx];
                        fIdx += 1;
                    } else {
                        ans = input2[sIdx];
                        sIdx += 1;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
