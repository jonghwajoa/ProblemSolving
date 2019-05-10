import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4, 5 };

        System.out.println(Arrays.toString(solve(input)));
    }

    public static int[] solve(int[] input) {
        int[] newInt = new int[input.length];

        int acc = input[0];
        for (int i = 1; i < input.length; i++) {
            acc *= input[i];
        }

        for (int i = 0; i < input.length; i++) {
            newInt[i] = acc / input[i];
        }
        return newInt;
    }
}
