import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] numberOfCase = new int[1000001];
    final static int ADD = 1;
    final static int SUB = 2;
    final static int MUL = 3;
    final static int DIV = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] number = new int[n];
        int[] operation = new int[n - 1];
        String[] line = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(line[i]);
        }

        line = sc.nextLine().split(" ");
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            int opNum = Integer.parseInt(line[i]);
            for (int j = 0; j < opNum; j++) {
                operation[idx] = i + 1;
                idx += 1;
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        do {
            int acc = number[0];
            for (int i = 0; i < n - 1; i++) {
                acc = calculation(acc, number[i + 1], operation[i]);

            }

            if (acc > max) {
                max = acc;
            }
            if (acc < min) {
                min = acc;
            }
        } while (next(operation));

        System.out.println(max);
        System.out.println(min);
    }

    public static int calculation(int n1, int n2, int op) {
        int calVal = 0;
        switch (op) {
        case ADD:
            calVal = n1 + n2;
            break;
        case SUB:
            calVal = n1 - n2;
            break;
        case MUL:
            calVal = n1 * n2;
            break;
        case DIV:
            calVal = (int) (n1 / n2);
            break;
        }
        return calVal;
    }

    public static boolean next(int[] input) {
        int i = input.length - 1;

        while (i > 0 && input[i - 1] >= input[i]) {
            i--;
        }

        if (i <= 0)
            return false;

        int j = input.length - 1;

        while (input[i - 1] >= input[j]) {
            j--;
        }

        int tmp = input[i - 1];
        input[i - 1] = input[j];
        input[j] = tmp;

        j = input.length - 1;

        while (i < j) {
            tmp = input[i];
            input[i] = input[j];
            input[j] = tmp;
            i++;
            j--;
        }
        return true;
    }
}
