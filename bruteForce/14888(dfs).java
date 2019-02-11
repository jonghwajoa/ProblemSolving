import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean[] visited = new boolean[10];
    final static int ADD = 1;
    final static int SUB = 2;
    final static int MUL = 3;
    final static int DIV = 4;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int[] op;
    static int[] numbers;
    static boolean[] isVisit;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());

        numbers = new int[n];
        op = new int[n - 1];
        isVisit = new boolean[n - 1];

        String[] line = sc.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        int index = 0;
        line = sc.nextLine().split(" ");
        for (int i = 0; i < 4; i++) {
            int tmp = Integer.parseInt(line[i]);
            for (int j = 0; j < tmp; j++) {
                op[index] = i + 1;
                index += 1;
            }
        }

        dfs(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int len, int acc) {
        if (len == n) {

            if (acc < min) {
                min = acc;
            }

            if (max < acc) {
                max = acc;
            }
        } else {
            for (int z = 0; z < n - 1; z++) {
                if (!isVisit[z]) {

                    int calResult = 0;
                    switch (op[z]) {
                    case ADD:
                        calResult = acc + numbers[len];
                        break;
                    case SUB:
                        calResult = acc - numbers[len];
                        break;
                    case MUL:
                        calResult = acc * numbers[len];
                        break;
                    case DIV:
                        calResult = (int) (acc / numbers[len]);
                        break;
                    }

                    isVisit[z] = true;
                    dfs(len + 1, calResult);
                    isVisit[z] = false;
                }
            }
        }
    }
}
